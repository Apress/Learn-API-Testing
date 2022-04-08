package com.contact.mgmt.api.response;

import com.contact.mgmt.api.response.factory.ResponseAbstractFactory;
import com.contact.mgmt.api.response.factory.ResponseFactoryCreator;
import com.contact.mgmt.model.Contact;
import io.restassured.response.Response;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ResponseProcessor class is used for processing the http response.
 *
 * <p>This class is used for processing the response types with ResponseFactoryCreator.
 *
 * @author Jagdeep Jain
 */
public class ResponseProcessor {
  final Logger log = LogManager.getLogger(this.getClass());
  ResponseAbstractFactory responseFactory = ResponseFactoryCreator.getFactory();
  private Response response;

  public void setResponse(Response response) {
    this.response = response;
  }

  public Response getResponse() {
    return response;
  }

  public Contact getResponseContact() {
    return responseFactory.getContactResponse().setResponse(this.response).getContact();
  }

  public List<Contact> getResponseContacts() {
    return responseFactory.getContactListResponse().setResponse(this.response).getContacts();
  }
}
