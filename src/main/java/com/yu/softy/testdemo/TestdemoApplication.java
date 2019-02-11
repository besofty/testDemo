package com.yu.softy.testdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * exclude = DataSourceAutoConfiguration.class
 * 排除 jdbc 的自动装配机制即可
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
/**
 * mybatis
 * @MapperScan("com.yu.softy.testdemo.dal.mapper")
 */
@ServletComponentScan
public class TestdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestdemoApplication.class, args);
	}
}
