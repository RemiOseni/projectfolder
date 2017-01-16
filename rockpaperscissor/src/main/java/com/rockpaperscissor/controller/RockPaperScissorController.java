/**
 * 
 */
package com.rockpaperscissor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author RemiOseni
 *
 */
@Controller
public class RockPaperScissorController{
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String defaultPage(){	
		return "home";		
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String homePage(){
		return "home";		
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String indexPage(){
		return "home";		
	}

}
