package com.mycompany.api;

import org.junit.jupiter.api.BeforeAll;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

/**
 * Clase de configuración de prueba para configurar Rest Assured.
 * Esto se ejecuta una vez antes de todas las pruebas en la suite de pruebas.
 */
public class RestAssuredSetup {

    @BeforeAll
    public static void setup() {
        // Se ha actualizado la URI base para incluir la ruta "/api"
        RestAssured.baseURI = "https://reqres.in/api";
        // Usa la clase ConfigurationManager para obtener la clave de API (si es necesario)
        String apiKey = ConfigurationManager.getApiKey();

        if (apiKey != null) {
            // Agrega la clave de API al encabezado de las solicitudes
            // Reemplaza "Authorization" y "Bearer " si la documentación de la API especifica algo diferente
            RestAssured.requestSpecification = given().header("Authorization", "Bearer " + apiKey);
        }
    }
}