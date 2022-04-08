package com.oneklickshop.api.response;

import com.oneklickshop.exceptions.InvalidResponseException;
import com.oneklickshop.model.Product;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ProductResponse abstract class implements the ResponseMarker which defines the response type.
 *
 * <p>It helps in abstracting ProductResponse Model response.
 *
 * @author Jagdeep Jain
 */
public abstract class ProductResponse implements ResponseMarker {
  final Logger log = LogManager.getLogger(this.getClass());
  private Response response;

  public abstract Product getProduct() throws InvalidResponseException;

  public Response getResponse() {
    return this.response;
  }

  public ProductResponse setResponse(Response response) {
    this.response = response;
    return this;
  }
}
