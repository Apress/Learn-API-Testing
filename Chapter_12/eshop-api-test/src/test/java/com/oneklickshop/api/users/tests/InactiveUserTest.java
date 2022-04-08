package com.oneklickshop.api.users.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.oneklickshop.api.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Inactive User Test Class.
 *
 * <p>Test POST /login endpoint for inactive user.
 *
 * @author Jagdeep Jain
 */
public class InactiveUserTest extends BaseTest {

  @BeforeTest
  public void setup() {}

  @Test(description = "verify response of POST /login for inactive user", priority = 1)
  public void testInactiveUserLogin() {
    inactiveUser();
    assertThat(response().getResponse().getStatusCode()).isEqualTo(500);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .isEqualTo("Unknown error occurred.");
  }
}
