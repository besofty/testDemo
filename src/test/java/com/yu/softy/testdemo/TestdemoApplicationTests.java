package com.yu.softy.testdemo;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("dev")
@Ignore
public class TestdemoApplicationTests {
    private DataSource dataSource;
    protected JdbcTemplate jdbcTemplate;
    @LocalServerPort
    int randomServerPort;
    private RequestSpecification requestSpecification;
    private String contextPath = "/api";

    @Before
    public void setUp(){
        if (dataSource == null) {
            dataSource = dataSource();
        }
        if (jdbcTemplate == null) {
            jdbcTemplate = new JdbcTemplate(dataSource());
        }
        requestSpecification = new RequestSpecBuilder()
                .setBasePath(contextPath)
                .setPort(randomServerPort)
                .build();
        RestAssured.requestSpecification = requestSpecification;
    }

    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://10.100.20.14:3306/fuqiqianbao2018_09_07?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;
    }
}
