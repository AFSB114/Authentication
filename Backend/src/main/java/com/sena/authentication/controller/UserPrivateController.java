package com.sena.authentication.controller;

import com.sena.authentication.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/private/user")
public class UserPrivateController {

    private final UserService userService;

    public UserPrivateController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ResponseEntity<String> log(@RequestBody String request) {
        return ResponseEntity.ok("well");
    }
}
