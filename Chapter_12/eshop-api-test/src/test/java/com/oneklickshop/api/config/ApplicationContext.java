package com.oneklickshop.api.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
  protected final Logger log = LogManager.getLogger(ApplicationContext.class);
  private TestConfig testConfig;
  private OneKlickShopConfig oneKlickShopConfig;
  private final AnnotationConfigApplicationContext appCfgCtx1 =
      new AnnotationConfigApplicationContext(SpringBeanConfiguration.class);
  private final AnnotationConfigApplicationContext appCfgCtx2 =
      new AnnotationConfigApplicationContext(SpringBeanConfiguration.class);
  private final TestConfig testCfgCtx = appCfgCtx1.getBean(TestConfig.class);
  private final OneKlickShopConfig oneKlickShopCfgCtx =
      appCfgCtx2.getBean(OneKlickShopConfig.class);

  public ApplicationContext() {
    setTestConfig(testCfgCtx);
    appCfgCtx1.close();
    setOneKlickShopConfig(oneKlickShopCfgCtx);
    appCfgCtx2.close();
  }

  public TestConfig getTestConfig() {
    return this.testConfig;
  }

  protected void setTestConfig(TestConfig config) {
    this.testConfig = config;
  }

  public String getUrl() {
    return testConfig.getUrl();
  }

  public OneKlickShopConfig getOneKlickShopConfig() {
    return this.oneKlickShopConfig;
  }

  public void setOneKlickShopConfig(OneKlickShopConfig config) {
    this.oneKlickShopConfig = config;
  }
}
