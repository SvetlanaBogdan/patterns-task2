[![Java CI with Gradle](https://github.com/SvetlanaBogdan/patterns-task2/actions/workflows/gradle.yml/badge.svg)](https://github.com/SvetlanaBogdan/patterns-task2/actions/workflows/gradle.yml)

## Описание
Автоматизация тестирования формы логина с использованием UI (Selenide) и API (Rest-assured).


## API тестирование

POST http://localhost:9999/api/system/users

Проверка выполнялась:
- автоматически (Rest-assured)
- вручную (Postman)

Postman коллекция:  
https://www.postman.com/svetlanabogdan/workspace/iqa-126/collection/37082370-4f7a62da-d89a-462a-8d5c-d522cff501b6?action=share&creator=37082370


## Проверенные сценарии

1. Наличие пользователя:
- существующий пользователь — успешный вход
- несуществующий пользователь — ошибка

2. Статус пользователя:
- active — успешный вход
- blocked — ошибка

3. Невалидный логин:
- неверный логин — ошибка

4. Невалидный пароль:
- неверный пароль — ошибка



## CI

Тесты автоматически запускаются через GitHub Actions при каждом push.



## Время выполнения

время, затраченное на ручное тестирование (минут): 40;  
время, затраченное на автоматизацию (минут): 720. 
