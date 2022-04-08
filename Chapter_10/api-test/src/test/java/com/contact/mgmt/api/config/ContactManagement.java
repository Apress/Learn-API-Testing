package com.contact.mgmt.api.config;

/**
 * Contact Management Endpoints
 *
 * @author Jagdeep Jain
 */
public enum ContactManagement {
  ADD_CONTACT {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getContactManagementConfig().addContact();
    }
  },
  UPDATE_CONTACT {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getContactManagementConfig().updateContact();
    }
  },
  FIND_CONTACT {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getContactManagementConfig().findContact();
    }
  },
  GET_ACTIVE_CONTACTS {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getContactManagementConfig().getActiveContacts();
    }
  },
  DELETE_CONTACT {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getContactManagementConfig().deleteContact();
    }
  };

  public abstract String url();
}
