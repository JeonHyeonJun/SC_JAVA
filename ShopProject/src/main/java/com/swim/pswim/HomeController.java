package com.swim.pswim;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.swim.pswim.vo.Product;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, String text) {
		logger.info("메인페이지 시작");
		ArrayList<Product> list = assignData(text);
		model.addAttribute("list", list);
		logger.info(text);
		logger.info("메인페이지 종료");
		return "home";
	}
	
	public ArrayList<Product> assignData(String text) {
		String uri = "http://openapi.11st.co.kr/openapi/OpenApiService.tmall?key=470c22aada080760827dae30daa86ac4&apiCode=ProductSearch&keyword="+text;
		String tagName = "Product";
		ArrayList<Product> list = new ArrayList<>();
		try {

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

			Document xml = documentBuilder.parse(uri);

			Element root = xml.getDocumentElement();

			NodeList nodeList = root.getElementsByTagName(tagName);

			if (nodeList.getLength() == 0)
				return null;

			for (int i = 0; i < nodeList.getLength(); i++) {

				Node nodeItem = nodeList.item(i);

				try {

					String code = getTagValue("ProductCode", (Element) nodeItem);
					String productName = getTagValue("ProductName", (Element) nodeItem);
					String price = getTagValue("ProductPrice", (Element) nodeItem);
					String productImage = getTagValue("ProductImage", (Element) nodeItem);
					String seller = getTagValue("Seller", (Element) nodeItem);
					
					int productCode = Integer.parseInt(code);
					int productPrice = Integer.parseInt(price);
					Product product = new Product(productCode, productName, productPrice, productImage, seller);
					list.add(product);
					// 여기서 값을 대입하시면 됩니다.

					// 저의 경우는 데이터용 클래스를 따로 반들어서 getter setter 로 사용하였습니다.

				} catch (Exception e) {

				}

			}

		} catch (ParserConfigurationException e) {

		} catch (SAXException e) {

		} catch (IOException e) {

		} catch (Exception e) {

		}
		
		return list;
	}

	private String getTagValue(String sTag, Element element) {

		try {

			String result = element.getElementsByTagName(sTag).item(0).getTextContent();

			return result;

		} catch (NullPointerException e) {

			return "";

		} catch (Exception e) {

			return "";

		}

	}
	
}
