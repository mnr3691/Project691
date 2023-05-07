package com.wlj.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wlj.constants.MyConstants;
import com.wlj.model.Product;
import com.wlj.model.User;
import com.wlj.model.UserS2;
import com.wlj.service.UserService;
import com.wlj.utils.MyUtils;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	MyUtils myUtils;
	
	//not in use
	//@RequestMapping("/")
	public ModelAndView myLoginRegister() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("us", new User());
		mv.setViewName("loginRegister");
		return mv;
	}
	
	//not in use
	@RequestMapping("/register")
	public ModelAndView myRegister(@ModelAttribute("us") User user) {
		ModelAndView mv = new ModelAndView();
		userService.myRegister(user);
		mv.addObject("us", new User());
		mv.setViewName("registerSuccess");
		return mv;
	}
	
	//not in use
	@RequestMapping("/login")
	public ModelAndView myLogin(@ModelAttribute("us") User user) {
		ModelAndView mv = new ModelAndView();
		boolean isUserexists = userService.myLogin(user);
		if(isUserexists) {
			mv.setViewName("homePage");
		}
		else {
			mv.setViewName("loginFail");
		}
		return mv;
	}
	
	
	//not in use
	@RequestMapping("/allUsers")
	public ModelAndView getAllusers(){
		List<User> users = userService.getAllusers();
		ModelAndView mv = new ModelAndView();
		mv.addObject("userList", users);
		mv.setViewName("allUsers");
		return mv;
	}
	
	
	@RequestMapping("/")
	public ModelAndView myLoginRegisterS2() {
		ModelAndView mv = new ModelAndView();
		redirectToHomePage(mv);
		return mv;
	}
	
	@RequestMapping("/registerS2")
	public ModelAndView myRegisterS2(@ModelAttribute("us") UserS2 userS2) {
		ModelAndView mv = new ModelAndView();
		boolean isStored = userService.myRegisterS2(userS2);
		session.setAttribute("email", userS2.getEmail());
		if(!isStored) {
			mv.setViewName("userS2AlreadyExists");
			return mv;
		}
		else {
			mv.addObject("us", new User());
			mv.setViewName("registerSuccessS2Graphics");
			return mv;
		}
	}
	
	@RequestMapping("/loginS2")
	public ModelAndView myLoginS2(@ModelAttribute("us") UserS2 userS2) {
		ModelAndView mv = new ModelAndView();
		boolean isUserexists = userService.myLoginS2(userS2);
		session.setAttribute("userS2Name", userS2.getUser());
		session.setAttribute("userType", userS2.getUserType());
		session.setAttribute("userEmail", userS2.getEmail());
		if(isUserexists) {
			if(userS2.getUserType().equals(MyConstants.GENERAL) || userS2.getUserType().equals(MyConstants.ADMIN)) {
				mv.setViewName("profilePageS2");
				session.setAttribute("loggedIn", "yes");
				session.setAttribute("isAdmin", "no");
			}
			else {
				mv.setViewName("userNotActiveS2Graphics");
			}
			
		}
		else {
			mv.setViewName("loginFailS2Graphics");
		}
		return mv;
	}
	
	@RequestMapping("/adminLoginS2")
	public ModelAndView myAdminLoginS2(@ModelAttribute("us") UserS2 userS2) {
		ModelAndView mv = new ModelAndView();
		boolean isUserexists = userService.myAdminLoginS2(userS2);
		session.setAttribute("userS2Name", userS2.getUser());
		session.setAttribute("userType", userS2.getUserType());
		session.setAttribute("userEmail", userS2.getEmail());
		if(isUserexists) {
			mv.addObject("product", new Product());
			mv.setViewName("profilePageAdminS2");
			session.setAttribute("loggedIn", "yes");
			session.setAttribute("isAdmin", "yes");
		}
		else {
			mv.setViewName("loginAdminFailS2Graphics");
		}
		return mv;
	}
	
	@RequestMapping("/allUsersForAdminS2")
	public ModelAndView getAllusersS2(){
		ModelAndView mv = new ModelAndView();
		if(!myUtils.isAdminLoggedIn()) {
			redirectToHomePage(mv);
			return mv;
		}
		List<UserS2> users2s = userService.getAllusersS2();
		mv.addObject("userListS2", users2s);
		
		mv.setViewName("allUsersAdminS2");
		return mv;
	}
	
	@RequestMapping("/deactivateAccount")
	public ModelAndView deactivateAccount(@RequestParam("dEmail") String mailId){
		ModelAndView mv = new ModelAndView();
		if(!myUtils.isAdminLoggedIn()) {
			redirectToHomePage(mv);
			return mv;
		}
		boolean isStatuUpdated = userService.updateUserStatus(mailId, MyConstants.DEACTIVATE);
		List<UserS2> users2s = userService.getAllusersS2();
		mv.addObject("userListS2", users2s);
		mv.addObject("us", new UserS2());
		mv.setViewName("allUsersAdminS2");
		return mv;
	}
	
	@RequestMapping("/rejectAdmin")
	public ModelAndView rejectAdmin(@RequestParam("rEmail") String mailId){
		ModelAndView mv = new ModelAndView();
		if(!myUtils.isAdminLoggedIn()) {
			redirectToHomePage(mv);
			return mv;
		}
		boolean isStatuUpdated = userService.updateUserStatus(mailId, MyConstants.REJECT);
		List<UserS2> users2s = userService.getAllusersS2();
		mv.addObject("userListS2", users2s);
		mv.setViewName("allUsersAdminS2");
		return mv;
	}
	
	@RequestMapping("/approveAdmin")
	public ModelAndView approveUserAdmin(@RequestParam("aEmail") String mailId){
		ModelAndView mv = new ModelAndView();
		if(!myUtils.isAdminLoggedIn()) {
			redirectToHomePage(mv);
			return mv;
		}
		boolean isStatuUpdated = userService.updateUserStatus(mailId, MyConstants.ADMIN);
		List<UserS2> users2s = userService.getAllusersS2();
		mv.addObject("userListS2", users2s);
		mv.setViewName("allUsersAdminS2");
		return mv;
	}

	private void redirectToHomePage(ModelAndView mv) {
		mv.addObject("us", new UserS2());
		mv.setViewName("loginRegisterS2");
	}
	
	@RequestMapping("/activateAdminAccount")
	public ModelAndView activateAdminAccount(@RequestParam("aEmail") String mailId){
		ModelAndView mv = new ModelAndView();
		if(!myUtils.isAdminLoggedIn()) {
			redirectToHomePage(mv);
			return mv;
		}
		boolean isStatuUpdated = userService.updateUserStatus(mailId, MyConstants.ADMIN);
		List<UserS2> users2s = userService.getAllusersS2();
		mv.addObject("userListS2", users2s);
		mv.setViewName("allUsersAdminS2");
		return mv;
	}
	
	@RequestMapping("/activateGeneralAccount")
	public ModelAndView activateGeneralAccount(@RequestParam("aEmail") String mailId){
		ModelAndView mv = new ModelAndView();
		if(!myUtils.isAdminLoggedIn()) {
			redirectToHomePage(mv);
			return mv;
		}
		boolean isStatuUpdated = userService.updateUserStatus(mailId, MyConstants.GENERAL);
		List<UserS2> users2s = userService.getAllusersS2();
		mv.addObject("userListS2", users2s);
		mv.setViewName("allUsersAdminS2");
		return mv;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(){
		ModelAndView mv = new ModelAndView();
		session.removeAttribute("loggedIn");
		session.removeAttribute("isAdmin");
		session.invalidate();
		redirectToHomePage(mv);
		return mv;
	}
	
	@RequestMapping("/manageProducts")
	public ModelAndView manageProducts(){
		ModelAndView mv = new ModelAndView();
		if(!myUtils.isAdminLoggedIn()) {
			redirectToHomePage(mv);
			return mv;
		}
		List<Product> productsList = userService.getAllProducts();
		mv.addObject("products", productsList);
		mv.setViewName("allProductsAdmin");
		return mv;
	}
	
	@RequestMapping("/addProductForm")
	public ModelAndView addProductForm() {
		ModelAndView mv = new ModelAndView();
		if(!myUtils.isAdminLoggedIn()) {
			redirectToHomePage(mv);
			return mv;
		}
		mv.addObject("pro", new Product());
		mv.setViewName("addProductForm");
		return mv;
	}
	
	
	@RequestMapping("/addProduct")
	public ModelAndView addProduct(@ModelAttribute("pro") Product product) {
		ModelAndView mv = new ModelAndView();
		if(!myUtils.isAdminLoggedIn()) {
			redirectToHomePage(mv);
			return mv;
		}
		boolean isStored = userService.addProduct(product);
		if(!isStored) {
			mv.setViewName("productAlreadyExists");
			return mv;
		}
		else {
			List<Product> productsList = userService.getAllProducts();
			for(Product pr : productsList) {
				System.out.println("test  :: "+pr);
			}
			mv.addObject("products", productsList);
			mv.setViewName("allProductsAdmin");
			return mv;
		}
	}
	
	@RequestMapping("/redirectToProfilePageAdmin")
	public ModelAndView redirectToProfilePageAdmin() {
		ModelAndView mv = new ModelAndView();
		if(!myUtils.isAdminLoggedIn()) {
			redirectToHomePage(mv);
			return mv;
		}
		else {
			mv.addObject("product", new Product());
			mv.setViewName("profilePageAdminS2");
			return mv;
		}
	}
	
	@RequestMapping("/deleteProduct")
	public ModelAndView deleteProduct(@RequestParam("productName") String productName) {
		ModelAndView mv = new ModelAndView();
		if(!myUtils.isAdminLoggedIn()) {
			redirectToHomePage(mv);
			return mv;
		}
		else {
			userService.deleteProduct(productName);
			List<Product> productsList = userService.getAllProducts();
			mv.addObject("products", productsList);
			mv.setViewName("allProductsAdmin");
			return mv;
		}
	}
	
	
	
	
	

}
