package groupId.pojos.comments;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Comments {
@JsonProperty
    public int id;
@JsonProperty
    public String text;
@JsonProperty
    public int postId;
}
