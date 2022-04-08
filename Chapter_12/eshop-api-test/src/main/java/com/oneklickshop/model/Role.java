package com.oneklickshop.model;

/**
 * Role Model
 *
 * @author Jagdeep Jain
 */
public class Role {
  public String authority;

  public Role() {}

  public Role(String authority) {
    this.authority = authority;
  }

  public String getAuthority() {
    return authority;
  }

  public Role setAuthority(String authority) {
    this.authority = authority;
    return this;
  }
}
