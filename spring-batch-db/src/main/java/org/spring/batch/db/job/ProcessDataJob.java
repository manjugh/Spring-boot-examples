package org.spring.batch.db.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@ComponentScan
//@EnableBatchProcessing
public class ProcessDataJob {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Value("${inv.commitInterval}")
	private int commitInterval;
	
	@Value("${inv.skipLimit}")
	private int skipLimit;
	
	@Bean
	public SimpleItemReader reader() {
		return new SimpleItemReader();
	}

	@Bean
	public Job processDataJob1(Step simpleStep) {
		return jobBuilderFactory.get("processDataJob1")
								.incrementer(new RunIdIncrementer())
								.flow(simpleStep)
								.end()
								.build();
	}

	@Bean
	public Step simpleStep(SimpleItemWriter writer,ProcessDataListener processDataListener) {
		return stepBuilderFactory.get("simpleStep")
				.<SimpleItem, SimpleItem>chunk(commitInterval)
				.faultTolerant()
				.skip(RuntimeException.class)
				.skipLimit(skipLimit)
				.reader(reader())
				.writer(writer)
				.listener(processDataListener)
				.build();
	}
}
