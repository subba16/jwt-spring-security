package com.subba.jwtsecurity.filter;

import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.ExceptionTranslationFilter;

public class JwtExceptionTranslationFilter extends ExceptionTranslationFilter {
    public JwtExceptionTranslationFilter(AuthenticationEntryPoint authenticationEntryPoint) {
        super(authenticationEntryPoint);
    }

}
