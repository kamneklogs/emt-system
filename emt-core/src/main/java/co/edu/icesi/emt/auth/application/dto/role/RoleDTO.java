package co.edu.icesi.emt.auth.application.dto.role;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.edu.icesi.emt.auth.domain.model.role.Role;

public class RoleDTO {

    private final String name;
    private final String doimainName;
    private final String description;

    @JsonCreator
    public RoleDTO(@JsonProperty("name") String name,
            @JsonProperty("domainName") String domainName,
            @JsonProperty("description") String description) {
        this.name = name;
        this.doimainName = domainName;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDoimainName() {
        return doimainName;
    }

    public String getDescription() {
        return description;
    }

    public static RoleDTO from(Role role) {
        return new RoleDTO(role.getName(), role.getDomainName(), role.getDescription());
    }

    public static List<RoleDTO> from(List<Role> roles) {
        List<RoleDTO> rolesDTO = new ArrayList<>();

        for (Role role : roles) {
            rolesDTO.add(from(role));
        }
        return rolesDTO;
    }
}
