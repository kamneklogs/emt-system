package co.edu.icesi.emt.auth.application.service.userrole.impl;

import java.util.List;

import co.edu.icesi.emt.auth.application.service.userrole.UserRoleService;
import co.edu.icesi.emt.auth.domain.model.role.Role;
import co.edu.icesi.emt.auth.domain.model.user.User;

public class UserRoleServiceImpl implements UserRoleService{

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
