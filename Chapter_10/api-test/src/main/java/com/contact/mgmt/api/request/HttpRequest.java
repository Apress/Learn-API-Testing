package com.contact.mgmt.api.request;

import com.contact.mgmt.exceptions.InvalidRequestException;
import io.restassured.response.Response;
import java.io.File;
import java.util.Map;

/**
 * HttpGet is an abstract class.
 *
 * <p>This class serves the basic building blocks of the http request method. It has url,
 * authentication token, query parameter and the payload which is being used by the http GET, POST,
 * PUT, DELETE methods.
 *
 * @author Jagdeep Jain
 */
public abstract class HttpRequest {
  private String url;
  private String token;
  private Map<String, ? extends Object> query;
  private File payload;

  public abstract Response request() throws InvalidRequestException;

  public HttpRequest setUrl(String url) {
    this.url = url;
    return this;
  }

  public HttpRequest setToken(String token) {
    this.token = token;
    return this;
  }

  public HttpRequest setQuery(Map<String, ? extends Object> query) {
    this.query = query;
    return this;
  }

  public HttpRequest setPayload(File payload) {
    this.payload = payload;
    return this;
  }

  public String getUrl() {
    return url;
  }

  public String getToken() {
    return token;
  }

  public Map<String, ? extends Object> getQuery() {
    return query;
  }

  public File getPayload() {
    return payload;
  }
}
