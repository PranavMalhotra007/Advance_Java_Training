package com.lpu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CollegeController {
	public static void main(String[]args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		//CollegeService service = context.getBean(CollegeService.class);
		//service.saveCollege(new College(1,"LPU"));   
		DBConnection db = context.getBean(DBConnection.class);
		db.fetchData();
		context.close();
	}
}
