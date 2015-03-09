package com.flywaychallenge.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.flywaychallenge.annotations.TableName;
import com.flywaychallenge.mappers.GenericObjectMapper;
import com.flywaychallenge.models.Department;

public class DepartmentDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Department> getAll() {
        return this.jdbcTemplate.query("SELECT * FROM " + Department.class.getAnnotation(TableName.class).value(), new GenericObjectMapper<Department>(Department.class));
    }
    
    public Department getById(Integer id) {
        return this.jdbcTemplate.query("SELECT * FROM " + Department.class.getAnnotation(TableName.class).value()
        		+ " WHERE id = " + id, new GenericObjectMapper<Department>(Department.class)).get(0);
    }    
}
