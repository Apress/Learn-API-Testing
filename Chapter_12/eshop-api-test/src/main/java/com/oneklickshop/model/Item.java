package com.oneklickshop.model;

import java.util.Date;

/**
 * Item Model
 *
 * @author Jagdeep Jain
 */
public class Item {
  public int id;
  public int quantity;
  public Date createdAt;
  public Date updatedAt;
  public Product product;
}
