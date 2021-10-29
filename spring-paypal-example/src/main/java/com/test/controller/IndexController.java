package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
/**
 * 
 */

@Controller
public class IndexController {
	
	  @RequestMapping("/")
	  public String index() { return
	  "forward:/home.jsp";
	 
	/*
	 * @GetMapping({"/", "/home"}) public String home() {
	 * 
	 * return "home"; }
	 */
    

}