package com.lpu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PersonDirver {
	public static void main(String[]args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		Person p = context.getBean("person",Person.class);
		System.out.println(p.getId());
		System.out.println(p.getId());
		System.out.println(p.getId());
		Adhar a = p.getAdhar();
		System.out.println(a.getId());
		System.out.println(a.getLocation());
		((AnnotationConfigApplicationContext)context).close();
	}
}
