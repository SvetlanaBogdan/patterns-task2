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
        // базовый URL приложения
        Configuration.baseUrl = "http://localhost:9999";
    }

    // Успешный вход (пользователь существует + активный)
    @Test
    void shouldLoginActiveUser() {
        // создаём пользователя через API
        RegistrationDto user = DataGenerator.getRegisteredUser("active");

        open("/");

        // вводим данные
        $("[data-test-id=login] input").setValue(user.getLogin());
        $("[data-test-id=password] input").setValue(user.getPassword());
        $("[data-test-id=action-login]").click();

        // проверяем успешный вход
        $(".heading")
                .shouldBe(visible)
                .shouldHave(text("Личный кабинет"));
    }

    // Пользователь есть, но заблокирован
    @Test
    void shouldNotLoginBlockedUser() {
        RegistrationDto user = DataGenerator.getRegisteredUser("blocked");

        open("/");

        $("[data-test-id=login] input").setValue(user.getLogin());
        $("[data-test-id=password] input").setValue(user.getPassword());
        $("[data-test-id=action-login]").click();

        // ожидаем ошибку
        $("[data-test-id=error-notification]")
                .shouldBe(visible)
                .shouldHave(text("Ошибка"));
    }

    // Неверный логин
    @Test
    void shouldNotLoginWithWrongLogin() {
        RegistrationDto user = DataGenerator.getRegisteredUser("active");

        open("/");

        // подставляем неправильный логин
        $("[data-test-id=login] input").setValue("wrongLogin");
        $("[data-test-id=password] input").setValue(user.getPassword());
        $("[data-test-id=action-login]").click();

        $("[data-test-id=error-notification]")
                .shouldBe(visible)
                .shouldHave(text("Ошибка"));
    }

    // Неверный пароль
    @Test
    void shouldNotLoginWithWrongPassword() {
        RegistrationDto user = DataGenerator.getRegisteredUser("active");

        open("/");

        $("[data-test-id=login] input").setValue(user.getLogin());
        $("[data-test-id=password] input").setValue("wrongPassword");
        $("[data-test-id=action-login]").click();

        $("[data-test-id=error-notification]")
                .shouldBe(visible)
                .shouldHave(text("Ошибка"));
    }
}