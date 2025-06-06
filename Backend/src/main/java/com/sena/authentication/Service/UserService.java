package com.sena.authentication.Service;

import com.sena.authentication.Model.User;
import com.sena.authentication.Repository.iUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final iUser iUser;

    public UserService(iUser iUser) {
        this.iUser = iUser;
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

