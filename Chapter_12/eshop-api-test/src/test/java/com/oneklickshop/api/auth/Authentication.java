package com.oneklickshop.api.auth;

import static io.restassured.RestAssured.given;

import com.oneklickshop.api.config.AppConfig;
import com.oneklickshop.exceptions.InvalidRequestException;
import io.restassured.response.Response;
import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;

/**
 * Authentication class has the init call which is a wrapper on RestAssured for authentication of a
 * request.
 *
 * <p>This class does the first level authentication and authorization for a user to access the
 * resource on the server and in tern provides the JWT Token for further requests.
 *
 * @author Jagdeep Jain
 */
public class Authentication {
  private final Logger log = LogManager.getLogger(this.getClass());
  private String jwtToken;
  private Response response;
  private String authPayload;

  public String getJwtToken() {
    return this.jwtToken;
  }

  public void setJwtToken(String jwtToken) {
    this.jwtToken = jwtToken;
  }

  // for testing the response of the auth/authenticate
  public Response getResponse() {
    return this.response;
  }

  public Authentication init() {
    String endPoint = AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().LOGIN();
    try {
      Response response =
          given().body(new File(authPayload)).contentType("application/json").when().post(endPoint);
      this.response = response;
      this.jwtToken = response.getBody().path("token");
      setJwtToken(this.jwtToken);
    } catch (JSONException | IllegalArgumentException e) {
      log.error("error occurred in authentication.");
      throw new InvalidRequestException(
          "there is some problem with " + "the " + "authentication.", e);
    }
    return this;
  }

  public String getAuthPayload() {
    return authPayload;
  }

  public Authentication setAuthPayload(String authPayload) {
    this.authPayload = authPayload;
    return this;
  }
}
