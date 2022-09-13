package co.edu.icesi.emt.auth.application.dto.user;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.edu.icesi.emt.auth.domain.model.user.User;

public class UserBasicRetrievalDTO {

    private final String username;
    private final Instant last_login;

    @JsonCreator
    public UserBasicRetrievalDTO(@JsonProperty("username") String username, @JsonProperty("last_login") Instant last_login) {
        this.username = username;
        this.last_login = last_login;
    }

    public String getUsername() {
        return username;
    }

    public Instant getLast_login() {
        return last_login;
    }

    public static UserBasicRetrievalDTO from(User user) {
        return new UserBasicRetrievalDTO(user.getUsername(), user.getLastLogin());
    }

    public static List<UserBasicRetrievalDTO> from(List<User> users) {
        List<UserBasicRetrievalDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            userDTOs.add(from(user));
        }
        return userDTOs;
    }
}
