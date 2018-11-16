package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.example.demo.Filter.CustomFilter;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ApgateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApgateWayApplication.class, args);
	}
	
	
	@Bean
	
	public CustomFilter customfilter(){
		return new CustomFilter();
	}
}
