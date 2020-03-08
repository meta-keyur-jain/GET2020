package com.metacube.metaparkingsystemv2.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.metacube.metaparkingsystemv2.dtos.EmployeeDto;
import com.metacube.metaparkingsystemv2.models.Employee;

@Controller
public class HomeController {

	public static boolean isSessionValid(HttpSession session, HttpServletResponse res) {
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session.getAttribute("empId") == null) {
			return false;
		}
		return true;
	}
	

	/*
	 * This method is used to show homepage.
	 */
	@GetMapping({"/home" })
	public String getHomePage() {
		System.out.println("In home controller...");
		return "home";
	}

	/*
	 * This method is used to display register page.
	 */
	@GetMapping("/register")
	public String getRegisterPage(Model model) {
		model.addAttribute("employee", new Employee());
		return "register";
	}

	/*
	 * This method is used to open login page.
	 */
	@GetMapping("/loginUser")
	public String getLoginPage(Model model) {
		model.addAttribute("employeeDto", new EmployeeDto());
		return "login";
	}
	
	/*
	 * This method is used to open security page.
	 */
	@GetMapping({"/","/login"})
	public String getSpringSecurityLoginPage(Model model) {
		return "customSpringSecurityLoginPage";
	}

	/*
	 * This method is used to open display page.
	 */
	@GetMapping("/display")
	public String getDisplayPage(HttpSession session, HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			return "display";
		} else {
			return "redirect:loginUser";
		}
	}
}
