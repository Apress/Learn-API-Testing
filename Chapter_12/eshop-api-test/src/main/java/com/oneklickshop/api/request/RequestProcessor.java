package com.oneklickshop.api.request;

import com.oneklickshop.api.request.factory.HttpMethodFactory;
import com.oneklickshop.api.request.factory.HttpMethodType;
import io.restassured.response.Response;
import java.io.File;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * RequestProcessor class is used for processing the http request methods.
 *
 * <p>This class utilized the HttpMethodFactory class for http requests.
 *
 * @author Jagdeep Jain
 */
public class RequestProcessor {
  final Logger log = LogManager.getLogger(this.getClass());
  private String jwtToken;
  private Response response;
  private String contentType;

  public void setJwtToken(String jwtToken) {
    this.jwtToken = jwtToken;
  }

  public RequestProcessor setContentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

  public Response getResponse() {
    return this.response;
  }

  public void get(String endpoint) {
    HttpRequest httpGet = new HttpMethodFactory().build(HttpMethodType.GET);
    this.response = httpGet.setToken(jwtToken).setUrl(endpoint).request();
  }

  public void get(String endpoint, Map<String, ? extends Object> query) {
    HttpRequest httpGetQuery = new HttpMethodFactory().build(HttpMethodType.GET_WITH_QUERY);
    this.response = httpGetQuery.setToken(jwtToken).setUrl(endpoint).setQuery(query).request();
  }

  public void post(String endpoint, File requestPayload) {
    HttpRequest httpPut = new HttpMethodFactory().build(HttpMethodType.POST);
    this.response =
        httpPut
            .setToken(jwtToken)
            .setUrl(endpoint)
            .setPayload(requestPayload)
            .setContentType(contentType)
            .request();
  }

  public void post(String endpoint, Map<String, ? extends Object> query) {
    HttpRequest httpPut = new HttpMethodFactory().build(HttpMethodType.POST_WITH_QUERY);
    this.response = httpPut.setToken(jwtToken).setUrl(endpoint).setQuery(query).request();
  }

  public void post(String endpoint) {
    HttpRequest httpPut = new HttpMethodFactory().build(HttpMethodType.POST_SIMPLE);
    this.response = httpPut.setToken(jwtToken).setUrl(endpoint).request();
  }

  public void put(String endpoint, File requestPayload, Map<String, ? extends Object> query) {
    HttpRequest httpPut = new HttpMethodFactory().build(HttpMethodType.PUT_WITH_QUERY);
    this.response =
        httpPut
            .setToken(jwtToken)
            .setUrl(endpoint)
            .setPayload(requestPayload)
            .setQuery(query)
            .request();
  }

  public void patch(String endpoint, File requestPayload, Map<String, ? extends Object> query) {
    HttpRequest httpPut = new HttpMethodFactory().build(HttpMethodType.PATCH);
    this.response =
        httpPut
            .setToken(jwtToken)
            .setUrl(endpoint)
            .setPayload(requestPayload)
            .setQuery(query)
            .request();
  }

  public void put(String endpoint, File requestPayload) {
    HttpRequest httpPut = new HttpMethodFactory().build(HttpMethodType.PUT);
    this.response =
        httpPut.setToken(jwtToken).setUrl(endpoint).setPayload(requestPayload).request();
  }

  public void put(String endpoint) {
    HttpRequest httpPut = new HttpMethodFactory().build(HttpMethodType.PUT_SIMPLE);
    this.response = httpPut.setToken(jwtToken).setUrl(endpoint).request();
  }

  public void delete(String endpoint, Map<String, ? extends Object> query) {
    HttpRequest httpDelete = new HttpMethodFactory().build(HttpMethodType.DELETE);
    this.response = httpDelete.setToken(jwtToken).setUrl(endpoint).setQuery(query).request();
  }
}
