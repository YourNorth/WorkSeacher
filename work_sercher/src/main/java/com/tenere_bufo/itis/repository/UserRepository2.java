package com.tenere_bufo.itis.repository;

import com.tenere_bufo.itis.model.State;
import com.tenere_bufo.itis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserRepository2 {
    private static final String SQL_UPDATE_STATE = "update users set status = ? where token = ? ";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository2(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void update(User entity) {
        jdbcTemplate.update(
                SQL_UPDATE_STATE,
                State.ACTIVE.toString(), entity.getToken());
    }
}
