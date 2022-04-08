package com.oneklickshop.api.response;

import com.oneklickshop.exceptions.InvalidResponseException;
import com.oneklickshop.model.ShoppingCart;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ShoppingCartResponse abstract class implements the ResponseMarker which defines the response
 * type.
 *
 * <p>It helps in abstracting ShoppingCartResponse Model response.
 *
 * @author Jagdeep Jain
 */
public abstract class ShoppingCartResponse implements ResponseMarker {
  final Logger log = LogManager.getLogger(this.getClass());
  private Response response;

  public abstract ShoppingCart getShoppingCart() throws InvalidResponseException;

  public Response getResponse() {
    return this.response;
  }

  public ShoppingCartResponse setResponse(Response response) {
    this.response = response;
    return this;
  }
}
