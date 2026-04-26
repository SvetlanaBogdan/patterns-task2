package ru.netology.delivery.api;

import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class ApiHelper {

    // настройки запроса
    private static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost") // адрес
            .setPort(9999)                  // порт
            .setAccept(JSON)                // что принимаем
            .setContentType(JSON)           // что отправляем
            .log(io.restassured.filter.log.LogDetail.ALL) // 🔥 ЛОГИ (как в задании)
            .build();

    // отправка пользователя в API
    public static void sendUser(Object user) {
        given()
                .spec(requestSpec) // настройки
                .body(user)        // объект → JSON
                .when()
                .post("/api/system/users") // endpoint из задания
                .then()
                .statusCode(200); // ожидаем успех
    }
}