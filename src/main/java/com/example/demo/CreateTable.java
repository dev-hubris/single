package com.example.demo;

public class CreateTable {
    public static void main(String[] args) {

        String createProductTable = """
                CREATE TABLE product (
                  id INT PRIMARY KEY AUTO_INCREMENT,
                  name VARCHAR(255) NOT NULL,
                  description TEXT,
                  price DECIMAL(10, 2) NOT NULL,
                  category_id INT);                
                """;

        String createCategoryTable = """
                  CREATE TABLE category (id INT PRIMARY KEY AUTO_INCREMENT,
                  name VARCHAR(255) NOT NULL);
                """;

    }
}
