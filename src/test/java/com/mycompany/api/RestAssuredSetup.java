package com.mycompany.api;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Pruebas para la creación de usuarios en la API.
 */
public class UserApiPostTests extends RestAssuredSetup {

    /**
     * Prueba para crear un nuevo usuario exitosamente con un código de estado 201.
     */
    @Test
    public void testPostNewUserSuccessfully() {
        // Se crea un mapa para el cuerpo de la solicitud.
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", "John Doe");
        requestBody.put("job", "Software Developer");

        // Se envía la solicitud POST y se valida la respuesta.
        given()
            .contentType("application/json") // Se establece el tipo de contenido como JSON.
            .body(requestBody) // Se adjunta el cuerpo de la solicitud.
        .when()
            .post("/users") // Se envía la solicitud al endpoint de creación de usuarios.
        .then()
            .statusCode(201) // Se verifica que el código de estado sea 201 (Created).
            .body("name", equalTo("John Doe")) // Se valida que el nombre en la respuesta sea el correcto.
            .body("job", equalTo("Software Developer")); // Se valida que el trabajo en la respuesta sea el correcto.
    }
}
