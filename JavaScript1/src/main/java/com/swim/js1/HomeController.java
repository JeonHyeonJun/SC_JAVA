package com.swim.js1;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="day2", method = RequestMethod.GET)
	public String day2(){
		return "day2";
	}
	
	@RequestMapping(value="day3", method = RequestMethod.GET)
	public String day3(){
		return "day3";
	}
	
	@RequestMapping(value="popup", method = RequestMethod.GET)
	public String popup(){
		return "popup";
	}
	
	@RequestMapping(value="day4", method = RequestMethod.GET)
	public String day4(){
		return "day4";
	}
	
	@RequestMapping(value="jQuery1", method = RequestMethod.GET)
	public String jQuery1(){
		return "jQuery1";
	}
	
	@RequestMapping(value="jQuery2", method = RequestMethod.GET)
	public String jQuery2(){
		return "jQuery2";
	}
	
	@RequestMapping(value="jQuery3", method = RequestMethod.GET)
	public String jQuery3(){
		return "jQuery3";
	}
	
	@RequestMapping(value="jQuery4", method = RequestMethod.GET)
	public String jQuery4(){
		return "jQuery4";
	}
	
	@RequestMapping(value="jQuery5", method = RequestMethod.GET)
	public String jQuery5(){
		return "jQuery5";
	}
}
