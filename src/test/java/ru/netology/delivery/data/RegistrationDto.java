package ru.netology.delivery.data;

import lombok.Value;

@Value
public class RegistrationDto  { // Объект передачи данных для регистрации
    String login;   // логин
    String password; // пароль
    String status;   // active / blocked
}