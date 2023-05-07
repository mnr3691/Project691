package com.wlj.utils;

import java.util.Base64;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class MyUtils {

	@Autowired
	HttpSession session;
	
	/*public static String encryptPassword(String plainPassword) {
		int strength = 10; // work factor of bcrypt
		 BCryptPasswordEncoder bCryptPasswordEncoder =
		  new BCryptPasswordEncoder(strength, new SecureRandom());
		 return bCryptPasswordEncoder.encode(plainPassword);
	}*/
	
	public static String encodePassword(String plainPassword) {
		Base64.Encoder encoder = Base64.getEncoder(); 
		return encoder.encodeToString(plainPassword.getBytes());  
	}
	
	public static String decodePassword(String encodedPassword) {
		Base64.Decoder decoder = Base64.getDecoder();  
		return new String(decoder.decode(encodedPassword));
	}
	
	public boolean isAdminLoggedIn() {
		System.out.println(session+"  session value");
		String loggedIn = (session.getAttribute("loggedIn")!=null)? session.getAttribute("loggedIn").toString() : null;
		String isAdmin = (session.getAttribute("isAdmin")!=null)? session.getAttribute("isAdmin").toString() : null;
		if(null!=loggedIn && loggedIn.equals("yes") && null!=isAdmin && isAdmin.equals("yes")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isGeneralLoggedIn() {
		String loggedIn = (session.getAttribute("loggedIn")!=null)? session.getAttribute("loggedIn").toString() : null;
		String isAdmin = (session.getAttribute("isAdmin")!=null)? session.getAttribute("isAdmin").toString() : null;
		if(null!=loggedIn && loggedIn.equals("yes") && null!=isAdmin && isAdmin.equals("no")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isAdminOrGeneralLoggedIn() {
		if(isAdminLoggedIn() || isGeneralLoggedIn()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
}
