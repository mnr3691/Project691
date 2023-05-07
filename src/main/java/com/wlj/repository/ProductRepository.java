package com.wlj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wlj.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

	@Query("select pr from com.wlj.model.Product pr where pr.imageUrl=?1 and pr.productName=?2 and pr.productDescription=?3 "
			+ "and pr.quantity=?4 and pr.price=?5")
	public Product findByProductDetails(String imageUrl, String productName, String productDescription, int quantity,
			double price);

}
