package com.stackroute.springbootneo4jCRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories
public class SpringBootNeo4jCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootNeo4jCrudApplication.class, args);
	}

}
