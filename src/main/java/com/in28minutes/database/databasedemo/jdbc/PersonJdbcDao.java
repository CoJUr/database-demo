package com.in28minutes.database.databasedemo.jdbc;

import com.in28minutes.database.databasedemo.entity.Person;
import org.h2.result.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonJdbcDao {

    //need connection to the database using spring jdbc template
    @Autowired
    JdbcTemplate jdbcTemplate;

    class PersonRowMapper implements RowMapper<Person> {
//rowmapper interface defines how to map a row from the result set to a Java object. usually wont use the rowNumber parameter
        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthDate(rs.getDate("birth_date"));
            return person;
//            now if table definition is different from the class definition, we can use this custom rowmapper
        }
    }

    public List<Person> findAll() {
/*        need to map data to the person bean

         execute the query and return the results */

        return jdbcTemplate.query("select * from PERSON",
                new PersonRowMapper());
        //  when using BeanPropertyRowMapper, need an empty constructor in the bean class
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject("select * from PERSON where id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<Person>(Person.class));
    }

    public int insert(Person person) {
//        explicitly specify the columns and values to be inserted so that order of columns in db won't matter
        return jdbcTemplate.update("insert into PERSON (id, name, location, birth_date) values (?, ?, ?, ?)",
                person.getId(), person.getName(), person.getLocation(), person.getBirthDate());
    }

    public int deleteById(int id) {

        return jdbcTemplate.update
                ("select * from PERSON where id=?", new Object[] {id});
//        returns the number of rows affected, an int
    }

    public int update(Person person) {
        return jdbcTemplate.update("update person set name = ?, location = ?, birth_date = ? where id = ?",
                person.getName(), person.getLocation(), person.getBirthDate(), person.getId());
    }

}
