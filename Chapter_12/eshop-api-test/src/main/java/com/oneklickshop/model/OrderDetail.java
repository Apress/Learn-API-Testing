package com.oneklickshop.model;

import java.util.Date;

/**
 * Order Detail Model
 *
 * @author Jagdeep Jain
 */
public class OrderDetail {
  public int id;
  public int quantity;
  public Date createdAt;
  public Date updatedAt;
  public Product product;

  public OrderDetail() {}

  public OrderDetail(int id, int quantity, Date createdAt, Date updatedAt, Product product) {
    this.id = id;
    this.quantity = quantity;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.product = product;
  }

  public int getId() {
    return id;
  }

  public OrderDetail setId(int id) {
    this.id = id;
    return this;
  }

  public int getQuantity() {
    return quantity;
  }

  public OrderDetail setQuantity(int quantity) {
    this.quantity = quantity;
    return this;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public OrderDetail setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public OrderDetail setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  public Product getProduct() {
    return product;
  }

  public OrderDetail setProduct(Product product) {
    this.product = product;
    return this;
  }
}
