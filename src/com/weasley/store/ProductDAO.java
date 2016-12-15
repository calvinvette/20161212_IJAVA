package com.weasley.store;

import java.util.List;

public interface ProductDAO {
	public Product insert(Product c);
	public Product delete(Product c);
	public Product update(Product c);
	public List<Product> findAll();
	public Product findById(Long ProductId);
	// Custom finders for Product
	public List<Product> findByProductName(String productName);
	public List<Product> findByCategory(String category);
}
