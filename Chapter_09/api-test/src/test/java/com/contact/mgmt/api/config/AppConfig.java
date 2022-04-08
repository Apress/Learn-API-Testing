package com.contact.mgmt.api.config;

/**
 * Application Config
 *
 * @author Jagdeep Jain
 */
public class AppConfig {
  private static ApplicationContext applicationContext = new ApplicationContext();

  public static String getUrl() {
    return applicationContext.getUrl();
  }

  public static ContactManagementConfig getContactManagementConfig() {
    return applicationContext.getContactManagementConfig();
  }
}
