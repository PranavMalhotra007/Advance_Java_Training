package com.lpu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@RequestMapping("/register")
	public String register(Model model) {
	    model.addAttribute("employee", new Employee());
	    return "register";
	}
	@RequestMapping("/displayAll")
	public ModelAndView displayAll(
			@RequestParam(value = "id") int id) {
			ModelAndView mv = new ModelAndView();
			List<Employee> employees = employeeService.getAllEmployees();
			mv.addObject("employees",employees);
			mv.setViewName("displayAll");
		return mv;
	}
	@RequestMapping("/reg")
	public ModelAndView reg(@ModelAttribute Employee e) {
			employeeService.saveEmployee(e);
			ModelAndView mv = new ModelAndView();
			List<Employee> employees = employeeService.getAllEmployees();
			mv.addObject("employees",employees);
			mv.setViewName("displayAll");
			return mv;
	}
	@RequestMapping("/update")
	public ModelAndView update(@RequestParam(name = "id") int id) {
		Employee e = employeeService.findEmployee(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee",e);
		mv.setViewName("update");
		return mv;
	}
	@RequestMapping("/updateDone")
	public ModelAndView updateDone(@ModelAttribute Employee e) {
		employeeService.updateEmployee(e.getId(),e.getName(), e.getPhone(), e.getEmail());
		ModelAndView mv = new ModelAndView();
		List<Employee> employees = employeeService.getAllEmployees();
		mv.addObject("employees",employees);
		mv.setViewName("displayAll");
		return mv;
	}
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam(name = "id") int id) {
		employeeService.deleteEmployee(id);
		ModelAndView mv = new ModelAndView();
		List<Employee> employees = employeeService.getAllEmployees();
		mv.addObject("employees",employees);
		mv.setViewName("displayAll");
		return mv;
	}
	
}
