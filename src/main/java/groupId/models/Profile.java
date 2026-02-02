package groupId.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Profile {
    @JsonProperty
    public int id;
    @JsonProperty
    public String name;
    @JsonProperty
    public String surname;
    @JsonProperty
    public int age;

    public Profile(){

    }
    public Profile(int id, String name, String surname, int age){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return id == profile.id && age == profile.age && Objects.equals(name, profile.name) && Objects.equals(surname, profile.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age);
    }
}
