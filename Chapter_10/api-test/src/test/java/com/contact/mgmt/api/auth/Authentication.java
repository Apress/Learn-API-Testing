package com.contact.mgmt.api.auth;

import static io.restassured.RestAssured.given;

import com.contact.mgmt.api.config.ApplicationContext;
import com.contact.mgmt.api.config.ContactManagementConfig;
import com.contact.mgmt.api.config.TestConfig;
import com.contact.mgmt.exceptions.InvalidRequestException;
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
  private static final ApplicationContext applicationContext = new ApplicationContext();

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
    String endPoint = getTestConfig().getUrl() + getContactManagement().authentication();
    try {
      String requestPayload = "src/test/resources/authentication/adminPayload.json";
      Response response =
          given()
              .body(new File(requestPayload))
              .contentType("application/json")
              .when()
              .post(endPoint);
      this.response = response;
      this.jwtToken = response.getHeader("Authorization");
      setJwtToken(this.jwtToken);
    } catch (JSONException | IllegalArgumentException e) {
      log.error("error occurred in authentication.");
      throw new InvalidRequestException(
          "there is some problem with " + "the " + "authentication.", e);
    }
    return this;
  }

  private TestConfig getTestConfig() {
    return applicationContext.getTestConfig();
  }

  private ContactManagementConfig getContactManagement() {
    return applicationContext.getContactManagementConfig();
  }
}
