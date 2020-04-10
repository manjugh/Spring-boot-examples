package org.spring.batch.jobs.simple;

import org.spring.batch.jobs.simple.components.SimpleItem;
import org.spring.batch.jobs.simple.components.SimpleItemReader;
import org.spring.batch.jobs.simple.components.SimpleItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class SimpleJob {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public SimpleItemReader reader(){
		return new SimpleItemReader();
	}
	
	@Bean
	public SimpleItemWriter writer() {
		return new SimpleItemWriter();
	}
	
	@Bean
	public Job simpleJob1() {
		return jobBuilderFactory.get("simpleJob1")
				                .flow(simpleStep())
				                .end()
				                .build();
	}
	
	@Bean
	public Step simpleStep() {
		return stepBuilderFactory.get("simpleStep")
				                 .<SimpleItem,SimpleItem>chunk(1)
				                 .reader(reader())
				                 .writer(writer())
				                 .build();
	}
}
