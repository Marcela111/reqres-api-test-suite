package com.mycompany.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class UserApiDeleteTests extends RestAssuredSetup {

    @Test
    @DisplayName("✅ DELETE | Eliminar un usuario y validar el status code")
    void testDeleteUser() {
        given()
            .pathParam("id", 2)
        .when()
            .delete("/users/{id}")
        .then()
            .statusCode(204)
            .log().all();
    }
}