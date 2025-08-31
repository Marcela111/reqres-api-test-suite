package com.mycompany.api;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserApiPutTests extends RestAssuredSetup {

    @Test
    @DisplayName("✅ PUT | Actualizar el cargo de un usuario y validar la respuesta")
    void testPutExistingUserJob() {
        Map<String, String> updateData = new HashMap<>();
        updateData.put("job", "zion resident");

        given()
            .contentType(ContentType.JSON)
            .pathParam("id", 2)
            .body(updateData)
        .when()
            .put("/users/{id}")
        .then()
            .statusCode(200)
            .body("job", equalTo("zion resident"))
            .log().all();
    }
}