package com.swim.pswim.controller;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swim.pswim.dao.BoardDAO;
import com.swim.pswim.util.XmlParse;
import com.swim.pswim.vo.Board;
import com.swim.pswim.vo.Product;

@Controller
public class ProductController {
	
	@Inject
	BoardDAO boardDao;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	XmlParse xmlparse = new XmlParse();
	
	@ResponseBody
	@RequestMapping(value="insertCart", method=RequestMethod.POST)
	public void insertCart(int productCode, HttpSession session){
		logger.info("장바구니담기 시작");
		String uri = "http://openapi.11st.co.kr/openapi/OpenApiService.tmall?key=470c22aada080760827dae30daa86ac4&apiCode=ProductInfo&productCode="+productCode;
		
		Product product = xmlparse.assignData(uri).get(0);
		
		ArrayList<Product> cartList = new ArrayList<>();
		if(session.getAttribute("cart") != null)
			cartList = (ArrayList<Product>)session.getAttribute("cart");	
		
		cartList.add(product);
		session.setAttribute("cart", cartList);
		logger.info("장바구니담기 종료");
	}
	
	@RequestMapping(value="cart", method=RequestMethod.GET)
	public String cart(){
		logger.info("장바구니보기 시작");
		logger.info("장바구니보기 종료");
		return "cart";
	}
	
	@RequestMapping(value="productView", method=RequestMethod.GET)
	public String productView(String productCode, String text, Model model){
		logger.info("상품보기 시작");
		String uri = "http://openapi.11st.co.kr/openapi/OpenApiService.tmall?key=470c22aada080760827dae30daa86ac4&apiCode=ProductInfo&productCode="+productCode;
		
		Product product = xmlparse.assignData(uri).get(0);
		ArrayList<Board> boardList = boardDao.boardList(productCode);
		
		model.addAttribute("product", product);
		model.addAttribute("boardList", boardList);
		model.addAttribute("text", text);
		
		logger.info("상품보기 종료");
		return "productView";
	}
}
