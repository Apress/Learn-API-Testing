package com.contact.mgmt.api.response.factory;

import com.contact.mgmt.api.response.ContactListResponse;
import com.contact.mgmt.api.response.ContactResponse;
import com.contact.mgmt.api.response.impl.ContactListResponseImpl;
import com.contact.mgmt.api.response.impl.ContactResponseImpl;

/**
 * ResponseFactory implements ResponseAbstractFactory.
 *
 * <p>This class help in providing the different response type objects.
 *
 * @author Jagdeep Jain
 */
public class ResponseFactory implements ResponseAbstractFactory {
  @Override
  public ContactResponse getContactResponse() {
    return new ContactResponseImpl();
  }

  @Override
  public ContactListResponse getContactListResponse() {
    return new ContactListResponseImpl();
  }
}
