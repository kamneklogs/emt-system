package co.edu.icesi.emt.auth.application.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.emt.auth.application.dto.signup.UserCreationDTO;
import co.edu.icesi.emt.auth.application.dto.user.UserBasicRetrievalDTO;
import co.edu.icesi.emt.auth.application.dto.user.UserDetailedRetrievalDTO;
import co.edu.icesi.emt.auth.application.service.user.UserService;
import co.edu.icesi.emt.auth.application.service.userrole.UserRoleService;
import co.edu.icesi.emt.auth.domain.model.user.User;
import co.edu.icesi.emt.auth.util.validators.UserAdminValidator;
import co.edu.icesi.emt.auth.util.validators.exceptions.UserIsNotAdminException;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;

    private final UserAdminValidator userAdminValidator;

    @Autowired
    public UserController(UserAdminValidator userAdminValidator,
            UserRoleService userRoleService,
            UserService userService,
            PasswordEncoder passwordEncoder) {
        this.userAdminValidator = userAdminValidator;
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public ResponseEntity<List<UserBasicRetrievalDTO>> getAllUsers() {
        return new ResponseEntity<List<UserBasicRetrievalDTO>>(UserBasicRetrievalDTO.from(userService.findAll()),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody final UserCreationDTO userCreationDTO,
            final HttpServletRequest httpRequest) throws UserIsNotAdminException {

        userAdminValidator.validate(httpRequest);

        userService.save(userCreationDTO.getUsername(), passwordEncoder.encode(userCreationDTO.getPassword()),
                userCreationDTO.getRoles());

        return new ResponseEntity<String>(
                "User created: " + userService.findByUsername(userCreationDTO.getUsername()).toString(),
                HttpStatus.OK);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<String> setUserStatus(@PathVariable("id") String id, @RequestBody final boolean isEnabled,
            final HttpServletRequest httpRequest) throws UserIsNotAdminException {

        userAdminValidator.validate(httpRequest);
        userService.setUserStatus(id, isEnabled);

        return new ResponseEntity<String>("User status changed for username: " + id, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailedRetrievalDTO> findUserById(@PathVariable("id") String id) {
        User user = userService.findByUsername(id);
        return new ResponseEntity<UserDetailedRetrievalDTO>(
                UserDetailedRetrievalDTO.from(user.getUsername(), user.getLastLogin(),
                        userRoleService.findUserRoleIdsByUsername(user.getUsername())),
                HttpStatus.OK);
    }
}
