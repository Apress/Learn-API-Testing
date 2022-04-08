package com.oneklickshop.api;

import com.oneklickshop.api.auth.Authentication;
import com.oneklickshop.api.request.RequestProcessor;
import com.oneklickshop.api.response.ResponseProcessor;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BaseTest class has the application context, request and response process as well as does the
 * authorization for a request.
 *
 * <p>BaseTest class is the cockpit of all the test scripts, it is extended by all the test classes
 * for performing actual request on the API endpoint and processing the response. Since we want the
 * test script should be minimal lines of code this class make sure that the test script has only
 * required code with respect to the use case.
 *
 * @author Jagdeep Jain
 */
public class BaseTest {
  final Logger log = LoggerFactory.getLogger(BaseTest.class);
  private String jwtToken;
  private String contentType;
  private Response response;
  private RequestProcessor requestProcessor;
  private final String user = "src/test/resources/authentication/user.json";
  private final String inactiveUser =
      "src/test/resources/authentication" + "/inactiveUser" + ".json";
  private final String admin = "src/test/resources/authentication" + "/admin" + ".json";
  private final String inactiveAdmin = "src/test/resources/authentication" + "/inactiveAdmin.json";

  // get the token in the test script to validation the auth payload
  protected String getJwtToken() {
    return jwtToken;
  }

  // set JWT token from the test script for testing invalid token
  protected void setJwtToken(String jwtToken) {
    this.jwtToken = jwtToken;
  }

  // get the contentType in the test script for validation
  public String getContentType() {
    return contentType;
  }

  // set contentTyp from the test script for testing invalid contentType
  public BaseTest setContentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

  protected Response getResponse() {
    return this.response;
  }

  /* set response from the test script
   * for testing invalid response
   */
  protected void setResponse(Response response) {
    this.response = response;
  }

  protected void admin() {
    Authentication authentication = new Authentication();
    authentication.setAuthPayload(admin);
    this.jwtToken = authentication.init().getJwtToken();
    this.response = authentication.getResponse();
  }

  protected void inactiveAdmin() {
    Authentication authentication = new Authentication();
    authentication.setAuthPayload(inactiveAdmin);
    this.jwtToken = authentication.init().getJwtToken();
    this.response = authentication.getResponse();
  }

  protected void user() {
    Authentication authentication = new Authentication();
    authentication.setAuthPayload(user);
    this.jwtToken = authentication.init().getJwtToken();
    this.response = authentication.getResponse();
  }

  protected void inactiveUser() {
    Authentication authentication = new Authentication();
    authentication.setAuthPayload(inactiveUser);
    this.jwtToken = authentication.init().getJwtToken();
    this.response = authentication.getResponse();
  }

  protected RequestProcessor request() {
    requestProcessor = new RequestProcessor();
    requestProcessor.setJwtToken(this.jwtToken);
    requestProcessor.setContentType(this.contentType);
    return requestProcessor;
  }

  protected ResponseProcessor response() {
    ResponseProcessor responseProcessor = new ResponseProcessor();
    this.response = requestProcessor.getResponse();
    responseProcessor.setResponse(this.response);
    return responseProcessor;
  }
}
