package com.mycompany.api;

import org.junit.jupiter.api.BeforeAll;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RestAssuredSetup {

    private static final String BASE_URI = "https://reqres.in/api";

    // You can declare a static RequestSpecification to reuse configurations across tests
    public static RequestSpecification requestSpec;

    @BeforeAll
    static void setup() {
        // Build a reusable request specification
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(BASE_URI);

        // Remove the API key header that caused the 403 Forbidden error.
        // The reqres.in API does not require a key.
        // builder.addHeader("X-API-Key", "your_key_here"); 

        requestSpec = builder.build();

        // Apply this specification as a global filter
        RestAssured.requestSpecification = requestSpec;
        
        // Optional: Global settings for logging.
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}