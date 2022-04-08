package com.oneklickshop.model;

import java.util.Date;

/**
 * Billing Address Model
 *
 * @author Jagdeep Jain
 */
public class BillingAddress {
  public int id;
  public String address1;
  public String address2;
  public String city;
  public String state;
  public String zip;
  public String country;
  public Date createdAt;
  public Date updatedAt;

  public BillingAddress() {}

  public BillingAddress(
      int id,
      String address1,
      String address2,
      String city,
      String state,
      String zip,
      String country,
      Date createdAt,
      Date updatedAt) {
    this.id = id;
    this.address1 = address1;
    this.address2 = address2;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.country = country;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public int getId() {
    return id;
  }

  public BillingAddress setId(int id) {
    this.id = id;
    return this;
  }

  public String getAddress1() {
    return address1;
  }

  public BillingAddress setAddress1(String address1) {
    this.address1 = address1;
    return this;
  }

  public String getAddress2() {
    return address2;
  }

  public BillingAddress setAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public String getCity() {
    return city;
  }

  public BillingAddress setCity(String city) {
    this.city = city;
    return this;
  }

  public String getState() {
    return state;
  }

  public BillingAddress setState(String state) {
    this.state = state;
    return this;
  }

  public String getZip() {
    return zip;
  }

  public BillingAddress setZip(String zip) {
    this.zip = zip;
    return this;
  }

  public String getCountry() {
    return country;
  }

  public BillingAddress setCountry(String country) {
    this.country = country;
    return this;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public BillingAddress setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public BillingAddress setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }
}
