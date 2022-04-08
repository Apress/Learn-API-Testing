package com.contact.mgmt.api.request.impl;

import static io.restassured.RestAssured.given;

import com.contact.mgmt.api.request.HttpRequest;
import com.contact.mgmt.exceptions.InvalidRequestException;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;

/**
 * PostRequestImpl implements the method of the HttpRequest interface.
 *
 * <p>This class wraps the RestAssured get method.
 *
 * @author Jagdeep Jain
 */
public class PostRequestImpl extends HttpRequest {
  final Logger log = LogManager.getLogger(this.getClass());

  @Override
  public Response request() {
    Response response;
    try {
      response =
          given()
              .body(getPayload())
              .header("Authorization", "Bearer " + getToken())
              .contentType("application/json")
              .when()
              .post(getUrl());
    } catch (JSONException | IllegalArgumentException e) {
      log.error("error occurred while requesting " + getUrl());
      throw new InvalidRequestException("there is some problem with the request.", e);
    }
    return response;
  }
}
