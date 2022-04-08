package com.oneklickshop.api.request.factory;

import com.oneklickshop.api.request.HttpRequest;

/**
 * HttpMethodFactory producing http request method object.
 *
 * <p>This class is used for getting the required http request method object.
 *
 * @author Jagdeep Jain
 */
public class HttpMethodFactory {
  public HttpRequest build(HttpMethodType type) {
    return type.createHttpRequest();
  }
}
