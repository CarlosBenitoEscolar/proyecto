package com.proyecto.proyecto.controllers;


import java.util.Map;
import com.proyecto.proyecto.auth.LoginRequest;
import com.proyecto.proyecto.auth.JwtService;
import com.proyecto.proyecto.auth.SignupRequest;
import com.proyecto.proyecto.dtos.UserRequestDto;
import com.proyecto.proyecto.dtos.UserResponseDto;
import com.proyecto.proyecto.mappers.UserMapper;
import com.proyecto.proyecto.services.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
@CrossOrigin                        // PERMITE EL INTERCAMBIO ENTRE BACKEND Y FRONTEND PUERTO DE ANGULAR
@RequiredArgsConstructor
public class UserController {
    private final UserDetailsServiceImpl userService;
    private final UserMapper userMapper;

    @GetMapping("/{email}")
    public ResponseEntity<UserResponseDto> getUser(
            @PathVariable String email
    ) {
        return ResponseEntity.ok(userMapper.toResponse(userService.loadUserByUsername(email)));
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> postUser(
            @RequestBody UserRequestDto user
    ) {
        return ResponseEntity.ok(userMapper.toResponse(userService.save(userMapper.toModel(user))));
    }

    @PutMapping("/{email}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable String email,
            @RequestBody UserRequestDto user
    ) {
        return ResponseEntity.ok(userMapper.toResponse(userService.updateUser(email, userMapper.toModel(user))));
    }
}