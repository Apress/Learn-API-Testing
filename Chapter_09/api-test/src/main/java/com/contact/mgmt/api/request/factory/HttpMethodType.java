package com.contact.mgmt.api.request.factory;

import com.contact.mgmt.api.request.HttpRequest;
import com.contact.mgmt.api.request.impl.*;

/**
 * HttpMethodType is an enum containing http method types.
 *
 * <p>This class is used for creating the http method implementation object.
 *
 * @author Jagdeep Jain
 */
public enum HttpMethodType {
  GET {
    @Override
    public HttpRequest createHttpRequest() {
      return new GetRequestImpl();
    }
  },
  GET_WITH_QUERY {
    @Override
    public HttpRequest createHttpRequest() {
      return new GetRequestQueryImpl();
    }
  },
  POST {
    @Override
    public HttpRequest createHttpRequest() {
      return new PostRequestImpl();
    }
  },
  PUT {
    @Override
    public HttpRequest createHttpRequest() {
      return new PutRequestImpl();
    }
  },
  DELETE {
    @Override
    public HttpRequest createHttpRequest() {
      return new DeleteRequestImpl();
    }
  };

  public abstract HttpRequest createHttpRequest();
}
