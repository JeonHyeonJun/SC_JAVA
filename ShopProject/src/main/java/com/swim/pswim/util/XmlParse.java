package com.swim.pswim.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.swim.pswim.vo.Product;

public class XmlParse {
	
public ArrayList<Product> assignData(String uri) {
		
		ArrayList<Product> list = new ArrayList<>();
		
		// euc-kr 로 변환된 byte 문자열을 다시 유니코드 String 으로 변환.
		// String 생성자의 
		// 첫 번째 인자로 문자열 byte 배열을  넣어주고, 
		// 두 번째 인자로 byte 배열의 인코딩 값을 넣어준다.
		try {
			String tagName = "Product";
			
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

					String productCode = getTagValue("ProductCode", (Element) nodeItem);
					String productName = getTagValue("ProductName", (Element) nodeItem);
					String price = getTagValue("ProductPrice", (Element) nodeItem);
					String productImage = getTagValue("ProductImage", (Element) nodeItem);
					String basicImage = getTagValue("BasicImage", (Element) nodeItem);
					String seller = getTagValue("Seller", (Element) nodeItem);
					
					String productPrice = price.split("원")[0];
					Product product = new Product(productCode, productName, productPrice, productImage, basicImage, seller);
					
					list.add(product);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} catch (ParserConfigurationException e) {
			
		} catch (SAXException e) {

		} catch (IOException e) {

		} catch (Exception e) {
			e.printStackTrace();
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
