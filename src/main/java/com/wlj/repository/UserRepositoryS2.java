package com.wlj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wlj.model.UserS2;


@Repository
public interface UserRepositoryS2 extends JpaRepository<UserS2, String>{

	@Query("select s2.email from com.wlj.model.UserS2 s2 where s2.email=?1")
	public String getUserS2Email(String email);
	
	@Modifying
	@Query("update com.wlj.model.UserS2 s2 set s2.userType =?2 where s2.email=?1")
	public void updateUserStatus(String email, String status);
	
	
	
}
