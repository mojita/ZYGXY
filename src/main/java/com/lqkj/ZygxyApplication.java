package com.lqkj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lqkj.**.dao")
public class ZygxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZygxyApplication.class, args);
	}
}
