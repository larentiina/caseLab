# Тестовое задание для Case Lab Java
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
