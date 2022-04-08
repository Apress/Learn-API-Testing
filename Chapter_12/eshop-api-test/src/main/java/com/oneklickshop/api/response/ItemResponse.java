package com.oneklickshop.api.response;

import com.oneklickshop.exceptions.InvalidResponseException;
import com.oneklickshop.model.Item;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ItemResponse abstract class implements the ResponseMarker which defines the response type.
 *
 * <p>It helps in abstracting Item Model response.
 *
 * @author Jagdeep Jain
 */
public abstract class ItemResponse implements ResponseMarker {
  final Logger log = LogManager.getLogger(this.getClass());
  private Response response;

  public abstract Item getItem() throws InvalidResponseException;

  public Response getResponse() {
    return this.response;
  }

  public ItemResponse setResponse(Response response) {
    this.response = response;
    return this;
  }
}
