package com.oneklickshop.api.response;

import com.oneklickshop.exceptions.InvalidResponseException;
import com.oneklickshop.model.OrderHistory;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * OrderHistory abstract class implements the ResponseMarker which defines the response type.
 *
 * <p>It helps in abstracting OrderHistory Model response.
 *
 * @author Jagdeep Jain
 */
public abstract class OrderHistoryResponse implements ResponseMarker {
  final Logger log = LogManager.getLogger(this.getClass());
  private Response response;

  public abstract OrderHistory getOrderHistory() throws InvalidResponseException;

  public Response getResponse() {
    return this.response;
  }

  public OrderHistoryResponse setResponse(Response response) {
    this.response = response;
    return this;
  }
}
