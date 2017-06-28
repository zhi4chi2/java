package org.example.demo.spring.jdbc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.p6spy.engine.spy.P6DriverManagerDataSource;

public class Test {
    public static void main(String[] args) throws Exception {
        P6DriverManagerDataSource dataSource = new P6DriverManagerDataSource();
        dataSource.setUrl("jdbc:p6spy:postgresql://localhost:5432/test");
        dataSource.setUser("postgres");
        dataSource.setPassword("postgres");
        JdbcTemplate template = new JdbcTemplate(dataSource);
        doSomething(template);
    }

    private static void doSomething(JdbcTemplate jdbcTemplate) throws Exception {
        jdbcTemplate.execute("drop table if exists test");
        jdbcTemplate.execute("create table test(id bigint primary key, v int)");

        Map<String, Object> args = new HashMap<>();
        args.put("id", "10");
        args.put("v", "10");
        new SimpleJdbcInsert(jdbcTemplate.getDataSource()).withTableName("test").execute(args);
    }
}
