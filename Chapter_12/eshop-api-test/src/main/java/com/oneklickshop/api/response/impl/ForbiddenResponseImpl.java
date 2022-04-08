package com.oneklickshop.api.response.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneklickshop.api.response.ForbiddenResponse;
import com.oneklickshop.exceptions.InvalidResponseException;
import com.oneklickshop.model.Forbidden;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ForbiddenResponseImpl implements ForbiddenResponse interface.
 *
 * <p>This class wraps the ObjectMapper Jackson parser for the Forbidden Model.
 *
 * @author Jagdeep Jain
 */
public class ForbiddenResponseImpl extends ForbiddenResponse {
  final Logger log = LogManager.getLogger(this.getClass());

  @Override
  public Forbidden getForbiddenMessage() {
    ObjectMapper objectMapper = new ObjectMapper();
    Forbidden forbidden;
    try {
      forbidden = objectMapper.readValue(getResponse().asString(), Forbidden.class);
    } catch (JsonProcessingException e) {
      log.error("error occurred while reading the response array.");
      throw new InvalidResponseException("there is some problem with the response.", e);
    }
    return forbidden;
  }
}
