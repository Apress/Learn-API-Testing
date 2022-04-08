package com.oneklickshop.model;

import java.util.ArrayList;

/**
 * Product Page Model
 *
 * @author Jagdeep Jain
 */
public class ProductPage {
  public int totalItems;
  public int totalPages;
  public int currentPage;
  public ArrayList<Product> products;

  public ProductPage() {}

  public ProductPage(int totalItems, int totalPages, int currentPage, ArrayList<Product> products) {
    this.totalItems = totalItems;
    this.totalPages = totalPages;
    this.currentPage = currentPage;
    this.products = products;
  }

  public int getTotalItems() {
    return totalItems;
  }

  public ProductPage setTotalItems(int totalItems) {
    this.totalItems = totalItems;
    return this;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public ProductPage setTotalPages(int totalPages) {
    this.totalPages = totalPages;
    return this;
  }

  public int getCurrentPage() {
    return currentPage;
  }

  public ProductPage setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
    return this;
  }

  public ArrayList<Product> getProducts() {
    return products;
  }

  public ProductPage setProducts(ArrayList<Product> products) {
    this.products = products;
    return this;
  }
}
