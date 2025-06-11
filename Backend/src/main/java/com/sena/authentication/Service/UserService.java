package com.sena.authentication.Service;

import com.sena.authentication.DTO.AuthResponseDTO;
import com.sena.authentication.DTO.UserRegisterDTO;
import com.sena.authentication.Model.Role;
import com.sena.authentication.Model.User;
import com.sena.authentication.Repository.iUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final iUser iUser;
    private final JwtService jwtService;

    public UserService(iUser iUser, JwtService jwtService) {
        this.iUser = iUser;
        this.jwtService = jwtService;
    }

    public AuthResponseDTO registerUser(UserRegisterDTO userRegisterDTO) {
        User user = User.builder()
                .name(userRegisterDTO.getName())
                .email(userRegisterDTO.getEmail())
                .password(userRegisterDTO.getPassword())
                .build();
        iUser.save(user);
        return AuthResponseDTO.builder()
                .token(jwtService.getToken(user))
                .build();
    }

    public List<User> getAllUsers() {
        return iUser.findAll();
    }

    public List<User> getActiveUsers() {
        return iUser.getActiveUsers();
    }

    public List<User> getInactiveUsers() {
        return iUser.getInactiveUsers();
    }

    public User getUserById(int id) {
        Optional<User> optionalUser = iUser.findById(id);
        return optionalUser.orElse(null);
    }
}

