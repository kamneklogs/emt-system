package co.edu.icesi.emt.auth.application.dto.user;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {

    private final String username;
    private final Instant last_login;

    @JsonCreator
    public UserDTO(@JsonProperty("username") String username, @JsonProperty("last_login") Instant last_login) {
        this.username = username;
        this.last_login = last_login;
    }

    public String getUsername() {
        return username;
    }

    public Instant getLast_login() {
        return last_login;
    }

}
