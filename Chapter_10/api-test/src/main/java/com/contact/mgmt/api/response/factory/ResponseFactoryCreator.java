package com.contact.mgmt.api.response.factory;

/**
 * ResponseFactoryCreator does the object creation.
 *
 * <p>This class helps in getting the ResponseFactory implementation.
 *
 * @author Jagdeep Jain
 */
public class ResponseFactoryCreator {
  private ResponseFactoryCreator() {}

  public static ResponseAbstractFactory getFactory() {
    return new ResponseFactory();
  }
}
