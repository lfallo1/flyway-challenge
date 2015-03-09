package com.flywaychallenge.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.flywaychallenge.annotations.TableName;
import com.flywaychallenge.mappers.GenericObjectMapper;
import com.flywaychallenge.models.Employee;

public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> getAll() {
        return this.jdbcTemplate.query("SELECT * FROM " + Employee.class.getAnnotation(TableName.class).value(), new GenericObjectMapper<Employee>(Employee.class));
    }
    
    public Employee getById(Integer id) {
        return this.jdbcTemplate.query("SELECT * FROM " + Employee.class.getAnnotation(TableName.class).value()
        		+ " WHERE id = " + id, new GenericObjectMapper<Employee>(Employee.class)).get(0);
    }    
}
