package com.subba.jwtsecurity.config;

import com.subba.jwtsecurity.filter.JwtExceptionTranslationFilter;
import com.subba.jwtsecurity.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collections;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationProvider JwtAuthenticationProvider;
    @Autowired
    private JwtAuthenticationEntryPoint entryPoint;

    @Autowired
    private JwtAccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("**/api/**").authenticated()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler).authenticationEntryPoint(entryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

                // anyRequest().permitAll();

        http.addFilterBefore(jwtfilter(), UsernamePasswordAuthenticationFilter.class);

      //  http.addFilterAfter(, ExceptionTranslationFilter.class)

        http.headers().cacheControl();
    }


    @Bean
    public JwtFilter jwtfilter(){
        JwtFilter jwtFilter = new JwtFilter();
        jwtFilter.setAuthenticationManager(authenticationManager());
        jwtFilter.setAuthenticationSuccessHandler(new JwtSuccesshandler());

        return jwtFilter;
    }

//    @Bean
//    public JwtExceptionTranslationFilter jwtExceptionTranslationFilter(){
//
//
//        return new JwtExceptionTranslationFilter();
//    }


    @Bean
    public AuthenticationManager authenticationManager(){
        return new ProviderManager(Collections.singletonList(JwtAuthenticationProvider));
    }
}
