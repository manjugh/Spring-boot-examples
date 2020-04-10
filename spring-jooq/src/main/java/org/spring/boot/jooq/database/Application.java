package org.spring.boot.jooq.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Autowired
	private JooqDaoImpl jooqDaoImpl;

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder().web(WebApplicationType.NONE)
				.sources(Application.class).build(args).run(args);

		SpringApplication.exit(applicationContext);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return (args) -> jooqDaoImpl.readbook();
	}
}
