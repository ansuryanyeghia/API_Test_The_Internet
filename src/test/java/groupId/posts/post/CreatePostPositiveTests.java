package groupId.posts.post;

import groupId.api.RequestUtils;
import groupId.api.ResponseUtils;
import groupId.dataProviders.RequestSpecificationProvider;
import groupId.models.Post;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CreatePostPositiveTests {

    RequestSpecification postSpec = RequestSpecificationProvider.getRequestSpecificationByRequestMethod("POST");
    RequestSpecification getSpec = RequestSpecificationProvider.getRequestSpecificationByRequestMethod("GET");

    @BeforeAll
    public static void setup() {
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.registerParser("text/plain", Parser.JSON);
    }

    @Test
    public void validatePostCreation() {
        Post post = new Post(1111, "New Post1111", 111);
        String jsonStringObject = RequestUtils.getJsonStringByObject(post);
        RequestUtils.post(postSpec, "/posts", jsonStringObject);
        int actualStatusCode = ResponseUtils.getStatusCode();
        Assertions.assertEquals(201, actualStatusCode);
    }


    @ParameterizedTest
    @CsvSource(
            {
                    "412, 'New Post412', 44",
                    "512, 'New Post512', 55"
            }
    )
    public void validateTwoPostCreation(int id, String title, int views) {
        Post actualResponse = new Post(id, title, views);
        String jsonStringObject = RequestUtils.getJsonStringByObject(actualResponse);
        RequestUtils.post(postSpec, "/posts", jsonStringObject);
        int actualStatusCode = ResponseUtils.getStatusCode();
        Assertions.assertEquals(201, actualStatusCode);

        RequestUtils.get(getSpec, "/posts", id);
        int getStatusCode = ResponseUtils.getStatusCode();
        Assertions.assertEquals(200, getStatusCode, "GET /posts/{id} did not return 200");
        Post expectedResponse = ResponseUtils.getObjectByJsonString(Post.class);
        Assertions.assertEquals(actualResponse, expectedResponse);

    }

}
