package com.oneklickshop.api.users.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.oneklickshop.api.BaseTest;
import com.oneklickshop.api.config.OneKlickShop;
import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Add User Test Class.
 *
 * <p>Test POST /api/v1/users endpoint for adding a user.
 *
 * @author Jagdeep Jain
 */
public class AddUserTest extends BaseTest {

  @BeforeTest
  public void setup() {
    admin();
  }

  @Test(description = "verify response of POST /api/v1/users", priority = 2)
  public void testAddUser() {
    String USER = "src/test/resources/payload/user/user.json";
    request().post(OneKlickShop.ADD_USER.url(), new File(USER));
    assertThat(response().getResponse().getStatusCode()).isEqualTo(201);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP" + "/1.1 " + "201 ");
  }
}
