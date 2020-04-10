package org.spring.batch.db;

import java.util.Arrays;

import org.spring.batch.db.job.StoreProcedueInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

//@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class Application {
	@Autowired
	StoreProcedueInvoker storeProcedueInvoker;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("dsfsdf");
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			StoreProcedueInvoker bean = ctx.getBean(StoreProcedueInvoker.class);
			bean.invokeCmcInterestRateChangeStatisticsProcedure(Arrays.asList("049890976193784678"));

		};
	}
}
