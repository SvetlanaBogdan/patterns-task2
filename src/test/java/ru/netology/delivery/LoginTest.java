package ru.netology.delivery;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.delivery.data.DataGenerator;
import ru.netology.delivery.data.RegistrationDto;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginTest {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "http://localhost:9999";
    }

    @Test
    void shouldLoginActiveUser() {
        // создаём и регистрируем пользователя через API
        RegistrationDto user = DataGenerator.getRegisteredUser("active");

        // открываем страницу
        open("/");

        // вводим данные
        $("[data-test-id=login] input").setValue(user.getLogin());
        $("[data-test-id=password] input").setValue(user.getPassword());
        $("[data-test-id=action-login]").click();

        // проверяем успешный вход
        $(".heading").shouldBe(visible)
                .shouldHave(text("Личный кабинет"));
    }
}