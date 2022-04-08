package com.oneklickshop.api.response;

import com.oneklickshop.exceptions.InvalidResponseException;
import com.oneklickshop.model.ProductPage;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ProductPageResponse abstract class implements the ResponseMarker which defines the response type.
 *
 * <p>It helps in abstracting ProductPageResponse Model response.
 *
 * @author Jagdeep Jain
 */
public abstract class ProductPageResponse implements ResponseMarker {
  final Logger log = LogManager.getLogger(this.getClass());
  private Response response;

  public abstract ProductPage getProductPage() throws InvalidResponseException;

  public Response getResponse() {
    return this.response;
  }

  public ProductPageResponse setResponse(Response response) {
    this.response = response;
    return this;
  }
}
