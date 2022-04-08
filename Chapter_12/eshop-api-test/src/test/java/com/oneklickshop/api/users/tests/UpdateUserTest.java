package com.oneklickshop.api.users.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.oneklickshop.api.BaseTest;
import com.oneklickshop.api.config.OneKlickShop;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Update User Test Class.
 *
 * <p>Test PUT /api/v1/users/{id} endpoint for updating a user for a given user id.
 *
 * @author Jagdeep Jain
 */
public class UpdateUserTest extends BaseTest {
  private static final Map<String, Integer> query = new HashMap<>();
  private static final int USER_ID = 110;

  @BeforeTest
  public void setup() {
    admin();
  }

  @Test(description = "verify response of PUT /api/v1/users/{id}", priority = 2)
  public void testUpdateUser() {
    query.put("id", USER_ID);
    String USER_UPDATE = "src/test/resources/payload/user/updateUser.json";
    request().put(OneKlickShop.UPDATE_USER.url(), new File(USER_UPDATE), query);

    assertThat(response().getResponse().getStatusCode()).isEqualTo(200);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP" + "/1" + ".1 200 ");
  }
}
