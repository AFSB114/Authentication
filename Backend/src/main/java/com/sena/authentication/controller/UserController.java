package com.sena.authentication.controller;

import com.sena.authentication.DTO.userLogDTO;
import com.sena.authentication.Model.User;
import com.sena.authentication.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
class UserController {

    private final UserService userService;

    UserController(UserService userService) {
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

    @PostMapping("/log")
    public ResponseEntity<?> log(@RequestBody userLogDTO userLogDTO) {
        return ResponseEntity.ok("well");

    }
}
