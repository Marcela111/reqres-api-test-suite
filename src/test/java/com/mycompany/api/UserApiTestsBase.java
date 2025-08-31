package com.mycompany.api;

import org.junit.jupiter.api.BeforeAll;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class UserApiTestsBase {

    // You should use a RequestSpecification to hold the common configuration for all tests.
    public static RequestSpecification requestSpec;

    // A placeholder for the API key. In a real project, this should be loaded from a configuration file.
    private static final String API_KEY = "YOUR_API_KEY_HERE";

    @BeforeAll
    public static void setup() {
        // Build a RequestSpecification with the base URI, base path, and the API key header.
        requestSpec = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in")
            .setBasePath("/api")
            .addHeader("x-api-key", API_KEY)
            .build();
    }
}
