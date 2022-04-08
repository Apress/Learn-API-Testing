package com.oneklickshop.model;

/**
 * Product Model
 *
 * @author Jagdeep Jain
 */
public class Product {
  public int id;
  public String category;
  public String name;
  public String shortDescription;
  public double cost;

  public Product() {}

  public Product(int id, String category, String name, String shortDescription, double cost) {
    this.id = id;
    this.category = category;
    this.name = name;
    this.shortDescription = shortDescription;
    this.cost = cost;
  }

  public int getId() {
    return id;
  }

  public Product setId(int id) {
    this.id = id;
    return this;
  }

  public String getCategory() {
    return category;
  }

  public Product setCategory(String category) {
    this.category = category;
    return this;
  }

  public String getName() {
    return name;
  }

  public Product setName(String name) {
    this.name = name;
    return this;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  public Product setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
    return this;
  }

  public double getCost() {
    return cost;
  }

  public Product setCost(double cost) {
    this.cost = cost;
    return this;
  }
}
