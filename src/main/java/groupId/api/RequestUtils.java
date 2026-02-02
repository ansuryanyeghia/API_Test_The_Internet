package groupId.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public final class RequestUtils {

    private static ValidatableResponse response;

    public static ValidatableResponse getResponse() {
        return response;
    }


    public static void get(RequestSpecification spec, String endpoint) {

        response = given()
                .when()
                .spec(spec)
                .get(endpoint)
                .then().log().all();

    }

    public static void get(RequestSpecification spec, String endpoint, int id) {
        response = given()
                .when()
                .spec(spec)
                .get(endpoint, id)
                .then();
    }

    public static void post(RequestSpecification spec, String endpoint, String body) {

        response = given()
                .when()
                .spec(spec)
                .body(body)
                .post(endpoint)
                .then();
    }

    public static void post(RequestSpecification spec, String endpoint, String body, int id) {
        response = given()
                .when()
                .spec(spec)
                .body(body)
                .post(endpoint, id)
                .then();
    }

    public static void patch(RequestSpecification spec, String endpoint, int id){
        if (!endpoint.contains("{id}")) {
            throw new IllegalArgumentException("Endpoint must contain '{id}' when passing an id as a path parameter. Use '/posts/{id}' instead of '/posts'.");
        }
        response = given()
                .when()
                .spec(spec)
                .patch(endpoint, id)
                .then().log().body();
    }

    public static void patch(RequestSpecification spec, String endpoint, String body) {
        response = given()
                .when()
                .spec(spec)
                .body(body)
                .patch(endpoint)
                .then().log().body();
    }

    public static String getJsonStringByObject(Object o) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString;
        try {
            jsonString = objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return jsonString;
    }
}
