package com.oneklickshop.api.response;

import com.oneklickshop.exceptions.InvalidResponseException;
import com.oneklickshop.model.JwtPayload;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * BillingAddressResponse abstract class implements the ResponseMarker which defines the response
 * type.
 *
 * <p>It helps in abstracting BillingAddressResponse Model response.
 *
 * @author Jagdeep Jain
 */
public abstract class AuthResponse implements ResponseMarker {
  final Logger log = LogManager.getLogger(this.getClass());
  private Response response;

  public abstract JwtPayload getJwtPayload() throws InvalidResponseException;

  public Response getResponse() {
    return this.response;
  }

  public AuthResponse setResponse(Response response) {
    this.response = response;
    return this;
  }
}
