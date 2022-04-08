package com.oneklickshop.model;

import java.util.ArrayList;

/**
 * UserPage Model
 *
 * @author Jagdeep Jain
 */
public class UserPage {
  public int totalItems;
  public int totalPages;
  public int currentPage;
  public ArrayList<User> users;

  public UserPage() {}

  public UserPage(int totalItems, int totalPages, int currentPage, ArrayList<User> users) {
    this.totalItems = totalItems;
    this.totalPages = totalPages;
    this.currentPage = currentPage;
    this.users = users;
  }

  public int getTotalItems() {
    return totalItems;
  }

  public UserPage setTotalItems(int totalItems) {
    this.totalItems = totalItems;
    return this;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public UserPage setTotalPages(int totalPages) {
    this.totalPages = totalPages;
    return this;
  }

  public int getCurrentPage() {
    return currentPage;
  }

  public UserPage setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
    return this;
  }

  public ArrayList<User> getUsers() {
    return users;
  }

  public UserPage setUsers(ArrayList<User> users) {
    this.users = users;
    return this;
  }
}
