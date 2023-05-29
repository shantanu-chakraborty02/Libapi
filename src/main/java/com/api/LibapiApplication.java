package com.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibapiApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(LibapiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("this is testing");

        // you can use my details for this API testing

        // spring.datasource.url=jdbc:mysql://localhost:3306/newdb
        //spring.datasource.username=root
        //spring.datasource.password=Sunny02@

        //postman

        // use these commands
        // localhost:8080/Employee/upload   for uploading the data
        // localhost:8080/Employee   for retrieve all the data from the database

        // PLEASE USE ONLY EXCEL format (.xlsx)

    }
}
