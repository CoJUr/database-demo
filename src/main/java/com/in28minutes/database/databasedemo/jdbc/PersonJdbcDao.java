package com.in28minutes.database.databasedemo.jdbc;

import com.in28minutes.database.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJdbcDao {

    //need connection to the database using spring jdbc template
    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Person> findAll() {
/*        need to map data to the person bean

         execute the query and return the results */

        return jdbcTemplate.query("select * from PERSON",
                new BeanPropertyRowMapper<Person>(Person.class));
        //  when using BeanPropertyRowMapper, need an empty constructor in the bean class
    }
}
