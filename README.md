 # File Storage Microservice

 ## Описание решения

 Данный микросервис реализован на базе Spring Boot и предоставляет REST API для управления файлами и их атрибутами. Основные функциональные возможности включают:

 - **Создание файла:** Создание нового файла с атрибутами (название, дата создания, описание) и его содержимым, передаваемыми в формате JSON.
 - **Получение файла по ID:** Получение данных о файле по его идентификатору, возвращает JSON с данными файла.
 - **Получение всех файлов:** Получение списка всех созданных файлов.

 ## Инструкция по запуску приложения

 1. **Клонирование репозитория:**

    ```bash
    git clone <ссылка-на-репозиторий>
    ```
2. **Переход в директорию проекта:**
    ```bash
    cd <папка-проекта>
3. **Сборка и запуск приложения:**

    Убедитесь что у вас установлены JDK 21+ и MAVEN.
    ```bash
    ./mvnw spring-boot:run
    ```
    Приложение будет доступно по адресу http://localhost:8080.

4. **Конфигурация базы данных:**

Убедитесь, что в application.properties указаны правильные настройки доступа
к базе данных. По умолчанию используется PostgreSQL.
Если необходимо, настройте доступ к базе данных следующим образом:

```java
spring.application.name=entranceexam
spring.datasource.url=jdbc:postgresql://localhost:5432/filestorage
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
server.port=8080
```
Замените ```your_username``` и ```your_password``` на имя вашего пользователя
и пароль пользователя соответственно.

# Тестирование микросервиса

## 1. Создание файла

- **Метод:** `POST`
- **URL:** `http://localhost:8080/filestorage/create`
- **Тело запроса (JSON):**

  ```json
  {
    "title": "Sample File",
    "creationDate": "2024-07-25T12:00:00",
    "description": "This is a sample file.",
    "file": "VGhpcyBpcyBhIHRlc3QgZmlsZS4="
  }
  ```
  ### Успешное создание:
    ```json
    {
      "message": "File_created_with_id: 1"
    }
    ```

## 2. Получение файла по ID
- **Метод** `GET`
- **URL:** `http://localhost:8080/filestorage/create`

  Успешное получение:
  ```json
  {
    "id": 1,
    "title": "Sample File",
    "creationDate": "2024-07-25T12:00:00",
    "description": "This is a sample file.",
    "file": "VGhpcyBpcyBhIHRlc3QgZmlsZS4="
  }
  ```

## 3. Получение всех файлов
- **Метод** `GET`
- **URL:** `http://localhost:8080/filestorage`

  Возвращает список всех файлов:
  ```json
  [
    {
      "id": 1,
      "title": "Sample File",
      "creationDate": "2024-08-12T12:00:00",
      "description": "This is a sample file.",
      "file": "VGhpcyBpcyBhIHRlc3QgZmlsZS4="
    }
  ]
