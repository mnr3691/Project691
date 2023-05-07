package com.wlj.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.wlj.model.Product;
import com.wlj.model.User;
import com.wlj.model.UserS2;

public interface UserService {

	public void myRegister(User st);

	public boolean myLogin(User st);

	public List<User> getAllusers();

	public boolean myRegisterS2(UserS2 userS2);

	public boolean myLoginS2(UserS2 userS2);

	public List<UserS2> getAllusersS2();

	public boolean myAdminLoginS2(UserS2 userS2);

	@Transactional
	public boolean updateUserStatus(String mailId, String status);

	public List<Product> getAllProducts();

	public boolean addProduct(Product product);

	public void deleteProduct(String productName);


}
