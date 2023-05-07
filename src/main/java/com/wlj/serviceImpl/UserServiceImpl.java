package com.wlj.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.wlj.constants.MyConstants;
import com.wlj.model.Product;
import com.wlj.model.User;
import com.wlj.model.UserS2;
import com.wlj.repository.ProductRepository;
import com.wlj.repository.UserRepository;
import com.wlj.repository.UserRepositoryS2;
import com.wlj.service.UserService;
import com.wlj.utils.MyUtils;

@Service
public class UserServiceImpl implements UserService {

	@Value("${userid.start.id}")
	int userIdStart;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserRepositoryS2 userRepositoryS2;
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public void myRegister(User user) {
		int userId = userRepository.getMaxUserId();
		if (userId != 0) {
			userId += 1;
		} else {
			userId = userIdStart;
		}
		user.setUserId(userId);
		userRepository.save(user);

	}

	@Override
	public boolean myLogin(User user) {

		Optional<User> userFromDB = userRepository.findById(user.getUserId());

		User us = null;

		if (userFromDB.isPresent()) {
			us = userFromDB.get();
		} else {
			return false;
		}

		if (null != userFromDB && user.getUserId() == us.getUserId() && user.getPassword().equals(us.getPassword())) {
			return true;
		}

		return false;
	}

	@Override
	public List<User> getAllusers() {
		return userRepository.findAll();
	}

	@Override
	public boolean myRegisterS2(UserS2 userS2) {
		String emailFromDB = userRepositoryS2.getUserS2Email(userS2.getEmail());
		if (null == emailFromDB || emailFromDB.length() == 0) {
			if (null == userS2.getUserType()) {
				userS2.setUserType(MyConstants.GENERAL);
			}
			userS2.setPassword(MyUtils.encodePassword(userS2.getPassword()));
			System.out.println("Password :: "+userS2.getPassword());
			userRepositoryS2.save(userS2);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean myLoginS2(UserS2 userS2) {

		Optional<UserS2> userFromDB = userRepositoryS2.findById(userS2.getEmail());

		UserS2 usS2 = null;

		if (userFromDB.isPresent()) {
			usS2 = userFromDB.get();
		} else {
			return false;
		}

		if (null != userFromDB && userS2.getEmail().equals(usS2.getEmail())
				&& MyUtils.encodePassword(userS2.getPassword()).equals(usS2.getPassword())) {
			userS2.setUser(usS2.getUser());
			userS2.setUserType(usS2.getUserType());
			return true;
		}

		return false;
	}

	@Override
	public List<UserS2> getAllusersS2() {
		return userRepositoryS2.findAll();
	}

	@Override
	public boolean myAdminLoginS2(UserS2 userS2) {

		Optional<UserS2> userFromDB = userRepositoryS2.findById(userS2.getEmail());

		UserS2 usS2 = null;

		if (userFromDB.isPresent()) {
			usS2 = userFromDB.get();
		} else {
			return false;
		}
		if (null != userFromDB && userS2.getEmail().equals(usS2.getEmail())
				&& MyUtils.encodePassword(userS2.getPassword()).equals(usS2.getPassword())
				&& usS2.getUserType().equals(MyConstants.ADMIN)) {
			userS2.setUser(usS2.getUser());
			userS2.setUserType(usS2.getUser());
			return true;
		}

		return false;
	}

	@Override
	public boolean updateUserStatus(String mailId, String status) {
		userRepositoryS2.updateUserStatus(mailId, status);
		return true;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public boolean addProduct(Product product) {
		System.out.println(product);
		Product productFromDB = productRepository.findByProductDetails(product.getImageUrl(), product.getProductName(),
				product.getProductDescription(), product.getQuantity(), product.getPrice());
		System.out.println("productFromDB "+ productFromDB);
		if (null!=productFromDB) {
			return false;
		} else {
			productRepository.save(product);
			return true;
		}
	}

	@Override
	public void deleteProduct(String productName) {
		productRepository.deleteById(productName);
		
	}

}
