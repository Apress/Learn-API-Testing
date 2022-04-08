package com.oneklickshop.api.config;

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

  public static OneKlickShopConfig getOneKlickShopConfig() {
    return applicationContext.getOneKlickShopConfig();
  }
}
