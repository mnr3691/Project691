package com.wlj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wlj.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("select max(userId) from com.wlj.model.User")
	public int getMaxUserId();
	
	
	
	
}
