package com.lpu;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class BeanLifeCycle {

	public BeanLifeCycle() {
		System.out.println("instantiation of Bean");
	}
	@PostConstruct
	public void init() {
		System.out.println("initialization");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("destroy");
	}
	
}
