package com.tanzicai.caimusic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class CaiMusicApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaiMusicApplication.class, args);
	}

}
