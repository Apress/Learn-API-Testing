package com.oneklickshop.api.users.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.oneklickshop.api.BaseTest;
import com.oneklickshop.api.config.OneKlickShop;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Delete User Test Class.
 *
 * <p>Test DELETE /api/v1/users/{id} endpoint for deleting a user.
 *
 * @author Jagdeep Jain
 */
public class DeleteUserTest extends BaseTest {
  private static final Map<String, Integer> query = new HashMap<>();
  private static final int USER_ID = 114;

  @BeforeTest
  public void setup() {
    admin();
    query.put("id", USER_ID);
  }

  @Test(description = "verify response of DELETE /api/v1/users/{id}", priority = 1)
  public void testDeleteUser() {
    request().delete(OneKlickShop.DELETE_USER.url(), query);
    assertThat(response().getResponse().getStatusCode()).isEqualTo(204);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP/1.1 204 ");
  }
}
