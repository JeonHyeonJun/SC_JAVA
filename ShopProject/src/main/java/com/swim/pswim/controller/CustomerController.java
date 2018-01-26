package com.swim.pswim.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swim.pswim.dao.CustomerDAO;
import com.swim.pswim.vo.Customer;

@Controller
public class CustomerController {
	
	@Inject
	CustomerDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@RequestMapping(value="insertCustomerForm", method=RequestMethod.GET)
	public String insertCustomerForm(Customer customer){
		logger.info("회원가입폼 시작");
		logger.info("회원가입종료 시작");
		return "insertCustomer";
	}
	
	@ResponseBody
	@RequestMapping(value="idcheck", method=RequestMethod.GET)
	public boolean idCheck(String id){
		Customer customer = dao.selectOneCustomer(id);
		if(customer == null)
			return true;
		return false;
	}
	
	@RequestMapping(value="insertCustomer", method=RequestMethod.POST)
	public String insertCustomer(Customer customer){
		logger.info("회원가입 시작");
		dao.insertCustomer(customer);
		logger.info("회원가입 종료");
		return "redirect:./";
	}
	
	@RequestMapping(value="loginForm", method=RequestMethod.GET)
	public String loginForm(){
		logger.info("로그인폼 이동 시작");
		logger.info("로그인폼 이동 종료");
		return "loginForm";
	}

	@ResponseBody
	@RequestMapping(value="login", method=RequestMethod.POST)
	public boolean login(@RequestBody Customer customer, HttpSession session){
		Customer c = dao.selectOneCustomer(customer.getId());
		if(c == null){
			return false;
		}
		else if(!c.getPassword().equals(customer.getPassword())){
			return false;
		}
		
		session.setAttribute("loginId", c.getId());
		session.setAttribute("loginName", c.getName());
		return true;
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:./";
	}
}
