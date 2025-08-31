package com.mycompany.api;

import org.junit.jupiter.api.BeforeAll;

import io.restassured.RestAssured;

/**
 * Test setup class to configure Rest Assured with the base URI and API key.
 * This runs once before all tests in the test suite.
 */
public class RestAssuredSetup {

    @BeforeAll
    public static void setup() {
        // Updated the baseURI to include the "/api" path for reqres.in
        RestAssured.baseURI = "https://reqres.in/api";
        // Use the ConfigurationManager class to get the API key
        // String apiKey = ConfigurationManager.getApiKey();

        // if (apiKey != null) {
        //     // Agrega la clave de API al encabezado de las solicitudes
        //     // Reemplaza "Authorization" y "Bearer " si la documentación de la API especifica algo diferente
        //     // Esta línea está comentada porque la API de reqres.in no usa una clave de API.
        //     // RestAssured.requestSpecification = RestAssured.given().header("Authorization", "Bearer " + apiKey);
        // }
    }
}