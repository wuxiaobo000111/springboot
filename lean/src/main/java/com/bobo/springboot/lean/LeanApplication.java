package com.bobo.springboot.lean;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "com.bobo.springboot.lean.dao.mapper")
public class LeanApplication {
	public static void main(String[] args) {
		SpringApplication.run(LeanApplication.class, args);
	}
}
