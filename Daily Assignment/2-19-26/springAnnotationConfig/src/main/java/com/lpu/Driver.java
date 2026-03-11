package com.lpu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {
	public static void main(String[]args) {
	ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
	Student s = context.getBean("student",Student.class);
	s.study();
	}

}
