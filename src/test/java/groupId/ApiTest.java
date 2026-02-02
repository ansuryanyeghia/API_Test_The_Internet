package groupId;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@DisplayName("Verifying API functionality")
class ApiTest {

    @Test
    void verifyGetAllUsers() {

        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2";

        ValidatableResponse response = given()
                .when()
                .get("/users")
                .then();
        int actualStatusCode = response.extract().statusCode();
        Assertions.assertEquals(200, actualStatusCode);

        String responseString = response.extract().asPrettyString();
        System.out.println(responseString);
    }

    @Test
    void verifyGetUserByID() {
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2";

        ValidatableResponse response = given()
                .when()
                .get("/users/8352636")
                .then();
        int actualStatusCode = response.extract().statusCode();
        Assertions.assertEquals(200, actualStatusCode);

        String responseString = response.extract().asPrettyString();
        System.out.println(responseString);
    }

    @Test
    void verifyPostNewUser() {
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2";

        ValidatableResponse response = given()
                .header("Authorization", "Bearer 994aade46f0b5cc5282497e75d4d3c7635c00525e95d9641dd1b815f5978f6fd")
                .contentType(ContentType.JSON)
                .when()
                .body("{\n" +
                        "    \"name\": \"Yeghia Ansuryan\",\n" +
                        "    \"email\": \"yeghia2_ansuryan@gmail.com\",\n" +
                        "    \"gender\": \"male\",\n" +
                        "    \"status\": \"active\"\n" +
                        "}")
                .post("/users")
                .then();

        int actualStatusCode = response.extract().statusCode();
        Assertions.assertEquals(201, actualStatusCode);

        String responseString = response.extract().asPrettyString();
        System.out.println(responseString);
    }

    @Test
    void verifyUpdateUser() {
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2";

        ValidatableResponse response = given()
                .header("Authorization", "Bearer 994aade46f0b5cc5282497e75d4d3c7635c00525e95d9641dd1b815f5978f6fd")
                .contentType(ContentType.JSON)
                .when()
                .body("{\n" +
                        "    \"name\": \"Yeghia Ansuryan\",\n" +
                        "    \"email\": \"yeghia222_ansuryan@gmail.com\",\n" +
                        "    \"gender\": \"male\",\n" +
                        "    \"status\": \"active\"\n" +
                        "}")
                .put("/users/8352636")
                .then();

        int actualStatusCode = response.extract().statusCode();
        Assertions.assertEquals(200, actualStatusCode);
    }

    @Test
    void verifyDeleteUserByID() {
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2";

        ValidatableResponse response = given()
                .header("Authorization", "Bearer 994aade46f0b5cc5282497e75d4d3c7635c00525e95d9641dd1b815f5978f6fd")
                .contentType(ContentType.JSON)
                .when()
                .delete("/users/8352636")
                .then().log().body();

        int actualStatusCode = response.extract().statusCode();
        Assertions.assertEquals(204, actualStatusCode);
    }


}
