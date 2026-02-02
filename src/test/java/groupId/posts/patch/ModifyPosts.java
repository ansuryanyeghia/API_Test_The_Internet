package groupId.posts.patch;

import groupId.api.RequestUtils;
import groupId.api.ResponseUtils;
import groupId.dataProviders.RequestSpecificationProvider;
import groupId.models.Post;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ModifyPosts {

    RequestSpecification patchSpec = RequestSpecificationProvider.getRequestSpecificationByRequestMethod("PATCH");

    @Test
    public void validatePatchCreation() {
        Post post = new Post(2, "Modified", 111);
//        String jsonStringObject = RequestUtils.getJsonStringByObject(post);
        RequestUtils.patch(patchSpec, "/posts/{id}", 2);
        int actualStatusCode = ResponseUtils.getStatusCode();
        Assertions.assertEquals(200, actualStatusCode);
    }


}
