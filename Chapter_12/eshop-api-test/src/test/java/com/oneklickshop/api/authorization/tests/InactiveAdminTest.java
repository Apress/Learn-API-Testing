package com.oneklickshop.api.authorization.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.oneklickshop.api.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Inactive Admin Test Class.
 *
 * <p>Test POST /login endpoint for inactive admin.
 *
 * @author Jagdeep Jain
 */
public class InactiveAdminTest extends BaseTest {

  @BeforeTest
  public void setup() {}

  @Test(description = "verify response of POST /login for inactive admin", priority = 1)
  public void testInactiveAdminLogin() {
    inactiveAdmin();
    assertThat(response().getResponse().getStatusCode()).isEqualTo(500);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .isEqualTo("Unknown error occurred.");
  }
}
