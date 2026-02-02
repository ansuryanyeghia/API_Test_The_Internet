package groupId.dataProviders;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationProvider {

    public static RequestSpecification getRequestSpecificationByRequestMethod(String requestMethod) {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://localhost:3000")
                .build();
        switch (requestMethod) {
            case "GET":
                requestSpecification.contentType(ContentType.JSON);
                break;
            case "POST":
                requestSpecification.contentType(ContentType.JSON);
                break;
            case "PUT":
                requestSpecification.contentType(ContentType.JSON);
                break;
            case "PATCH":
                requestSpecification.contentType(ContentType.JSON);
                break;
            default:
                requestSpecification.contentType(ContentType.JSON);
        }
        return requestSpecification;
    }
}
