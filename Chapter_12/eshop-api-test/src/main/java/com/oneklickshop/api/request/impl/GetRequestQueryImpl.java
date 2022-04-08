package com.oneklickshop.api.request.impl;

import static io.restassured.RestAssured.given;

import com.oneklickshop.api.request.HttpRequest;
import com.oneklickshop.exceptions.InvalidRequestException;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;

/**
 * GetRequestQueryImpl implements the method of the HttpRequest interface.
 *
 * <p>This class wraps the RestAssured get method.
 *
 * @author Jagdeep Jain
 */
public class GetRequestQueryImpl extends HttpRequest {
  final Logger log = LogManager.getLogger(this.getClass());

  @Override
  public Response request() {
    Response response;
    try {
      response =
          given()
              .header("Authorization", "Bearer " + getToken())
              .contentType("application/json")
              .when()
              .get(getUrl(), getQuery());
    } catch (JSONException | IllegalArgumentException e) {
      log.error("error occurred while requesting " + getUrl());
      throw new InvalidRequestException("there is some problem with the request.", e);
    }
    return response;
  }
}
