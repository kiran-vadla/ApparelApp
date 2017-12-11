package com.demo.myretail.dao;

import java.util.List;

import com.demo.myretail.vo.Product;

/**
 * @author vkiran
 *
 */
public interface ProductDAO {
  public Product findByProductId(long productId);

  public List<Product> findByProductIds(List<Long> productIds);
}