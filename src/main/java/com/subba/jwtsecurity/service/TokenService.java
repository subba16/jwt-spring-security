package com.subba.jwtsecurity.service;

import com.subba.jwtsecurity.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.Key;

@Service
public class TokenService {


    @Autowired
    Environment environment;


    public String generateToken(JwtUser jwtUser) throws UnsupportedEncodingException {
    //    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        Claims claims = Jwts.claims().setSubject(jwtUser.getUserName());

        claims.put("userId", jwtUser.getId());
        claims.put("role", jwtUser.getRole());

        System.out.println(environment.getProperty("hello"));

       // String jws = Jwts.builder().setSubject("SubbaM").signWith(SignatureAlgorithm.HS256,"subba").compact();

        String jws = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256,"subba").compact();

        return jws;
    }
}
