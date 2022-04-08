package com.contact.mgmt.api.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * ContactManagementConfig a spring configuration class having API endpoint handles.
 *
 * <p>This class will provide the endpoints of the Contact Management APIs to the test classes.
 *
 * @author Jagdeep Jain
 */
@Configuration
@PropertySource("classpath:properties/REST-endpoints.properties")
public class ContactManagementConfig {
  protected final Logger log = LogManager.getLogger(this.getClass());

  @Value("${login}")
  private String LOGIN;

  @Value("${current.user}")
  private String GET_CURRENT_USER;

  @Value("${contact.add}")
  private String ADD_CONTACT;

  @Value("${contact.find}")
  private String FIND_CONTACT;

  @Value("${contact.list}")
  private String GET_ALL_CONTACT;

  @Value("${contact.update}")
  private String UPDATE_CONTACT;

  @Value("${contact.delete}")
  private String DELETE_CONTACT;

  public String authentication() {
    return LOGIN.split(",")[1];
  }

  public String getCurrentUser() {
    return GET_CURRENT_USER.split(",")[1];
  }

  public String addContact() {
    return ADD_CONTACT.split(",")[1];
  }

  public String getActiveContacts() {
    return GET_ALL_CONTACT.split(",")[1];
  }

  public String findContact() {
    return FIND_CONTACT.split(",")[1];
  }

  public String updateContact() {
    return UPDATE_CONTACT.split(",")[1];
  }

  public String deleteContact() {
    return DELETE_CONTACT.split(",")[1];
  }
}
