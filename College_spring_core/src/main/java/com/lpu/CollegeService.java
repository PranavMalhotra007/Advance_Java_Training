package com.lpu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CollegeService {
	@Autowired
	private CollegeDao collegeDao;
	public void saveCollege(College c) {
		collegeDao.saveCollege(c);
	}
}
