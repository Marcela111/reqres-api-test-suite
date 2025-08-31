package com.mycompany.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class RestAssuredSetup {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in";
        // Usa la clase ConfigurationManager para obtener la clave de API
        String apiKey = ConfigurationManager.getApiKey();

        if (apiKey != null) {
            // Agrega la clave de API al encabezado de las solicitudes
            // Reemplaza "Authorization" y "Bearer " si la documentación de la API especifica algo diferente
            RestAssured.requestSpecification = RestAssured.given().header("Authorization", "Bearer " + apiKey);
        }
    }
}
