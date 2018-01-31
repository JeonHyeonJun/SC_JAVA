package com.swim4.swim.customer.dao;

import com.swim4.swim.customer.vo.Customer;

public interface CustomerMapper {
	public Customer searchCustomerOne(String custid);	//회원 정보 검색
	public int insertCustomer(Customer customer);	//회원가입
	public int updateCustomer(Customer customer);	//회원정보수정
}
