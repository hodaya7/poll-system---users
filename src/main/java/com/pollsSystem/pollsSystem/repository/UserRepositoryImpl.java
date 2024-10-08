package com.pollsSystem.pollsSystem.repository;

import com.pollsSystem.pollsSystem.model.User;
import com.pollsSystem.pollsSystem.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{
    private static final String USER_TABLE_NAME = "my_user";
    @Autowired
    private JdbcTemplate jdbcTemplate;//הקלאיינט h2 הגיע מהגראדל ששמנו
    @Autowired
    private UserMapper userMapper;
    @Override
    public void createUser(User user) {
        String sql = "INSERT INTO " + USER_TABLE_NAME + " (first_name, last_name, email, birthday, address) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getBirthday(), user.getAddress());
    }

    @Override
    public User getUserById(Long id) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE id=?";
        try {
            //מה יכנס בסימן שאלה:
            return jdbcTemplate.queryForObject(sql, userMapper, id);
        } catch (EmptyResultDataAccessException error) {//אם אין תשובה כזו
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM " + USER_TABLE_NAME;
        try {
            return jdbcTemplate.query(sql, userMapper);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public void updateUserById(Long userId, User user) {
        String sql = "UPDATE " + USER_TABLE_NAME + " SET first_name=?, last_name=?, email=?, birthday=?, address=? WHERE id=?";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getBirthday(), user.getAddress(), userId);
    }

    @Override
    public void deleteUser(Long id) {
        String sql = "DELETE FROM " + USER_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
    //3
    @Override
    // עוזר לפונקציה כדי לקבל את שם המשתמש לפי userId
    public String getUserNameById(Long userId) {
        String sql = "SELECT CONCAT(first_name, ' ', last_name) AS full_name FROM "+ USER_TABLE_NAME+" WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, String.class, userId);
        }
        catch (EmptyResultDataAccessException error) {
            return null;
        }

    }
}
