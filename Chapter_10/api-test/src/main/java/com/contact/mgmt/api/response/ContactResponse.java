package com.contact.mgmt.api.response;

import com.contact.mgmt.exceptions.InvalidResponseException;
import com.contact.mgmt.model.Contact;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ContactResponse abstract class implements the ResponseMarker which defines the response type.
 *
 * <p>It helps in abstracting Contact Model response.
 *
 * @author Jagdeep Jain
 */
public abstract class ContactResponse implements ResponseMarker {
  final Logger log = LogManager.getLogger(this.getClass());
  private Response response;

  public abstract Contact getContact() throws InvalidResponseException;

  public Response getResponse() {
    return this.response;
  }

  public ContactResponse setResponse(Response response) {
    this.response = response;
    return this;
  }
}
