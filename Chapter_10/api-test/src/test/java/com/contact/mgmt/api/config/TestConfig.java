package com.contact.mgmt.api.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * TestConfig class does the test configuration setup based on the environment passed from the
 * command prompt.
 *
 * <p>env variable holds the environment specific properties file for example test, dev, stage,
 * prod.
 *
 * @author Jagdeep Jain
 */
@Configuration
@PropertySource("classpath:properties/${env}.properties")
public class TestConfig {
  protected final Logger log = LogManager.getLogger(this.getClass());

  @Value("${url}")
  private String url;

  public String getUrl() {
    return url;
  }
}
