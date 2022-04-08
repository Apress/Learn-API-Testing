package com.oneklickshop.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Shopping Cart Model
 *
 * @author Jagdeep Jain
 */
public class ShoppingCart {
  public int id;
  public double total;
  public Date createdAt;
  public Date updatedAt;
  public User user;
  public ArrayList<Item> item;

  public ShoppingCart() {}

  public ShoppingCart(
      int id, double total, Date createdAt, Date updatedAt, User user, ArrayList<Item> item) {
    this.id = id;
    this.total = total;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.user = user;
    this.item = item;
  }

  public int getId() {
    return id;
  }

  public ShoppingCart setId(int id) {
    this.id = id;
    return this;
  }

  public double getTotal() {
    return total;
  }

  public ShoppingCart setTotal(double total) {
    this.total = total;
    return this;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public ShoppingCart setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public ShoppingCart setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  public User getUser() {
    return user;
  }

  public ShoppingCart setUser(User user) {
    this.user = user;
    return this;
  }

  public ArrayList<Item> getItem() {
    return item;
  }

  public ShoppingCart setItem(ArrayList<Item> item) {
    this.item = item;
    return this;
  }
}
