package com.oneklickshop.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * User Model
 *
 * @author Jagdeep Jain
 */
public class User {
  public int id;
  public String firstname;
  public String lastname;
  public String username;
  public String email;
  public String password;
  public boolean enabled;
  public Date createdAt;
  public Date updatedAt;
  public ArrayList<Role> roles;
  public Object billingAddress;
  public Object shippingAddress;
  public Object payment;

  public User() {}

  public User(
      int id,
      String firstname,
      String lastname,
      String username,
      String email,
      String password,
      boolean enabled,
      Date createdAt,
      Date updatedAt,
      ArrayList<Role> roles,
      Object billingAddress,
      Object shippingAddress,
      Object payment) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.username = username;
    this.email = email;
    this.password = password;
    this.enabled = enabled;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.roles = roles;
    this.billingAddress = billingAddress;
    this.shippingAddress = shippingAddress;
    this.payment = payment;
  }

  public int getId() {
    return id;
  }

  public User setId(int id) {
    this.id = id;
    return this;
  }

  public String getFirstname() {
    return firstname;
  }

  public User setFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public String getLastname() {
    return lastname;
  }

  public User setLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public User setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public User setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public User setPassword(String password) {
    this.password = password;
    return this;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public User setEnabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public User setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public User setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  public ArrayList<Role> getRoles() {
    return roles;
  }

  public User setRoles(ArrayList<Role> roles) {
    this.roles = roles;
    return this;
  }

  public Object getBillingAddress() {
    return billingAddress;
  }

  public User setBillingAddress(Object billingAddress) {
    this.billingAddress = billingAddress;
    return this;
  }

  public Object getShippingAddress() {
    return shippingAddress;
  }

  public User setShippingAddress(Object shippingAddress) {
    this.shippingAddress = shippingAddress;
    return this;
  }

  public Object getPayment() {
    return payment;
  }

  public User setPayment(Object payment) {
    this.payment = payment;
    return this;
  }
}
