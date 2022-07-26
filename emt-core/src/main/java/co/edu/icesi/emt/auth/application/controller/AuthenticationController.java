package co.edu.icesi.emt.auth.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.emt.auth.application.dto.login.LoginRequestDTO;
import co.edu.icesi.emt.auth.application.dto.signup.SignupRequestDTO;
import co.edu.icesi.emt.auth.application.service.user.UserService;
import co.edu.icesi.emt.auth.security.jwt.JWTProvider;

@RestController
@RequestMapping("/public/auth")
public class AuthenticationController {

    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private UserService userService;
    private JWTProvider jwtProvider;

    @Autowired
    public AuthenticationController(PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager,
            UserService userService, JWTProvider jwtProvider) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody final SignupRequestDTO signUpRequestDTO /*
                                                                                               * We need a
                                                                                               * FullLoginRequestDTO
                                                                                               * with
                                                                                               * [roles] and
                                                                                               * all user information
                                                                                               * like
                                                                                               * name, username,
                                                                                               * address,
                                                                                               * etc
                                                                                               */) {

        userService.save(signUpRequestDTO.getUsername(), passwordEncoder.encode(signUpRequestDTO.getPassword()));

        return new ResponseEntity<String>(
                "User created: " + userService.findByUsername(signUpRequestDTO.getUsername()).toString(),
                HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody final LoginRequestDTO loginRequestDTO) {
        return new ResponseEntity<String>("User logged: " + loginRequestDTO.toString(), HttpStatus.OK);
    }
}