package com.oneklickshop.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * SpringBeanConfiguration class does the spring config setup.
 *
 * <p>It is a standard Java Spring configuration file a replacement of XML based configuration.
 *
 * @author Jagdeep Jain
 */
@Configuration
@ComponentScan
public class SpringBeanConfiguration {
  @Bean
  public static PropertySourcesPlaceholderConfigurer propertyConfig() {
    return new PropertySourcesPlaceholderConfigurer();
  }
}
