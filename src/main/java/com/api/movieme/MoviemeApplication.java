package com.api.movieme;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoviemeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MoviemeApplication.class, args);
	}
        
        @Override
        public void run(String... args) throws Exception {
            System.out.println("começou \nn");
        }


}
