package com.demo.myretail.vo;

import org.mongodb.morphia.annotations.Entity;

import com.demo.myretail.entity.BaseEntity;

/**
 * @author vkiran
 *
 */
@Entity
public class Product extends BaseEntity {
  private long productId;

  /**
   * @return productId
   */
  public long getProductId() {

    return this.productId;
  }

  /**
   * @param productId new value of {@link #getproductId}.
   */
  public void setProductId(long productId) {

    this.productId = productId;
  }

  /**
   * @return brand
   */
  public String getBrand() {

    return this.brand;
  }

  /**
   * @param brand new value of {@link #getbrand}.
   */
  public void setBrand(String brand) {

    this.brand = brand;
  }

  /**
   * @return category
   */
  public String getCategory() {

    return this.category;
  }

  /**
   * @param category new value of {@link #getcategory}.
   */
  public void setCategory(String category) {

    this.category = category;
  }

  /**
   * @return price
   */
  public long getPrice() {

    return this.price;
  }

  /**
   * @param price new value of {@link #getprice}.
   */
  public void setPrice(long price) {

    this.price = price;
  }

  /**
   * @return brandDiscountPc
   */
  public long getBrandDiscountPc() {

    return this.brandDiscountPc;
  }

  /**
   * @param brandDiscountPc new value of {@link #getbrandDiscountPc}.
   */
  public void setBrandDiscountPc(long brandDiscountPc) {

    this.brandDiscountPc = brandDiscountPc;
  }

  /**
   * @return categoryDiscountPc
   */
  public long getCategoryDiscountPc() {

    return this.categoryDiscountPc;
  }

  /**
   * @param categoryDiscountPc new value of {@link #getcategoryDiscountPc}.
   */
  public void setCategoryDiscountPc(long categoryDiscountPc) {

    this.categoryDiscountPc = categoryDiscountPc;
  }

  /**
   * @return ancesCatDiscountPc
   */
  public long getAncesCatDiscountPc() {

    return this.ancesCatDiscountPc;
  }

  /**
   * @param ancesCatDiscountPc new value of {@link #getancesCatDiscountPc}.
   */
  public void setAncesCatDiscountPc(long ancesCatDiscountPc) {

    this.ancesCatDiscountPc = ancesCatDiscountPc;
  }

  private String brand;

  private String category;

  private long price;

  private long brandDiscountPc;

  private long categoryDiscountPc;

  private long ancesCatDiscountPc;
}