package com.oneklickshop.model;

import java.util.ArrayList;

/**
 * JWT Payload
 *
 * @author Jagdeep Jain
 */
public class JwtPayload {
  public int exp;
  public int userId;
  public int iat;
  public String email;
  public ArrayList<Authority> authorities;
  public String username;

  public JwtPayload() {}

  public JwtPayload(
      int exp,
      int userId,
      int iat,
      String email,
      ArrayList<Authority> authorities,
      String username) {
    this.exp = exp;
    this.userId = userId;
    this.iat = iat;
    this.email = email;
    this.authorities = authorities;
    this.username = username;
  }

  public int getExp() {
    return exp;
  }

  public JwtPayload setExp(int exp) {
    this.exp = exp;
    return this;
  }

  public int getUserId() {
    return userId;
  }

  public JwtPayload setUserId(int userId) {
    this.userId = userId;
    return this;
  }

  public int getIat() {
    return iat;
  }

  public JwtPayload setIat(int iat) {
    this.iat = iat;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public JwtPayload setEmail(String email) {
    this.email = email;
    return this;
  }

  public ArrayList<Authority> getAuthorities() {
    return authorities;
  }

  public JwtPayload setAuthorities(ArrayList<Authority> authorities) {
    this.authorities = authorities;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public JwtPayload setUsername(String username) {
    this.username = username;
    return this;
  }
}
