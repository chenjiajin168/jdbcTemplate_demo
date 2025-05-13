package com.chenjiajin.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class TestMain {      // https://blog.csdn.net/qq_40675243/article/details/119789090
    public static void main(String[] args) {
        // 准备数据源，spring内置数据源
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        // 设置相应参数
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/study?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("root");

        // 创建jdbc对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 设置jdbcTemplate的数据源
        jdbcTemplate.setDataSource(driverManagerDataSource);

        // 执行操作
        jdbcTemplate.execute("insert into TB_USER(userName,userPass)value('abc','123')");
        jdbcTemplate.update("insert into TB_USER(userName,userPass)value(?,?)","hjx","123");
        jdbcTemplate.update("update TB_USER set userPass = ? where userName = ?","456","hjx");
        jdbcTemplate.update("delete from TB_USER where userName = 'abc'");
        jdbcTemplate.query("select * from TB_USER",new BeanPropertyRowMapper<User>(User.class));
    }
}
