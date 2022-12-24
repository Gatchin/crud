package com.polozov.spring.dao;

import com.polozov.spring.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }


    public List<Person> index() {
      return jdbcTemplate.query("Select * from Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("select * from person where id =?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void save(Person person) {
       jdbcTemplate.update("insert into person values(1,?,?)", person.getName(),person.getAge());
    }

    public void update(int id, Person person) {
       jdbcTemplate.update("update Person set name=?, age=? where id=?", person.getName(),person.getAge(),id);
    }

    public void delete(int id) {
        jdbcTemplate.update("delete from Person where id=?",id);
    }

}
