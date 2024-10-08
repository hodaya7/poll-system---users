package com.pollsSystem.pollsSystem.service;

import com.pollsSystem.pollsSystem.model.User;

import java.util.List;

public interface UserService {
    void createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    void updateUserById(Long userId, User user);
    void deleteUser(Long id) throws Exception;
    public String getUserNameById(Long userId);
}
