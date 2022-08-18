package co.edu.icesi.emt.auth.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.emt.auth.application.dto.login.LoginRequestDTO;
import co.edu.icesi.emt.auth.application.dto.login.LoginResponseDTO;
import co.edu.icesi.emt.auth.application.dto.signup.SignupRequestDTO;
import co.edu.icesi.emt.auth.application.service.user.UserService;
import co.edu.icesi.emt.auth.security.jwt.JWTProvider;

@RestController
@RequestMapping("/public/auth")
@CrossOrigin(origins = "*")
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
    public ResponseEntity<String> signUp(@RequestBody final SignupRequestDTO signUpRequestDTO) {

        userService.save(signUpRequestDTO.getUsername(), passwordEncoder.encode(signUpRequestDTO.getPassword()));

        return new ResponseEntity<String>(
                "User created: " + userService.findByUsername(signUpRequestDTO.getUsername()).toString(),
                HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody final LoginRequestDTO loginRequestDTO) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateJWT(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return new ResponseEntity<LoginResponseDTO>(
                new LoginResponseDTO(loginRequestDTO.getUsername(), jwt, userDetails.getAuthorities()), HttpStatus.OK);
    }
}