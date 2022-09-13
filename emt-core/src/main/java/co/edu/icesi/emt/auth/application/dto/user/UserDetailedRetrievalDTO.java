package co.edu.icesi.emt.auth.application.dto.user;

import java.time.Instant;
import java.util.List;

import co.edu.icesi.emt.auth.application.dto.role.RoleDTO;
import co.edu.icesi.emt.auth.domain.model.role.Role;

public class UserDetailedRetrievalDTO { // To be expanded

    private final String username;
    private final Instant last_login;

    private final List<RoleDTO> roles;

    public UserDetailedRetrievalDTO(String username, Instant last_login, List<RoleDTO> roles) {
        this.username = username;
        this.last_login = last_login;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public Instant getLast_login() {
        return last_login;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public static UserDetailedRetrievalDTO from(String username, Instant last_login, List<Role> roles) {
        return new UserDetailedRetrievalDTO(username, last_login, RoleDTO.from(roles));
    }
}
