package co.edu.icesi.emt.auth.application.dto.signup;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SignupRequestDTO {

    private final String username;
    private final String password;

    private final String[] roles;

    @JsonCreator
    public SignupRequestDTO(@JsonProperty("username") String username,
            @JsonProperty("password") String password, @JsonProperty("roles") String[] roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String[] getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "SignupRequestDTO [password=" + password + ", roles=" + roles + ", username=" + username + "]";
    }
}