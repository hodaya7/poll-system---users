package com.pollsSystem.pollsSystem.repository.mapper;

import com.pollsSystem.pollsSystem.model.User;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        //מה שחזר ממפה ללונג
        return new User(rs.getLong("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getDate("birthday").toLocalDate(),
                rs.getString("address"));
    }
}
