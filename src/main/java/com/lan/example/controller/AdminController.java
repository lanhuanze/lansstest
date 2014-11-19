package com.lan.example.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@Slf4j
public class AdminController {

	@RequestMapping("/welcome")
	protected ModelAndView homePage() {
		log.debug("Go to main.jsp");
		return new ModelAndView("hello");
	}
	
	@RequestMapping("/login")
	protected ModelAndView loginPage() {
		log.debug("Go to login.jsp");
		return new ModelAndView("login");
	}
}
