package com.oneklickshop.api.response.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneklickshop.api.response.ShippingAddressResponse;
import com.oneklickshop.exceptions.InvalidResponseException;
import com.oneklickshop.model.ShippingAddress;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ShippingAddressResponseImpl implements ShippingAddressResponse interface.
 *
 * <p>This class wraps the ObjectMapper Jackson parser for the ShippingAddress Model.
 *
 * @author Jagdeep Jain
 */
public class ShippingAddressResponseImpl extends ShippingAddressResponse {
  final Logger log = LogManager.getLogger(this.getClass());

  @Override
  public ShippingAddress getShippingAddress() {
    ObjectMapper objectMapper = new ObjectMapper();
    ShippingAddress shippingAddress;
    try {
      shippingAddress = objectMapper.readValue(getResponse().asString(), ShippingAddress.class);
    } catch (JsonProcessingException e) {
      log.error("error occurred while reading the response array.");
      throw new InvalidResponseException("there is some problem with the response.", e);
    }
    return shippingAddress;
  }
}
