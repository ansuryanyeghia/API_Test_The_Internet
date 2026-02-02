package groupId.pojos.profile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Profile {
    @JsonProperty
    public int id;
    @JsonProperty
    public String name;
    @JsonProperty
    public String surname;
    @JsonProperty
    public int age;
}
