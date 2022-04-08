package com.oneklickshop.api.request.impl;

import static io.restassured.RestAssured.given;

import com.oneklickshop.api.request.HttpRequest;
import com.oneklickshop.exceptions.InvalidRequestException;
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
      String contentType = getContentType();
      if (contentType == null) {
        contentType = "application/json";
      }
      response =
          given()
              .body(getPayload())
              .header("Authorization", "Bearer " + getToken())
              .contentType(contentType)
              .when()
              .post(getUrl());
    } catch (JSONException | IllegalArgumentException e) {
      log.error("error occurred while requesting " + getUrl());
      throw new InvalidRequestException("there is some problem with the request.", e);
    }
    return response;
  }
}
