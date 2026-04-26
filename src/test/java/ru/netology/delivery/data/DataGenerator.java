package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import ru.netology.delivery.api.ApiHelper;

public class DataGenerator {

    private DataGenerator() {
    }

    private static Faker faker = new Faker(); // генератор случайных данных

    // создаём логин и пароль
    public static AuthInfo getAuthInfo() {
        return new AuthInfo(
                faker.name().username(),     // случайный логин
                faker.internet().password()  // случайный пароль
        );
    }

    // создаём пользователя + РЕГИСТРИРУЕМ через API
    public static RegistrationDto getRegisteredUser(String status) {
        AuthInfo authInfo = getAuthInfo();

        RegistrationDto user = new RegistrationDto(
                authInfo.getLogin(),
                authInfo.getPassword(),
                status // active / blocked
        );

        ApiHelper.sendUser(user); // отправка в API

        return user;
    }
}