package com.swim.pswim;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.swim.pswim.util.XmlParse;
import com.swim.pswim.vo.Product;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	final int pageSize = 20;
	
	XmlParse xmlparse = new XmlParse();
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, String text, @RequestParam(defaultValue="1") int page) {
		String uri = "http://openapi.11st.co.kr/openapi/OpenApiService.tmall?key=470c22aada080760827dae30daa86ac4&apiCode=ProductSearch&keyword="+text+"&pageNum="+page+"&pageSize="+pageSize;
		logger.info("메인페이지 시작");
		ArrayList<Product> list = xmlparse.assignData(uri);
		model.addAttribute("list", list);
		logger.info("메인페이지 종료");
		return "home";
	}
	
	
	
}
