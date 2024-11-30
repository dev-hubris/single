package com.example.demo.user.mapper;

import com.example.demo.user.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO users (user_id, user_pwd, user_name, user_birth, user_email, user_phone, user_adr, user_adrdetail, user_gender) " +
            "VALUES (#{userId}, #{password}, #{name}, #{birthdate}, #{email}, #{phone}, #{address}, #{addressDetail}, #{gender})")
    void saveUser(User user);

    @Select("SELECT id, user_id AS userId, user_pwd AS password, user_name AS name, " +
            "user_birth AS birthdate, user_email AS email, user_phone AS phone, " +
            "user_adr AS address, user_adrdetail AS addressDetail, user_gender AS gender, " +
            "user_grade AS grade, user_status AS status, user_sns_dist AS snsDist " +
            "FROM users WHERE user_id = #{userId}")
    User findByUserId(String userId);


    @Select("SELECT COUNT(*) FROM users WHERE user_id = #{userId}")
    int countByUserId(String userId);

    @Select("SELECT user_name FROM users WHERE user_id = #{userId}")
    String findNameByUserId(String userId);

    @Update("UPDATE users SET user_pwd = #{password} WHERE user_id = #{userId}")
    void updatePassword(@Param("userId") String userId, @Param("password") String password);

}
