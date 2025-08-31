package com.mycompany.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserApiGetTests extends RestAssuredSetup {

    @Test
    @DisplayName("✅ GET | Obtener un usuario existente y validar su información")
    void testGetExistingUser() {
        given()
            .pathParam("id", 2)
        .when()
            .get("/users/{id}")
        .then()
            .statusCode(200)
            .header("Content-Type", containsString("application/json"))
            .body("data.id", equalTo(2))
            .body("data.email", equalTo("janet.weaver@reqres.in"))
            .log().all();
    }

    @Test
    @DisplayName("❌ GET | Consultar un usuario inexistente (caso negativo)")
    void testGetNonExistentUser() {
        given()
            .pathParam("id", 999)
        .when()
            .get("/users/{id}")
        .then()
            .statusCode(404)
            .log().all();
    }
}