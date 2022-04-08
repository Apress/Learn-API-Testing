package com.contact.mgmt.api.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ApplicationContext a spring configuration class.
 *
 * <p>This class is used for setting up the test configuration including environment specific
 * properties file. This is being used the by BaseTest for setting up the test configuration.
 *
 * @author Jagdeep Jain
 */
public class ApplicationContext {
  private final AnnotationConfigApplicationContext appCfgCtx1 =
      new AnnotationConfigApplicationContext(SpringBeanConfiguration.class);
  private final AnnotationConfigApplicationContext appCfgCtx2 =
      new AnnotationConfigApplicationContext(SpringBeanConfiguration.class);
  private final TestConfig testCfgCtx = appCfgCtx1.getBean(TestConfig.class);
  private final ContactManagementConfig contactManagementConfigCfgCtx =
      appCfgCtx2.getBean(ContactManagementConfig.class);
  private TestConfig testConfig;
  private ContactManagementConfig contactManagementConfig;

  public ApplicationContext() {
    setTestConfig(testCfgCtx);
    appCfgCtx1.close();
    setContactManagementConfig(contactManagementConfigCfgCtx);
    appCfgCtx2.close();
  }

  public TestConfig getTestConfig() {
    return testConfig;
  }

  protected void setTestConfig(TestConfig testConfig) {
    this.testConfig = testConfig;
  }

  public String getUrl() {
    return testConfig.getUrl();
  }

  public ContactManagementConfig getContactManagementConfig() {
    return contactManagementConfig;
  }

  private void setContactManagementConfig(ContactManagementConfig contactManagementConfig) {
    this.contactManagementConfig = contactManagementConfig;
  }
}
