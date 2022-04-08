package com.oneklickshop.api.response.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneklickshop.api.response.UserResponse;
import com.oneklickshop.exceptions.InvalidResponseException;
import com.oneklickshop.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * UserResponseImpl implements UserResponse interface.
 *
 * <p>This class wraps the ObjectMapper Jackson parser for the User Model.
 *
 * @author Jagdeep Jain
 */
public class UserResponseImpl extends UserResponse {
  final Logger log = LogManager.getLogger(this.getClass());

  @Override
  public User getUserPage() {
    ObjectMapper objectMapper = new ObjectMapper();
    User user;
    try {
      user = objectMapper.readValue(getResponse().asString(), User.class);
    } catch (JsonProcessingException e) {
      log.error("error occurred while reading the response array.");
      throw new InvalidResponseException("there is some problem with the response.", e);
    }
    return user;
  }
}
