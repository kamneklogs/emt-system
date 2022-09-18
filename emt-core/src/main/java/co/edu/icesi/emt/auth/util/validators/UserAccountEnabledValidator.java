package co.edu.icesi.emt.auth.util.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.icesi.emt.auth.application.service.user.UserService;
import co.edu.icesi.emt.auth.util.exceptions.UserAccountDisabledException;

@Component
public class UserAccountEnabledValidator {

    private final UserService userService;

    @Autowired
    public UserAccountEnabledValidator(UserService userService) {
        this.userService = userService;
    }

    public void validate(String username) throws UserAccountDisabledException {
        if (!userService.findByUsername(username).isEnabled()) {
            throw new UserAccountDisabledException();
        }
    }
}
