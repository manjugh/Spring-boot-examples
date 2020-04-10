package com.spring.batch.xml.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.batch.item.xml.builder.StaxEventItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.spring.batch.xml.job.domain.Employee;
import com.spring.batch.xml.job.domain.User;

@EnableBatchProcessing
@Configuration
public class XMlProcessorJob {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public StaxEventItemReader<User> xmlReader() {
		StaxEventItemReaderBuilder<User> builder = new StaxEventItemReaderBuilder<User>();
		FileSystemResource fsr = new FileSystemResource("D:\\Tuts\\java-workspace\\spring-examples\\spring-batch-xml\\src\\main\\resources\\NewFile.xml");
		return builder.addFragmentRootElements("users","employee").resource(fsr).name("xmlreader").unmarshaller(xmlUnMarshaller())
				.build();
	}

	private Jaxb2Marshaller xmlUnMarshaller() {
		Jaxb2Marshaller jaxbMarshaller = new Jaxb2Marshaller();
		//jaxbMarshaller.setMappedClass(User.class);
		jaxbMarshaller.setClassesToBeBound(Employee.class);
		//jaxbMarshaller.setSupportJaxbElementClass(true);
		return jaxbMarshaller;
	}

	@Bean
	public StaxEventItemWriter<User> xmlWriter() {
		StaxEventItemWriterBuilder<User> builder = new StaxEventItemWriterBuilder<User>();
		FileSystemResource fsr = new FileSystemResource("UserOutput.xml");
		return builder.marshaller(xmlUnMarshaller())
					  .name("xmlwriter")
					  .resource(fsr)
					  .rootTagName("User")
					  .build();
	}

	@Bean
	public Step xmlStep() {
		return stepBuilderFactory.get("xmlprocessor").<User, User>chunk(1).reader(xmlReader()).writer(xmlWriter())
				.build();
	}

	@Bean
	public Job xmlJob() {
		return jobBuilderFactory.get("xmlProcessorJob").start(xmlStep()).build();
	}
}
