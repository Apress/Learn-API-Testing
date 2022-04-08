package com.oneklickshop.model;

import java.util.Date;

/**
 * Shipping Address Model
 *
 * @author Jagdeep Jain
 */
public class ShippingAddress {
  public int id;
  public String address1;
  public String address2;
  public String city;
  public String state;
  public String zip;
  public String country;
  public Date createdAt;
  public Date updatedAt;

  public ShippingAddress() {}

  public ShippingAddress(
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

  public ShippingAddress setId(int id) {
    this.id = id;
    return this;
  }

  public String getAddress1() {
    return address1;
  }

  public ShippingAddress setAddress1(String address1) {
    this.address1 = address1;
    return this;
  }

  public String getAddress2() {
    return address2;
  }

  public ShippingAddress setAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public String getCity() {
    return city;
  }

  public ShippingAddress setCity(String city) {
    this.city = city;
    return this;
  }

  public String getState() {
    return state;
  }

  public ShippingAddress setState(String state) {
    this.state = state;
    return this;
  }

  public String getZip() {
    return zip;
  }

  public ShippingAddress setZip(String zip) {
    this.zip = zip;
    return this;
  }

  public String getCountry() {
    return country;
  }

  public ShippingAddress setCountry(String country) {
    this.country = country;
    return this;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public ShippingAddress setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public ShippingAddress setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }
}
