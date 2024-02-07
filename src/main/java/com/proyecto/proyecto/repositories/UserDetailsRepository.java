package com.proyecto.proyecto.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.proyecto.models.user.User;

public interface UserDetailsRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
