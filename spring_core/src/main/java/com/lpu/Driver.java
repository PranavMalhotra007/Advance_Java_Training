package com.lpu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	public static void main(String[]args) {
		//BeanFactory b;
		//creating container
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		System.out.println("main start");
		Student s = context.getBean("myStudent",Student.class);//IOC
		s.study();
		Employee e = context.getBean("emp",Employee.class);
		e.work();
		College c = context.getBean("coll",College.class);
		c.study();
		System.out.println("Id = "+e.getId());
		System.out.println("Name = "+e.getName());
		e.getLaptop().start();
		System.out.println("main end");
	}
}
