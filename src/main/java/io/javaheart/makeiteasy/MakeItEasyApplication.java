package io.javaheart.makeiteasy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MakeItEasyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MakeItEasyApplication.class, args);
	}
}
