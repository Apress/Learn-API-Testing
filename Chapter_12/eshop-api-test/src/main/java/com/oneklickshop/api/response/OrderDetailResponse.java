package com.oneklickshop.api.response;

import com.oneklickshop.exceptions.InvalidResponseException;
import com.oneklickshop.model.OrderDetail;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * OrderDetail abstract class implements the ResponseMarker which defines the response type.
 *
 * <p>It helps in abstracting OrderDetail Model response.
 *
 * @author Jagdeep Jain
 */
public abstract class OrderDetailResponse implements ResponseMarker {
  final Logger log = LogManager.getLogger(this.getClass());
  private Response response;

  public abstract OrderDetail getOrderDetail() throws InvalidResponseException;

  public Response getResponse() {
    return this.response;
  }

  public OrderDetailResponse setResponse(Response response) {
    this.response = response;
    return this;
  }
}
