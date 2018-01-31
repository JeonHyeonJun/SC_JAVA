package com.swim4.swim.customer.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.swim4.swim.customer.controller.CustomerController;
import com.swim4.swim.customer.vo.Customer;

@Repository
public class CustomerDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerDAO.class);
	
	@Inject
	SqlSession sqlSession;
	
	public Customer searchCustomerOne(String custid){
		logger.info("회원 정보 검색 시작");
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		Customer customer = null;
		
		try{
			customer = mapper.searchCustomerOne(custid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("회원 정보 검색 종료");
		return customer;
	}
	
	public int insertCustomer(Customer customer){
		logger.info("회원 정보 등록 시작");
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		int result = 0;
		
		try{
			result = mapper.insertCustomer(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("회원 정보 등록 종료");
		return result;
	}
	
	public int updateCustomer(Customer customer){
		logger.info("회원 정보 수정 시작");
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		int result = 0;
		
		try{
			result = mapper.updateCustomer(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("회원 정보 수정 종료");
		return result;
	}
	
}
