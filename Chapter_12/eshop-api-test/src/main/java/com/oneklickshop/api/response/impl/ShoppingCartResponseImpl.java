package com.oneklickshop.api.response.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneklickshop.api.response.ShoppingCartResponse;
import com.oneklickshop.exceptions.InvalidResponseException;
import com.oneklickshop.model.ShoppingCart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ShoppingCartResponseImpl implements ShoppingCartResponse interface.
 *
 * <p>This class wraps the ObjectMapper Jackson parser for the ShoppingCart Model.
 *
 * @author Jagdeep Jain
 */
public class ShoppingCartResponseImpl extends ShoppingCartResponse {
  final Logger log = LogManager.getLogger(this.getClass());

  @Override
  public ShoppingCart getShoppingCart() {
    ObjectMapper objectMapper = new ObjectMapper();
    ShoppingCart shoppingCart;
    try {
      shoppingCart = objectMapper.readValue(getResponse().asString(), ShoppingCart.class);
    } catch (JsonProcessingException e) {
      log.error("error occurred while reading the response array.");
      throw new InvalidResponseException("there is some problem with the response.", e);
    }
    return shoppingCart;
  }
}
