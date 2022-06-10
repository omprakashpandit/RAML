package com.pak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class RamlSpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(RamlSpringMvcApplication.class, args);
	}
/*	@RequestMapping("/hello")
	public String hello()
	{
		return "Hello World..";
	}

 */
/*
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/students")
	public String getProductList() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity <String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange("http://localhost:8080/api/students", HttpMethod.GET, entity, String.class).getBody();
	}

 */



}
//mvn clean package
// http://localhost:8080/api/students/getAllStudents
// http://localhost:8080/api/students/student/4