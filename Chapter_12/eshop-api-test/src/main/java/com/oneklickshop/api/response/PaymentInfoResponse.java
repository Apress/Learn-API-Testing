package com.oneklickshop.api.response;

import com.oneklickshop.exceptions.InvalidResponseException;
import com.oneklickshop.model.PaymentInfo;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * PaymentInfoResponse abstract class implements the ResponseMarker which defines the response type.
 *
 * <p>It helps in abstracting PaymentInfoResponse Model response.
 *
 * @author Jagdeep Jain
 */
public abstract class PaymentInfoResponse implements ResponseMarker {
  final Logger log = LogManager.getLogger(this.getClass());
  private Response response;

  public abstract PaymentInfo getPaymentInfo() throws InvalidResponseException;

  public Response getResponse() {
    return this.response;
  }

  public PaymentInfoResponse setResponse(Response response) {
    this.response = response;
    return this;
  }
}
