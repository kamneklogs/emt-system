package co.edu.icesi.emt.auth.application.dto.signup;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SignupRequestDTO {

    private final String username;
    private final String password;

    private final String[] rolesIds;

    @JsonCreator
    public SignupRequestDTO(@JsonProperty("username") String username,
            @JsonProperty("password") String password, @JsonProperty("rolesIds") String[] roles) {
        this.username = username;
        this.password = password;
        this.rolesIds = roles;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String[] getRolesIds() {
        return rolesIds;
    }

    @Override
    public String toString() {
        return "SignupRequestDTO [password=" + password + ", roles=" + rolesIds + ", username=" + username + "]";
    }
}