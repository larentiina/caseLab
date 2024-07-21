# Тестовое задание для Case Lab Java
## Задание
Необходимо реализовать микросервис, который будет выполнять роль хранилища различных файлов и их атрибутов.

Микросервис должен предоставлять HTTP API и принимать/отдавать запросы/ответы в формате JSON.

Разработка UI-интерфейса не требуется. Для тестирования можно использовать Postman или аналог.

Должны быть реализованы следующие API-методы:

Создание файла.
На вход методу отправляется JSON, включающий в себя файл (в формате base64) и его атрибуты (название - title, дата и время отправки - creation_date, краткое описание документа - description), на выходе метод возвращает id созданного файла.

Получение файла.
На вход методу отправляется id файла, на выходе метод возвращает JSON, включающий в себя файл (в формате base64) и его атрибуты (название - title, дата и время отправки - creation_date, краткое описание документа - description)
​
## Описание решения
Этот проект представляет собой микросервис, разработанный с использованием Spring Boot и Hibernate. Основная цель проекта - предоставление функциональности для управления файлами и их атрибутами. Приложение использует PostgreSQL в качестве базы данных для хранения информации.
## Инструкция по запуску приложения
### Запуск JAR файла напрямую
```
git clone https://github.com/larentiina/caseLab.git
cd caseLab.git
mvn clean package
java -jar target/caseLab-0.0.1-SNAPSHOT.jar
```
## Пример запросов к микросервису
Создание файла

POST:http://localhost:8080/files/ 
```
{
  "title": "Sample Document",
  "creationDate": "2024-07-20T15:30:00",
  "description": "This is a sample document description.",
  "data": "U29tZSByYW5kb20gdGV4dC4gZGF0YSBmb3IgdGhlIGxvZ2luIGZvciB0ZXh0IG9mIGF3YXJkLg=="
}
```
Вывод: 
1

POST:http://localhost:8080/files/ 
```
{
  "title": "Sample Document",
  "creationDate": "2024-07-20T15:30:00",
  "description": "This is a sample document description.",
  "data": "Hello"
}
```
Вывод: 
invalid base64 data

GET: http://localhost:8080/files/1

Вывод: 
```
{
  "title": "Sample Document",
  "creationDate": "2024-07-20T15:30:00",
  "description": "This is a sample document description.",
  "data": "U29tZSByYW5kb20gdGV4dC4gZGF0YSBmb3IgdGhlIGxvZ2luIGZvciB0ZXh0IG9mIGF3YXJkLg=="
}
```
### Стек технологий
Java 17, PostgreSQL 16, Spring Boot
