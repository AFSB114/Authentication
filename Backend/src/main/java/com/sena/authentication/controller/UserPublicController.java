package com.sena.authentication.controller;

import com.sena.authentication.DTO.AuthResponseDTO;
import com.sena.authentication.DTO.UserLoginDTO;
import com.sena.authentication.DTO.UserRegisterDTO;
import com.sena.authentication.Model.User;
import com.sena.authentication.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/public/user")
class UserPublicController {

    private final UserService userService;

    public UserPublicController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers() {
        List<User> res = userService.getAllUsers();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/active")
    public ResponseEntity<?> getActiveUsers() {
        List<User> res = userService.getActiveUsers();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/inactive")
    public ResponseEntity<?> getInactiveUsers() {
        List<User> res = userService.getInactiveUsers();
        return ResponseEntity.ok(res);
    }

    @PostMapping("/log-up")
    public ResponseEntity<String> logUp(@RequestBody UserRegisterDTO userRegisterDTO) {
        System.out.println("UserRegisterDTO: " + userRegisterDTO);
        return ResponseEntity.ok("well");
    }

    @GetMapping("/log-in")
    public ResponseEntity<AuthResponseDTO> log(@RequestBody UserLoginDTO request) {
        AuthResponseDTO response = userService.login(request);
        return ResponseEntity.ok(response);
    }
}
