package groupId.posts.get;

import groupId.api.RequestUtils;
import groupId.api.ResponseUtils;
import groupId.dataProviders.RequestSpecificationProvider;
import groupId.pojos.posts.PostsRoot;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GetAllPostsPositiveTests {

    RequestSpecification getSpec = RequestSpecificationProvider.getRequestSpecificationByRequestMethod("GET");

    @BeforeAll
    public static void setup() {
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.registerParser("text/plain", Parser.JSON);
    }

    @Test
    public void validateStatusCode() {
        RequestUtils.get(getSpec,"/posts");
        int actualStatusCode = ResponseUtils.getStatusCode();
        Assertions.assertEquals(200, actualStatusCode);
    }

    @Test
    public void validateResponseByJsonSchema() {
        RequestUtils.get(getSpec,"/posts");
        ResponseUtils.validateResponseByJsonSchema("validatorSchema/getAllPostsValidatorSchema.json");
    }

    @Test
    public void validateGetPostsById() {
        RequestUtils.get(getSpec,"/posts", 1);
        PostsRoot objectByJsonString = ResponseUtils.getObjectByJsonString(PostsRoot.class);

        ResponseUtils.getStringValueByJsonPath("id");
        ResponseUtils.getStringValueByJsonPath("user.name");
    }
}
