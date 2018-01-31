package com.swim.ajax1.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swim.ajax1.vo.Person;

//@RestController를 붙인 Controller는 @ResponseBody를 안붙여도 ajax실행이 가능
@RestController
public class AjaxRestController {

	@RequestMapping(value="ajaxtest1", method=RequestMethod.GET)
	public String ajaxtest1(){
		System.out.println("꺄륵!실행");
		return "kore";
	}
	
	@RequestMapping(value="ajaxtest2", method=RequestMethod.POST)
	public String ajaxtest2(String str){
		System.out.println(str);
		return "resources/img/eb.gif";
	}
	
	@RequestMapping(value="insert1", method=RequestMethod.POST)
	public Person insert1(@RequestBody Person p){
		System.out.println(p);
		return p;
	}
	
	@RequestMapping(value="insert3", method=RequestMethod.POST)
	public Person insert3(Person p){
		System.out.println(p);
		return p;
	}
	
	@RequestMapping(value="jsontest", method=RequestMethod.GET)
	public Person jsontest(){
		Person p = new Person("resources/img/eb.gif", 19, "없음");
		return p;
	}
}
