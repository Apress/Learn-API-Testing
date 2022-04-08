package com.oneklickshop.api.response.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneklickshop.api.response.UserPageResponse;
import com.oneklickshop.exceptions.InvalidResponseException;
import com.oneklickshop.model.UserPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * UserPageResponseImpl implements UserPageResponse interface.
 *
 * <p>This class wraps the ObjectMapper Jackson parser for the User Page Model.
 *
 * @author Jagdeep Jain
 */
public class UserPageResponseImpl extends UserPageResponse {
  final Logger log = LogManager.getLogger(this.getClass());

  @Override
  public UserPage getUserPage() {
    ObjectMapper objectMapper = new ObjectMapper();
    UserPage userPage;
    try {
      userPage = objectMapper.readValue(getResponse().asString(), UserPage.class);
    } catch (JsonProcessingException e) {
      log.error("error occurred while reading the response array.");
      throw new InvalidResponseException("there is some problem with the response.", e);
    }
    return userPage;
  }
}
