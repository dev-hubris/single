package com.example.demo.admin.model;

public class Member {

    private String name;
    private String email;

    // 생성자
    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getter 및 Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
