package com.lpu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;
	@RequestMapping("/form")
	public String form() {
		return "form";
	}
	@RequestMapping("/find")
	public String find() {
		return "find";
	}
	@RequestMapping("/displayById")
	public ModelAndView display(
			@RequestParam(value = "id") int id) {
			ModelAndView mv = new ModelAndView();
			Student s = studentService.findStudent(id);
			mv.addObject("id",s.getId());
			mv.addObject("name",s.getName());
			mv.addObject("phone",s.getPhone());
			mv.addObject("email",s.getEmail());
			mv.setViewName("display");
		return mv;
	}
	@RequestMapping("/reg")
	public ModelAndView register(@ModelAttribute Student s) {
			studentService.saveStudent(s);
			ModelAndView mv = new ModelAndView();
			mv.addObject("id",s.getId());
			mv.addObject("name",s.getName());
			mv.addObject("phone",s.getPhone());
			mv.addObject("email",s.getEmail());
			mv.setViewName("display");
			return mv;
	}
}
