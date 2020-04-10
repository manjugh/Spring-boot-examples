package com.spring.boot.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	/*@Autowired
	private  ErrorMapper errorMapper;*/

	@Autowired
	private ErrorMapper errorMapper;

	@Autowired
	private Environment env;

	@RequestMapping("/")
	public String helloWorld() {
		/*System.out.println(env.getProperty("testkey.key1"));
		System.out.println(errorMapper.getAppName());
		errorMapper.getTestKey().keySet().stream().forEach( System.out::println);
		System.out.println(errorMapper.getValue("key1"));
		System.out.println("pasword :::"+errorMapper.getCredential().password);*/
		return "Boot is up!"+env.getProperty("server");
	}
}
