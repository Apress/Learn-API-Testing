package com.oneklickshop.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * File Details
 *
 * @author Jagdeep Jain
 */
public class OrderHistory {
  public int id;
  public double total;
  public Date createdAt;
  public Date updatedAt;
  public User user;
  public ArrayList<OrderDetail> orderDetails;

  public OrderHistory() {}

  public OrderHistory(
      int id,
      double total,
      Date createdAt,
      Date updatedAt,
      User user,
      ArrayList<OrderDetail> orderDetails) {
    this.id = id;
    this.total = total;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.user = user;
    this.orderDetails = orderDetails;
  }

  public int getId() {
    return id;
  }

  public OrderHistory setId(int id) {
    this.id = id;
    return this;
  }

  public double getTotal() {
    return total;
  }

  public OrderHistory setTotal(double total) {
    this.total = total;
    return this;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public OrderHistory setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public OrderHistory setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  public User getUser() {
    return user;
  }

  public OrderHistory setUser(User user) {
    this.user = user;
    return this;
  }

  public ArrayList<OrderDetail> getOrderDetails() {
    return orderDetails;
  }

  public OrderHistory setOrderDetails(ArrayList<OrderDetail> orderDetails) {
    this.orderDetails = orderDetails;
    return this;
  }
}
