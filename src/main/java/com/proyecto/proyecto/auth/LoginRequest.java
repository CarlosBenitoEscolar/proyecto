package com.proyecto.proyecto.auth;


import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}