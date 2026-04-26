package ru.netology.delivery.data;

import lombok.Value;

@Value // Lombok создаёт конструктор и геттеры
public class AuthInfo {
    String login;   // логин
    String password; // пароль
}