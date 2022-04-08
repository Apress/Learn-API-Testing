package com.oneklickshop.api.response;

import com.oneklickshop.exceptions.InvalidResponseException;
import com.oneklickshop.model.UserPage;
import io.restassured.response.Response;

/**
 * UserPageResponse abstract class implements the ResponseMarker which defines the response type.
 *
 * <p>It helps in abstracting User Model response.
 *
 * @author Jagdeep Jain
 */
public abstract class UserPageResponse implements ResponseMarker {
  private Response response;

  public abstract UserPage getUserPage() throws InvalidResponseException;

  public Response getResponse() {
    return response;
  }

  public UserPageResponse setResponse(Response response) {
    this.response = response;
    return this;
  }
}
