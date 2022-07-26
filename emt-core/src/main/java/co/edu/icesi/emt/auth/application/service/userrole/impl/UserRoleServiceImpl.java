package co.edu.icesi.emt.auth.application.service.userrole.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.emt.auth.application.service.userrole.UserRoleService;
import co.edu.icesi.emt.auth.domain.model.role.Role;
import co.edu.icesi.emt.auth.domain.model.user.User;
import co.edu.icesi.emt.auth.domain.repository.userrole.UserRoleRepository;
import co.edu.icesi.emt.auth.domain.repository.userrole.impl.UserRoleRepositoryImpl;

@Service
public class UserRoleServiceImpl implements UserRoleService {// TODO: To implements

    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepositoryImpl userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void save(User user, Role role) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean userHasRole(User user, Role role) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Role> findUserRoleIdsByUsername(String username) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteUserRoleByUsernameAndRoleId(User user, Role role) {
        // TODO Auto-generated method stub

    }

}
