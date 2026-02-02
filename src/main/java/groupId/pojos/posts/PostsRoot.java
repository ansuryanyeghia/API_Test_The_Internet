package groupId.pojos.posts;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostsRoot {

    @JsonProperty
    public int id;
    @JsonProperty
    public String title;
    @JsonProperty
    public int views;

    @JsonProperty
    public User user;
}
