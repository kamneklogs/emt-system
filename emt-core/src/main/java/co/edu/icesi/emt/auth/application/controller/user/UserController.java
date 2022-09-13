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

import co.edu.icesi.emt.auth.application.dto.signup.SignupRequestDTO;
import co.edu.icesi.emt.auth.application.dto.user.UserDTO;
import co.edu.icesi.emt.auth.application.service.user.UserService;
import co.edu.icesi.emt.auth.util.validators.UserAdminValidator;
import co.edu.icesi.emt.auth.util.validators.exceptions.UserIsNotAdminException;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private final PasswordEncoder passwordEncoder;

    private final UserAdminValidator userAdminValidator;

    @Autowired
    public UserController(UserAdminValidator userAdminValidator, UserService userService,
            PasswordEncoder passwordEncoder) {
        this.userAdminValidator = userAdminValidator;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(final HttpServletRequest request) throws UserIsNotAdminException {
        userAdminValidator.validate(request);
        return new ResponseEntity<List<UserDTO>>(UserDTO.from(userService.findAll()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> signUp(@RequestBody final SignupRequestDTO signUpRequestDTO,
            final HttpServletRequest httpRequest) throws UserIsNotAdminException {

        userAdminValidator.validate(httpRequest);

        userService.save(signUpRequestDTO.getUsername(), passwordEncoder.encode(signUpRequestDTO.getPassword()),
                signUpRequestDTO.getRoles());

        return new ResponseEntity<String>(
                "User created: " + userService.findByUsername(signUpRequestDTO.getUsername()).toString(),
                HttpStatus.OK);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<String> setUserStatus(@PathVariable("id") String id, @RequestBody final boolean isEnabled,
            final HttpServletRequest httpRequest) throws UserIsNotAdminException {

        userAdminValidator.validate(httpRequest);
        userService.setUserStatus(id, isEnabled);

        return new ResponseEntity<String>("User status changed for username: " + id, HttpStatus.OK);
    }
}
