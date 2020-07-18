package com.tenere_bufo.itis.repository;

import com.tenere_bufo.itis.model.State;
import com.tenere_bufo.itis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByToken(String token);
    Optional<User> findById(Long id);

    @Modifying
    @Query("update users set status = :status where token = :token")
    public void updateStatusByToken(@Param("token") String token, @Param("status")State status) ;

    @Modifying
    @Query("update users " +
            "set age = :age, " +
            "first_name = :first_name," +
            "last_name = :last_name," +
            "description = :description," +
            "country = :country," +
            "city = :city," +
            "gender = :gender," +
            "general_skill = :general_skill," +
            "education = :education," +
            "native_language = :native_language," +
            "link_img = :link_img " +
            "where email = :email")
    public void updateByEmail(String email, Integer age, String firstName, String lastName,
                           String description, String country, String city, String gender,
                           String general_skill, String education, String native_language,
                           String link_img);


}
