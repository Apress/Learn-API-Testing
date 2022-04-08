package com.oneklickshop.api.response.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneklickshop.api.response.OrderDetailResponse;
import com.oneklickshop.exceptions.InvalidResponseException;
import com.oneklickshop.model.OrderDetail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * OrderDetailResponseImpl implements OrderDetailResponse interface.
 *
 * <p>This class wraps the ObjectMapper Jackson parser for the OrderDetail Model.
 *
 * @author Jagdeep Jain
 */
public class OrderDetailResponseImpl extends OrderDetailResponse {
  final Logger log = LogManager.getLogger(this.getClass());

  @Override
  public OrderDetail getOrderDetail() {
    ObjectMapper objectMapper = new ObjectMapper();
    OrderDetail orderDetail;
    try {
      orderDetail = objectMapper.readValue(getResponse().asString(), OrderDetail.class);
    } catch (JsonProcessingException e) {
      log.error("error occurred while reading the response array.");
      throw new InvalidResponseException("there is some problem with the response.", e);
    }
    return orderDetail;
  }
}
