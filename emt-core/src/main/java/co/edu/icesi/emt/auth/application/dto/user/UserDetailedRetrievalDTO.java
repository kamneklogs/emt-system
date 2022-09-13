package co.edu.icesi.emt.auth.application.dto.user;

import java.time.Instant;
import java.util.List;

public class UserDetailedRetrievalDTO { // To be expanded

    private final String username;
    private final Instant last_login;

    private final List<RoleDTO> roles;

    public UserDetailedRetrievalDTO(String username, Instant last_login, List<RoleDTO> roles) {
        this.username = username;
        this.last_login = last_login;
        this.roles = roles;
    }


}
