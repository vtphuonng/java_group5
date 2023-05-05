package com.example.demo.database;

import org.springframework.context.annotation.Configuration;

import com.example.demo.Product.Product;
import com.example.demo.repo.repo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Configuration
public class database {
	
	private static final Logger logger = LoggerFactory.getLogger(database.class);
	@Bean
	CommandLineRunner initdatabase(repo repository) {
		return new CommandLineRunner() {
			@Override
			public void run(String...args) throws Exception{
				Product productA = new Product(1,"sdfs","asdasd","asdfaf","asdfa", 121L, 2342L);
				Product productB = new Product(2, "hois","hoh","bo","gi", 1771L, 2882L);
				logger.info("insert data: "+repository.save(productA));
				logger.info("insert data: "+repository.save(productB));
			}
		};
	}
	
}
