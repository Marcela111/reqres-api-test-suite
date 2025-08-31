import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

public class UserApiTests {

    // This method runs once before all tests to set up the base URI.
    // The base URI should include the "/api" path.
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";
    }

    @Test
    public void testPostNewUserSuccessfully() {
        // Create a user object to send in the request body.
        Map<String, String> user = new HashMap<>();
        user.put("name", "morpheus");
        user.put("job", "leader");

        given()
            .contentType(ContentType.JSON)
            .body(user)
        .when()
            .post("/users") // The path is now correctly "/users" because the base path is set to "/api".
        .then()
            .statusCode(201)
            .body("name", equalTo("morpheus"))
            .body("job", equalTo("leader"));
    }

    @Test
    public void testPutExistingUserJob() {
        // Create a new job object to send in the request body.
        Map<String, String> jobUpdate = new HashMap<>();
        jobUpdate.put("job", "zion resident");

        given()
            .contentType(ContentType.JSON)
            .body(jobUpdate)
        .when()
            .put("/users/2") // Corrected path.
        .then()
            .statusCode(200)
            .body("job", equalTo("zion resident"));
    }

    @Test
    public void testGetExistingUser() {
        given()
            .when()
            .get("/users/2") // Corrected path.
        .then()
            .statusCode(200)
            .body("data.id", equalTo(2))
            .body("data.first_name", equalTo("Janet"));
    }

    @Test
    public void testDeleteUser() {
        given()
            .when()
            .delete("/users/2") // Corrected path.
        .then()
            .statusCode(204);
    }
}
