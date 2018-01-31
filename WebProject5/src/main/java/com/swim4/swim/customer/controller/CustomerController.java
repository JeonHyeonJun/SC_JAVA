package com.swim4.swim.customer.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.swim4.swim.customer.dao.CustomerDAO;
import com.swim4.swim.customer.vo.Customer;

@Controller
@RequestMapping(value="customer")
@SessionAttributes("customer")
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Inject
	CustomerDAO dao;
	
	@RequestMapping(value="joinForm", method=RequestMethod.GET)
	public String joinForm(Model model){
		
		logger.info("회원 가입 폼 시작");
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		logger.info("회원 가입 폼 종료");
		
		return "customer/joinForm";
	}
	
	@RequestMapping(value="idCheck", method=RequestMethod.GET)
	public String idCheck(Model model){
		logger.info("ID 중복 검사 폼 이동 시작");
		//검색 전후 확인용도
		model.addAttribute("search", false);
		logger.info("ID 중복 검사 폼 이동 종료");
		return "customer/idcheckForm";
	}
	
	@RequestMapping(value="idSearch", method=RequestMethod.POST)
	public String idSearch(String searchId, Model model){
		logger.info("ID 중복 검사 시작");
		Customer customer = dao.searchCustomerOne(searchId);
		model.addAttribute("searchId", searchId);
		model.addAttribute("searchResult", customer);
		model.addAttribute("search", true);
		logger.info("ID 중복 검사 종료");
		return "customer/idcheckForm";
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(@ModelAttribute("customer") Customer customer, Model model){
		logger.info("회원 가입 시작");
		int result = dao.insertCustomer(customer);
		
		if(result != 1){
			//등록 실패
			model.addAttribute("errorMsg", "가입실패");
			logger.info("회원 가입 실패");
			return "customer/joinForm";
		}
		logger.info("회원 가입 성공");
		return "redirect:joinComplete";
	}
	
	@RequestMapping(value="joinComplete", method=RequestMethod.GET)
	public String joinComplete(SessionStatus session, 
			@ModelAttribute("customer") Customer customer,
			Model model){
		logger.info("회원 가입 성공폼 시작");
		model.addAttribute("id", customer.getCustid());
		session.setComplete();
		logger.info("회원 가입 성공폼 종료");
		return "customer/joinComplete";
	}
	
	@RequestMapping(value="loginForm", method=RequestMethod.GET)
	public String loginForm(){
		logger.info("로그인폼 시작+종료");
		return "customer/loginForm";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(Customer customer, HttpSession session, Model model){
		logger.info("로그인 시작");
		Customer customer2 = dao.searchCustomerOne(customer.getCustid());
		
		if(customer2 == null) {
			model.addAttribute("errorMsg", "로그인 실패");
			logger.info("로그인 실패(아이디가 존재하지않음)");
			return "customer/loginForm";
		}
		
		if(customer.getCustid().equals(customer2.getCustid())){
			if(customer.getPassword().equals(customer2.getPassword())){
				session.setAttribute("id", customer2.getCustid());
				session.setAttribute("name", customer2.getName());
				model.addAttribute("success", "success");
				logger.info("로그인 성공");
				return "customer/loginForm";
			}
		}
		model.addAttribute("errorMsg", "로그인 실패");
		logger.info("로그인 실패(비밀번호가 틀림)");
		return "customer/loginForm";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session){
		logger.info("로그아웃 시작");
		session.invalidate();
		logger.info("로그아웃 종료");
		return "redirect:/";
	}
	
	@RequestMapping(value="updateForm", method=RequestMethod.GET)
	public String updateForm(HttpSession session, Model model){
		logger.info("개인정보수정 폼 시작");
		Customer customer = dao.searchCustomerOne((String)session.getAttribute("id"));
		model.addAttribute("customer", customer);
		logger.info("개인정보수정 폼 종료");
		return "customer/updateForm";
	}
	
	@RequestMapping(value="updateCustomer", method=RequestMethod.POST)
	public String updateCustomer(@ModelAttribute("customer") Customer customer, Model model){
		logger.info("개인정보수정 시작");
		int result = dao.updateCustomer(customer);
		if(result != 1){
			model.addAttribute("errorMsg", "수정실패");
			logger.info("개인정보수정 실패");
			return "customer/updateForm";
		}
		logger.info("개인정보수정 성공");
		return "redirect:updateComplete";
	}
	
	@RequestMapping(value="updateComplete", method=RequestMethod.GET)
	public String updateComplete(SessionStatus status
			,HttpSession session
			,Model model
			,@ModelAttribute("customer") Customer customer){
		session.setAttribute("name", customer.getName());
		model.addAttribute("id", customer.getCustid());
		status.setComplete();
		return "redirect:/";
	}
}
