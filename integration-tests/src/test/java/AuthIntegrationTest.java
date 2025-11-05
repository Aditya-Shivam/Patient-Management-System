import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class AuthIntegrationTest {

    @BeforeAll
    static void setup(){
        RestAssured.baseURI = "http://localhost:4004";
    }

    @Test
    public void shouldReturnOKWithValidToken(){
        // 1. Arrange
        // 2. Act
        // 3. Assert

        String loginPayload = """
                {
                    "email":"testuser@test.com",
                    "password":"password123"
                }
                """;
        System.out.println("Login Payload: " + loginPayload);
        Response response = given()
                .contentType("application/json")
                .body(loginPayload)
                .when()
                .post("/auth/login")
                .then()
                .statusCode(200)
                .body("token",notNullValue())
                .extract()
                .response();

        System.out.println("Generated Token" + response.jsonPath().getString("token"));
    }

    @Test
    public void shouldReturnUnauthorizedOnInValidToken(){
        // 1. Arrange
        // 2. Act
        // 3. Assert

        String loginPayload = """
                {
                    "email":"testuser@test.com",
                    "password":"wrong123"
                }
                """;
        System.out.println("Login Payload: " + loginPayload);
        given()
            .contentType("application/json")
            .body(loginPayload)
            .when()
            .post("/auth/login")
            .then()
            .statusCode(401);
    }
}
