package com.sena.authentication.Service;

import com.sena.authentication.DTO.AuthResponseDTO;
import com.sena.authentication.DTO.UserLoginDTO;
import com.sena.authentication.DTO.UserRegisterDTO;
import com.sena.authentication.Model.Role;
import com.sena.authentication.Model.User;
import com.sena.authentication.Repository.iUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

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
        System.out.print("User registered successfully");
        AuthResponseDTO authResponseDTO = AuthResponseDTO
                .builder()
                .token(jwtService.getToken(user))
                .build();
        System.out.printf("Auth response successfully" +  authResponseDTO);
        return authResponseDTO;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = iUser.findUserByName(username);
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getName());
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    Collections.singleton(authority)
            );
        } catch (UsernameNotFoundException e){
            throw new UsernameNotFoundException("User not found");
        }
    }

    public AuthResponseDTO login(UserLoginDTO request) {
        return null;
    }
}

