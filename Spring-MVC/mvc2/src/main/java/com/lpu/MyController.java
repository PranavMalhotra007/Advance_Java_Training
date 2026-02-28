package com.lpu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping("/hi")
	public String takeReqHi() {
		return "page.jsp";
	}
	@RequestMapping("/order")
	public String login() {
		return "order.jsp";
	}
	@RequestMapping("/data")
	public String sendData(Model model) {
		model.addAttribute("name","Raju");
		model.addAttribute("phone",888);
		return "display.jsp";
	}
	@RequestMapping("/data1")
	public ModelAndView sendData2(ModelAndView mv) {
		mv.addObject("name","Arifus");
		mv.addObject("phone",777);
		mv.setViewName("display.jsp");
		return mv;
	}
	@RequestMapping("/form")
	public String form() {
		return "form.jsp";
	}
	@RequestMapping("/reg")
	public ModelAndView register(
			@RequestParam(value = "n") String name,
			@RequestParam(value = "p") String phone,
			@RequestParam(value = "e") String email) {
			ModelAndView mv = new ModelAndView();
			mv.addObject("name",name);
			mv.addObject("phone",phone);
			mv.addObject("email",email);
			mv.setViewName("display.jsp");
		return mv;
	}
	@RequestMapping("/reg2")
	public ModelAndView register1(@ModelAttribute Student s) {
			ModelAndView mv = new ModelAndView();
			mv.addObject("name",s.getN());
			mv.addObject("phone",s.getP());
			mv.addObject("email",s.getE());
			mv.setViewName("display.jsp");
				return mv;
	}
}
