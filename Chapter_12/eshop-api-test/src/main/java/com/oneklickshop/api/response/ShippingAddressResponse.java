package com.oneklickshop.api.response;

import com.oneklickshop.exceptions.InvalidResponseException;
import com.oneklickshop.model.ShippingAddress;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ShippingAddressResponse abstract class implements the ResponseMarker which defines the response
 * type.
 *
 * <p>It helps in abstracting ShippingAddressResponse Model response.
 *
 * @author Jagdeep Jain
 */
public abstract class ShippingAddressResponse implements ResponseMarker {
  final Logger log = LogManager.getLogger(this.getClass());
  private Response response;

  public abstract ShippingAddress getShippingAddress() throws InvalidResponseException;

  public Response getResponse() {
    return this.response;
  }

  public ShippingAddressResponse setResponse(Response response) {
    this.response = response;
    return this;
  }
}
