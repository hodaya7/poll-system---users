package com.pollsSystem.pollsSystem.repository;

import com.pollsSystem.pollsSystem.model.User;

import java.util.List;

public interface UserRepository {
    void createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    void updateUserById(Long userId, User user);
    void deleteUser(Long id);
    //3
    public String getUserNameById(Long userId);
}
