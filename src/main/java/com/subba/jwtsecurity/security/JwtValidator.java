package com.subba.jwtsecurity.security;

import com.subba.jwtsecurity.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

    public JwtUser validate(String token){
        JwtUser jwtUser = null;
        try {
            Claims claims = Jwts.parser().setSigningKey("subba").parseClaimsJws(token).getBody();

            jwtUser = new JwtUser();
            jwtUser.setUserName(claims.getSubject());
         //   jwtUser.setId(((Integer)claims.get("userId")).longValue());
            jwtUser.setId(Long.parseLong(String.valueOf(claims.get("userId"))));
            jwtUser.setRole((String) claims.get("role"));
        }
        catch (Exception e){
            throw e;
         //   e.printStackTrace();
        }

        return jwtUser;
    }
}
