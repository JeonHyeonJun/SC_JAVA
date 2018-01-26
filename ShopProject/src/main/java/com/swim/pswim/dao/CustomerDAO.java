package com.swim.pswim.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.swim.pswim.vo.Customer;

@Repository
public class CustomerDAO {
	
	@Inject
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerDAO.class);
	
	public int insertCustomer(Customer customer){
		logger.info("회원등록 시작");
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		int result = 0;
		
		try{
			result = mapper.insertCustomer(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("회원등록 종료");
		return result;
	}
	
	public Customer selectOneCustomer(String id){
		logger.info("회원정보검색 시작");
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		Customer customer = null;
		
		try{
			customer = mapper.selectOneCustomer(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("회원정보검색 종료");
		return customer;
	}
}
