package co.edu.icesi.emt.auth.application.service.user;

import java.util.List;
import java.util.Set;

import co.edu.icesi.emt.auth.domain.model.role.Role;
import co.edu.icesi.emt.auth.domain.model.user.User;

public interface UserService {
    void save(String username, String password, String[] roles);

    User findByUsername(String username);

    List<User> findAll();

    void deleteByUsername(String username);

    Set<Role> findUserRolesByUsername(String username);

    void changePassword(String username, String password);

    void setUserStatus(String username, boolean status);

    boolean isAccountEnabled(String username);

    void saveLastLogin(String username);
}