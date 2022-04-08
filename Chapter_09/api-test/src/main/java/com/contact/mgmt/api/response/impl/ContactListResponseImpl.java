package com.contact.mgmt.api.response.impl;

import com.contact.mgmt.api.response.ContactListResponse;
import com.contact.mgmt.exceptions.InvalidResponseException;
import com.contact.mgmt.model.Contact;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ContactListResponseImpl implements ContactListResponse interface.
 *
 * <p>This class wraps the ObjectMapper Jackson parser for the Contact Model.
 *
 * @author Jagdeep Jain
 */
public class ContactListResponseImpl extends ContactListResponse {
  final Logger log = LogManager.getLogger(this.getClass());

  @Override
  public List<Contact> getContacts() {
    ObjectMapper objectMapper = new ObjectMapper();
    List<Contact> contact;
    try {
      contact =
          objectMapper.readValue(getResponse().asString(), new TypeReference<List<Contact>>() {});
    } catch (JsonProcessingException e) {
      log.error("error occurred while reading the response array.");
      throw new InvalidResponseException("there is some problem with the response.", e);
    }
    return contact;
  }
}
