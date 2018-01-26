package com.swim.pswim.dao;

import com.swim.pswim.vo.Customer;

public interface CustomerMapper {
	public int insertCustomer(Customer customer);
	public Customer selectOneCustomer(String id);
}
