package co.edu.icesi.emt.auth.application.service.user.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.emt.auth.application.service.user.UserService;
import co.edu.icesi.emt.auth.application.service.userrole.UserRoleService;
import co.edu.icesi.emt.auth.domain.model.role.Role;
import co.edu.icesi.emt.auth.domain.model.user.User;
import co.edu.icesi.emt.auth.domain.repository.user.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleService userRoleService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserRoleService userRoleService) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
    }

    @Override
    public void save(String username, String password) {
        // TODO: Add other validations
        this.userRepository.save(username, password);
    }

    @Override
    public User findByUsername(String username) {
        // TODO: Add other validations
        return this.userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public void deleteByUsername(String username) {
        // TODO: Add other validations
        this.userRepository.deleteByUsername(username);
    }

    @Override
    public Set<Role> findUserRolesByUsername(String username) {

        Set<Role> roles = this.userRoleService.findUserRoleIdsByUsername(username).stream().collect(Collectors.toSet());

        return roles;
    }
}
