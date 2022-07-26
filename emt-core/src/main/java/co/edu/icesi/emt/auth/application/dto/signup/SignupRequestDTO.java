package co.edu.icesi.emt.auth.application.dto.signup;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SignupRequestDTO { // TODO: This needs be extended

    private final String username;
    private final String password;

    @JsonCreator
    public SignupRequestDTO(@JsonProperty("username") String username,
            @JsonProperty("password") String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
