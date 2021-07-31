package ru.netology.tests;

import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class EchoTest {
    @Test
    void shouldPostData() {
        given()
                .baseUri("https://postman-echo.com")
                .body("Shadow") // отправляемые данные (заголовки и query можно выставлять аналогично)

// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("Shadow"))

        ;
    }

    @Test
    void shouldPostArgs() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json; charset=utf-8")
                .body("нечто") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("data", equalTo("нечто"))
        ;
    }
}