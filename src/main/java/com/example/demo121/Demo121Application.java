package com.example.demo121;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Demo121Application {

	public static void main(String[] args) {
		//SpringApplication.run(Demo121Application.class, args);
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Demo121Application.class);
		String[] beanArray = applicationContext.getBeanDefinitionNames();
		System.out.println("ALL BEANS are:: ");
		for(String beanName : beanArray) {
			System.out.println(beanName);
		}

	}

}
