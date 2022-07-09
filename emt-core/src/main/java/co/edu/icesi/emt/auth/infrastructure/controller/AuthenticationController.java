package co.edu.icesi.emt.auth.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.emt.auth.infrastructure.dto.login.LoginRequestDTO;

@RestController
@RequestMapping("/public/authentication")
public class AuthenticationController {

    @PostMapping
    public ResponseEntity<String> login(@RequestBody final LoginRequestDTO loginRequestDTO) {
        return new ResponseEntity<String>(loginRequestDTO.toString(),
                HttpStatus.OK);
    }
}