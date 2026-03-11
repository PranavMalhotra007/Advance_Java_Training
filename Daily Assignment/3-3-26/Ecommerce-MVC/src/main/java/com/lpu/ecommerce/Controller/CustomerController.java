package com.lpu.ecommerce.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.lpu.ecommerce.Entity.Customer;
import com.lpu.ecommerce.Service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@RequestMapping("/register")
	public String register(Model model) {
	    model.addAttribute("customer", new Customer());
	    return "register";
	}
	@RequestMapping("/reg")
	public ModelAndView reg(@ModelAttribute Customer c) {
			customerService.saveCustomer(c);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("login");
			return mv;
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/")
	public String defaultPage() {
	    return "login";
	}
	@RequestMapping("/log")
	public String log(@ModelAttribute Customer c, Model model) {

		Customer validCustomer = customerService.loginCustomer(
				c.getCustomer_ID(), 
				c.getPassword()
		);

		if (validCustomer != null) {
			model.addAttribute("name", validCustomer.getName());
			return "index";
		} else {
			model.addAttribute("error", "Wrong Customer ID or Password");
			return "login";
		}
	}
}
