package com.oneklickshop.api.response.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneklickshop.api.response.ProductResponse;
import com.oneklickshop.exceptions.InvalidResponseException;
import com.oneklickshop.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ProductResponseImpl implements ProductResponse interface.
 *
 * <p>This class wraps the ObjectMapper Jackson parser for the Product Model.
 *
 * @author Jagdeep Jain
 */
public class ProductResponseImpl extends ProductResponse {
  final Logger log = LogManager.getLogger(this.getClass());

  @Override
  public Product getProduct() {
    ObjectMapper objectMapper = new ObjectMapper();
    Product product;
    try {
      product = objectMapper.readValue(getResponse().asString(), Product.class);
    } catch (JsonProcessingException e) {
      log.error("error occurred while reading the response array.");
      throw new InvalidResponseException("there is some problem with the response.", e);
    }
    return product;
  }
}
