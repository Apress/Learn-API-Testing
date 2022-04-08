package com.oneklickshop.api.response.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneklickshop.api.response.PaymentInfoResponse;
import com.oneklickshop.exceptions.InvalidResponseException;
import com.oneklickshop.model.PaymentInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * PaymentInfoResponseImpl implements PaymentInfoResponse interface.
 *
 * <p>This class wraps the ObjectMapper Jackson parser for the PaymentInfo Model.
 *
 * @author Jagdeep Jain
 */
public class PaymentInfoResponseImpl extends PaymentInfoResponse {
  final Logger log = LogManager.getLogger(this.getClass());

  @Override
  public PaymentInfo getPaymentInfo() {
    ObjectMapper objectMapper = new ObjectMapper();
    PaymentInfo paymentInfo;
    try {
      paymentInfo = objectMapper.readValue(getResponse().asString(), PaymentInfo.class);
    } catch (JsonProcessingException e) {
      log.error("error occurred while reading the response array.");
      throw new InvalidResponseException("there is some problem with the response.", e);
    }
    return paymentInfo;
  }
}
