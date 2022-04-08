package com.contact.mgmt.api.response.factory;

import com.contact.mgmt.api.response.ContactListResponse;
import com.contact.mgmt.api.response.ContactResponse;

/**
 * ResponseAbstractFactory implements the Abstract Factory Pattern.
 *
 * <p>This interface help in providing the different response types.
 *
 * @author Jagdeep Jain
 */
public interface ResponseAbstractFactory {
  ContactResponse getContactResponse();

  ContactListResponse getContactListResponse();
}
