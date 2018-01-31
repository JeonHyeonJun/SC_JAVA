package com.swim.pswim;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swim.pswim.util.XmlParse;
import com.swim.pswim.vo.Product;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	final int pageSize = 20;
	
	XmlParse xmlparse = new XmlParse();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, @RequestParam(defaultValue="") String text, @RequestParam(defaultValue="1") int page) {
		String txt = "";
		try {
			txt = URLEncoder.encode(text, "euc-kr");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String uri = "http://openapi.11st.co.kr/openapi/OpenApiService.tmall?key=470c22aada080760827dae30daa86ac4&apiCode=ProductSearch&keyword="+txt+"&pageNum="+page+"&pageSize="+pageSize;
		logger.info("메인페이지 시작");
		ArrayList<Product> list = xmlparse.assignData(uri);
		model.addAttribute("list", list);
		model.addAttribute("text", text);
		logger.info("메인페이지 종료");
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value="pageplus", method=RequestMethod.POST)
	public ArrayList<Product> pageplus(String text, int page) {
		String txt = "";
		try {
			txt = URLEncoder.encode(text, "euc-kr");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String uri = "http://openapi.11st.co.kr/openapi/OpenApiService.tmall?key=470c22aada080760827dae30daa86ac4&apiCode=ProductSearch&keyword="+txt+"&pageNum="+page+"&pageSize="+pageSize;
		logger.info(page+"페이지 시작");
		ArrayList<Product> list = xmlparse.assignData(uri);
		logger.info(page+"페이지 종료");
		return list;
	}
}
