package com.oneklickshop.api.response.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneklickshop.api.response.OrderHistoryResponse;
import com.oneklickshop.exceptions.InvalidResponseException;
import com.oneklickshop.model.OrderHistory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * OrderHistoryResponseImpl implements OrderHistoryResponse interface.
 *
 * <p>This class wraps the ObjectMapper Jackson parser for the OrderHistory Model.
 *
 * @author Jagdeep Jain
 */
public class OrderHistoryResponseImpl extends OrderHistoryResponse {
  final Logger log = LogManager.getLogger(this.getClass());

  @Override
  public OrderHistory getOrderHistory() {
    ObjectMapper objectMapper = new ObjectMapper();
    OrderHistory orderHistory;
    try {
      orderHistory = objectMapper.readValue(getResponse().asString(), OrderHistory.class);
    } catch (JsonProcessingException e) {
      log.error("error occurred while reading the response array.");
      throw new InvalidResponseException("there is some problem with the response.", e);
    }
    return orderHistory;
  }
}
