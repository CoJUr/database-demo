package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    PersonJdbcDao dao;

    public static void main(String[] args) {
        SpringApplication.run(DatabaseDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //fire a query to the database and print the results using PersonDao
        logger.info("All users -> {}", dao.findAll());
        logger.info("User id 10001 -> {}", dao.findById(10005));
        logger.info("Inserting new user -> {}", dao.insert(new Person(10005, "John", "London", new Date())));
        logger.info("Deleting user id 10002 -> No of rows deleted = {}", dao.deleteById(10002));
    }
}
