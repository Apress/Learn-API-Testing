package com.oneklickshop.api.response;

import com.oneklickshop.exceptions.InvalidResponseException;
import com.oneklickshop.model.User;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * UserResponse abstract class implements the ResponseMarker which defines the response type.
 *
 * <p>It helps in abstracting User Model response.
 *
 * @author Jagdeep Jain
 */
public abstract class UserResponse implements ResponseMarker {
  final Logger log = LogManager.getLogger(this.getClass());
  private Response response;

  public abstract User getUserPage() throws InvalidResponseException;

  public Response getResponse() {
    return this.response;
  }

  public UserResponse setResponse(Response response) {
    this.response = response;
    return this;
  }
}
