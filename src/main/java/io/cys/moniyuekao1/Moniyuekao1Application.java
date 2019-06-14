package io.cys.moniyuekao1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("io.cys.moniyuekao1.dao")
public class Moniyuekao1Application {

	public static void main(String[] args) {
		SpringApplication.run(Moniyuekao1Application.class, args);
	}

}
