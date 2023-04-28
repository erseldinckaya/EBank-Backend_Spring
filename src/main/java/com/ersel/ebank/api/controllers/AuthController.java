package com.ersel.ebank.api.controllers;

import com.ersel.ebank.business.abstracts.JwtService;
import com.ersel.ebank.business.requests.AuthRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/api/auth")
@RestController
@CrossOrigin
public class AuthController {

    private JwtService jwtService;

    private AuthenticationManager authenticationManager;


    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("Invalid user request !");
        }

    }
}
