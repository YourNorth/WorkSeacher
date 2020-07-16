package com.tenere_bufo.itis.repository;

import com.tenere_bufo.itis.model.State;
import com.tenere_bufo.itis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Arrays;

@Component
public class UserRepository2 {
    private static final String SQL_UPDATE_STATE = "update users set status = ? where token = ? ";
    //language=SQL
    private static final String SQL_UPDATE_BY_EMAIL = "update users set age = ? and first_name = ? and lastName = ?" +
            "and description = ? and country = ? and city = ? and gender = ? and general_skill = ? and " +
            "education = ? and native_language = ? and link_img = ? where email = ?";


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository2(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void updateByStatus(User entity) {
        jdbcTemplate.update(
                SQL_UPDATE_STATE,
                State.ACTIVE.toString(), entity.getToken());
    }

    public void updateByEmail(User user, String email){
        List<String> images = Arrays.asList("/img/candiateds/1.png", "/img/candiateds/2.png", "/img/candiateds/3.png",
                "/img/candiateds/4.png", "/img/candiateds/5.png", "/img/candiateds/6.png", "/img/candiateds/7.png",
                "/img/candiateds/8.png", "/img/candiateds/9.png", "/img/candiateds/10.png");
        user.setLink_img(images.get((int) ( Math.random() * 9)));
        jdbcTemplate.update(SQL_UPDATE_BY_EMAIL,
                user.getAge(), user.getFirstName(), user.getLastName(),
                user.getDescription(), user.getCountry(),
                user.getCity(), user.getGender(), user.getGeneral_skill(),
                user.getEducation(), user.getNative_language(), user.getLink_img(), email);
    }
}
