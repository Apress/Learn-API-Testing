package com.oneklickshop.api.request.factory;

import com.oneklickshop.api.request.HttpRequest;
import com.oneklickshop.api.request.impl.*;

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
  POST_WITH_QUERY {
    @Override
    public HttpRequest createHttpRequest() {
      return new PostRequestQueryImpl();
    }
  },
  POST_SIMPLE {
    @Override
    public HttpRequest createHttpRequest() {
      return new PostRequestSimpleImpl();
    }
  },
  PUT {
    @Override
    public HttpRequest createHttpRequest() {
      return new PutRequestImpl();
    }
  },
  PUT_WITH_QUERY {
    @Override
    public HttpRequest createHttpRequest() {
      return new PutRequestQueryImpl();
    }
  },
  PUT_SIMPLE {
    @Override
    public HttpRequest createHttpRequest() {
      return new PutRequestSimpleImpl();
    }
  },
  PATCH {
    @Override
    public HttpRequest createHttpRequest() {
      return new PatchRequestQueryImpl();
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
