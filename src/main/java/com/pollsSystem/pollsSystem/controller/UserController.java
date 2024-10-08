package com.pollsSystem.pollsSystem.controller;

import com.pollsSystem.pollsSystem.model.User;
import com.pollsSystem.pollsSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/create")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }
//    {examp
//        "firstName": "John",
//            "lastName": "Doe",
//            "email": "john.doe@example.com",
//            "birthday": "1990-01-01",
//            "address": "123 Main St"
//    }

    @PostMapping("/update/{userId}")
    public void updateUserById(@PathVariable Long userId, @RequestBody User user) {
        userService.updateUserById(userId, user);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUserById(@PathVariable Long userId) throws Exception {
        userService.deleteUser(userId);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    //3
    @GetMapping("/userName/{userId}")
    public String getUserNameById(@PathVariable Long userId){
        return userService.getUserNameById(userId);
    }
}
