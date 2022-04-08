package com.oneklickshop.model;

import java.util.Date;

/**
 * Payment Info Model
 *
 * @author Jagdeep Jain
 */
public class PaymentInfo {
  public int id;
  public String cardExpiry;
  public String cardNumber;
  public Date createdAt;
  public String nameOnCard;
  public Date updatedAt;

  public PaymentInfo() {}

  public PaymentInfo(
      int id,
      String cardExpiry,
      String cardNumber,
      Date createdAt,
      String nameOnCard,
      Date updatedAt) {
    this.id = id;
    this.cardExpiry = cardExpiry;
    this.cardNumber = cardNumber;
    this.createdAt = createdAt;
    this.nameOnCard = nameOnCard;
    this.updatedAt = updatedAt;
  }

  public int getId() {
    return id;
  }

  public PaymentInfo setId(int id) {
    this.id = id;
    return this;
  }

  public String getCardExpiry() {
    return cardExpiry;
  }

  public PaymentInfo setCardExpiry(String cardExpiry) {
    this.cardExpiry = cardExpiry;
    return this;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public PaymentInfo setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
    return this;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public PaymentInfo setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public String getNameOnCard() {
    return nameOnCard;
  }

  public PaymentInfo setNameOnCard(String nameOnCard) {
    this.nameOnCard = nameOnCard;
    return this;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public PaymentInfo setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }
}
