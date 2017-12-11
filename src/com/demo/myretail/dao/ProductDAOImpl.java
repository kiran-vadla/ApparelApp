package com.demo.myretail.dao;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

import com.demo.myretail.vo.Product;

/**
 * @author vkiran
 *
 */
public class ProductDAOImpl extends BasicDAO<Product, String> implements ProductDAO {

  public ProductDAOImpl(Datastore ds) {
    super(ds);
  }

  public Product findByProductId(long productId) {

    return createQuery().field("productId").equal(productId).get();
  }

  public List<Product> findByProductIds(List<Long> productIds) {

    return createQuery().field("productId").in(productIds).asList();
  }
}