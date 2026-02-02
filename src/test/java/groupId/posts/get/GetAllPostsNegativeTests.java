package groupId.posts.get;

import groupId.api.RequestUtils;
import groupId.api.ResponseUtils;
import groupId.dataProviders.RequestSpecificationProvider;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetAllPostsNegativeTests {

    RequestSpecification getSpec = RequestSpecificationProvider.getRequestSpecificationByRequestMethod("GET");

    @Test
    public void validateStatusCode() {
        RequestUtils.get(getSpec, "/postss");
        int actualStatusCode = ResponseUtils.getStatusCode();
        Assertions.assertEquals(404, actualStatusCode);
    }
}
