package com.proyecto.proyecto.mappers;

import com.proyecto.proyecto.dtos.UserRequestDto;
import com.proyecto.proyecto.dtos.UserResponseDto;
import com.proyecto.proyecto.models.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto toResponse(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getRole().name()
        );
    }

    public User toModel(UserRequestDto userDTO) {
        return new User(
                null,
                userDTO.getFirstname(),
                userDTO.getLastname(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getRole()
        );
    }
}
