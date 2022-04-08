package com.oneklickshop.api.response.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneklickshop.api.response.ProductPageResponse;
import com.oneklickshop.exceptions.InvalidResponseException;
import com.oneklickshop.model.ProductPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ProductPageResponseImpl implements ProductPageResponse interface.
 *
 * <p>This class wraps the ObjectMapper Jackson parser for the ProductPage Model.
 *
 * @author Jagdeep Jain
 */
public class ProductPageResponseImpl extends ProductPageResponse {
  final Logger log = LogManager.getLogger(this.getClass());

  @Override
  public ProductPage getProductPage() {
    ObjectMapper objectMapper = new ObjectMapper();
    ProductPage productPage;
    try {
      productPage = objectMapper.readValue(getResponse().asString(), ProductPage.class);
    } catch (JsonProcessingException e) {
      log.error("error occurred while reading the response array.");
      throw new InvalidResponseException("there is some problem with the response.", e);
    }
    return productPage;
  }
}
