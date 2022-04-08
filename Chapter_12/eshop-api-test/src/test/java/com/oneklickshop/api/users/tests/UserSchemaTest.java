package com.oneklickshop.api.users.tests;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.MatcherAssert.assertThat;

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
public class UserSchemaTest extends BaseTest {
  private static final Map<String, Integer> query = new HashMap<>();
  String USER = "src/test/resources/schema/userSchema.json";
  final int USER_ID = 113;

  @BeforeTest
  public void setup() {
    admin();
    query.put("id", USER_ID);
  }

  @Test(description = "verify user schema", priority = 1)
  public void testUserSchema() {
    File file = new File(USER);
    request().get(OneKlickShop.FIND_USER.url(), query);

    assertThat(response().getResponse().getBody().asString(), matchesJsonSchema(file));
  }
}
