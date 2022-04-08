package com.oneklickshop.api.users.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.oneklickshop.api.BaseTest;
import com.oneklickshop.api.config.OneKlickShop;
import com.oneklickshop.model.User;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Find User Test Class.
 *
 * <p>Test GET /api/v1/users/{id} endpoint for fetching user for a given contact id.
 *
 * @author Jagdeep Jain
 */
public class FindUserTest extends BaseTest {
  private static final int USER_ID = 107;
  private static final int RESPONSE_LENGTH = 13;
  private final Map<String, Integer> query = new HashMap<>();

  @BeforeTest
  public void setup() {
    admin();
  }

  @Test(description = "verify response of GET /api/v1/users/{id}", priority = 1)
  public void testFindUser() {
    query.put("id", USER_ID);
    request().get(OneKlickShop.FIND_USER.url(), query);
    User user = response().getUser();

    assertThat(response().getResponse().getContentType())
        .isEqualTo("application/json;charset=UTF-8");
    assertThat(response().getResponse().getStatusCode()).isEqualTo(200);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP" + "/1.1 200 ");
    assertThat(user.getId()).isEqualTo(USER_ID);
  }
}
