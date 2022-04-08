package com.oneklickshop.api.error.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.oneklickshop.api.BaseTest;
import com.oneklickshop.api.config.OneKlickShop;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * API Request Body Test Class.
 *
 * <p>Test OneKlickShop endpoint request body.
 *
 * @author Jagdeep Jain
 */
public class ErrorTest extends BaseTest {
  private static final Map<String, Integer> query = new HashMap<>();
  String USER = "src/test/resources/payload/user/user.json";
  final int USER_ID = 2000;

  @BeforeTest
  public void setup() {
    query.put("id", USER_ID); // user does not exists
    admin();
  }

  @Test(description = "verify error message on no such user exists", priority = 3)
  public void testFindNonExistingUser() {
    request().put(OneKlickShop.FIND_USER.url(), new File(USER), query);
    assertThat(response().getResponse().getStatusCode()).isEqualTo(404);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .isEqualTo("user not found with id : " + USER_ID);
  }

  @Test(description = "verify error message on no such user exists", priority = 3)
  public void testDeleteNonExistingUser() {
    request().put(OneKlickShop.DELETE_USER.url(), new File(USER), query);
    assertThat(response().getResponse().getStatusCode()).isEqualTo(404);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .isEqualTo("user not found with id : " + USER_ID);
  }

  @Test(description = "verify error message on no such user exists", priority = 3)
  public void testUpdateNonExistingUser() {
    request().put(OneKlickShop.UPDATE_USER.url(), new File(USER), query);
    assertThat(response().getResponse().getStatusCode()).isEqualTo(404);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .isEqualTo("user not found with id : " + USER_ID);
  }
}
