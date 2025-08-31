package com.mycompany.api;

import org.junit.jupiter.api.BeforeAll;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

/**
 * Clase base para la configuración de RestAssured.
 * Se encarga de configurar la URL base y otras configuraciones comunes
 * para todas las pruebas de la API.
 */
public class RestAssuredSetup {

    @BeforeAll
    public static void setup() {
        // Establece la URL base para todas las solicitudes
        // La API de reqres.in no requiere clave de API para la mayoría de sus endpoints.
        RestAssured.baseURI = "https://reqres.in";

        // Agrega filtros para imprimir los detalles de la solicitud y la respuesta en la consola.
        // Esto es muy útil para depurar errores como el 404.
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
