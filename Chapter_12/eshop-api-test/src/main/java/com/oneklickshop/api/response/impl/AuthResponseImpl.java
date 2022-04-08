package com.oneklickshop.api.response.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneklickshop.api.response.AuthResponse;
import com.oneklickshop.exceptions.InvalidResponseException;
import com.oneklickshop.model.JwtPayload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * BillingAddressResponseImpl implements BillingAddressResponse interface.
 *
 * <p>This class wraps the ObjectMapper Jackson parser for the BillingAddress Model.
 *
 * @author Jagdeep Jain
 */
public class AuthResponseImpl extends AuthResponse {
  final Logger log = LogManager.getLogger(this.getClass());

  @Override
  public JwtPayload getJwtPayload() {
    ObjectMapper objectMapper = new ObjectMapper();
    JwtPayload jwtPayload;
    try {
      jwtPayload = objectMapper.readValue(getResponse().asString(), JwtPayload.class);
    } catch (JsonProcessingException e) {
      log.error("error occurred while reading the response array.");
      throw new InvalidResponseException("there is some problem with the response.", e);
    }
    return jwtPayload;
  }
}
