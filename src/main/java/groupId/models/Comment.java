package groupId.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Comment {
    @JsonProperty
    public int id;
    @JsonProperty
    public String text;
    @JsonProperty
    public int postId;

    public Comment(){

    }
    public Comment(int id, String text, int postId){
        this.id = id;
        this.text = text;
        this.postId = postId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id && postId == comment.postId && Objects.equals(text, comment.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, postId);
    }
}
