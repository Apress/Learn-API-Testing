package com.oneklickshop.api.request;

import com.oneklickshop.exceptions.InvalidRequestException;
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
  private String contentType;

  public abstract Response request() throws InvalidRequestException;

  public String getUrl() {
    return url;
  }

  public HttpRequest setUrl(String url) {
    this.url = url;
    return this;
  }

  public String getToken() {
    return token;
  }

  public HttpRequest setToken(String token) {
    this.token = token;
    return this;
  }

  public Map<String, ? extends Object> getQuery() {
    return query;
  }

  public HttpRequest setQuery(Map<String, ? extends Object> query) {
    this.query = query;
    return this;
  }

  public File getPayload() {
    return payload;
  }

  public HttpRequest setPayload(File payload) {
    this.payload = payload;
    return this;
  }

  public String getContentType() {
    return contentType;
  }

  public HttpRequest setContentType(String contentType) {
    this.contentType = contentType;
    return this;
  }
}
