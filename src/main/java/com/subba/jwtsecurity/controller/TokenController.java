package com.subba.jwtsecurity.controller;

import com.subba.jwtsecurity.model.JwtUser;
import com.subba.jwtsecurity.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("token")
public class TokenController {

    @Autowired
    TokenService tokenService;

    @PostMapping(value = "/home")
    public String getHome(@RequestBody JwtUser jwtUser) throws UnsupportedEncodingException {
        return tokenService.generateToken(jwtUser);
    }

}
