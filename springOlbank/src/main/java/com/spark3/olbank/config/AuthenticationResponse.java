package com.spark3.olbank.config;


import com.spark3.olbank.user.model.Userx;

import java.io.Serializable;


public class AuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;
    private Userx user;

    public AuthenticationResponse(String token) {
        this.token = token;
    }

    public AuthenticationResponse(String token, Userx user) {
        this.token = token;
        this.user = user;
    }

    public Userx getUser() {
        return user;
    }

    public void setUser(Userx user) {
        this.user = user;
    }

    public String getToken() {
        return this.token;
    }
}
