package groupId.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Post {

    @JsonProperty
    public int id;
    @JsonProperty
    public String title;
    @JsonProperty
    public int views;

    public Post() {

    }

    public Post(int id, String title, int views) {
        this.id = id;
        this.title = title;
        this.views = views;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id && views == post.views && Objects.equals(title, post.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, views);
    }
}
