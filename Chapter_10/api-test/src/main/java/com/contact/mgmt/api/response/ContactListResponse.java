package com.contact.mgmt.api.response;

import com.contact.mgmt.exceptions.InvalidResponseException;
import com.contact.mgmt.model.Contact;
import io.restassured.response.Response;
import java.util.List;

/**
 * ContactListResponse abstract class implements the ResponseMarker which defines the response type.
 *
 * <p>It helps in abstracting Contact Model response.
 *
 * @author Jagdeep Jain
 */
public abstract class ContactListResponse implements ResponseMarker {
  private Response response;

  public abstract List<Contact> getContacts() throws InvalidResponseException;

  public Response getResponse() {
    return response;
  }

  public ContactListResponse setResponse(Response response) {
    this.response = response;
    return this;
  }
}
