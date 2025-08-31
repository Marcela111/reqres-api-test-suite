package com.mycompany.api;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserApiPostTests extends RestAssuredSetup {

    @Test
    @DisplayName("✅ POST | Registrar un nuevo usuario y validar la respuesta")
    void testPostNewUserSuccessfully() {
        Map<String, String> userData = new HashMap<>();
        userData.put("name", "Morpheus");
        userData.put("job", "leader");

        given()
            .contentType(ContentType.JSON)
            .body(userData)
        .when()
            .post("/users")
        .then()
            .statusCode(201)
            .body("name", equalTo("Morpheus"))
            .body("job", equalTo("leader"))
            .log().all();
    }
}