package com.subba.jwtsecurity.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtUser {

    private String userName;

    private long id;

    private String role;


}
