package com.example.demo.user.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class User {
    private int id;
    private String userId;
    private String password;
    private String name;
    private LocalDate birthdate;
    private String email;
    private String phone;
    private String address;
    private String addressDetail;
    private String gender;
    private int grade;
    private String status;
    private int snsDist;
}
