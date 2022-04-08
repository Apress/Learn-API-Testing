package com.oneklickshop.api.authorization.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.oneklickshop.api.BaseTest;
import com.oneklickshop.api.config.OneKlickShop;
import com.oneklickshop.model.Forbidden;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * User Authorization Test Class.
 *
 * <p>Test OneKlickShop endpoint authorization.
 *
 * @author Jagdeep Jain
 */
public class UserAuthorizationTest extends BaseTest {

  @BeforeTest
  public void setup() {
    user();
  }

  @Test(description = "verify response of POST /api/v1/users", priority = 1)
  public void testAddUserAuth() {
    String USER = "src/test/resources/payload/user/user.json";
    request().post(OneKlickShop.ADD_USER.url(), new File(USER));
    Forbidden forbidden = response().getForbiddenMessage();
    assertThat(response().getResponse().getStatusCode()).isEqualTo(403);
    assertThat(forbidden.getTimestamp()).isNotNull();
    assertThat(forbidden.getStatus()).isEqualTo(403);
    assertThat(forbidden.getError()).isEqualTo("Forbidden");
    assertThat(forbidden.getMessage()).isEqualTo("Forbidden");
    assertThat(forbidden.getPath()).endsWith("/api/v1/users");
  }

  @Test(description = "verify response of PUT /api/v1/users", priority = 1)
  public void testUpdateUserAuth() {
    final Map<String, Integer> query = new HashMap<>();
    query.put("id", 110);
    String USER = "src/test/resources/payload/user/user.json";
    request().put(OneKlickShop.UPDATE_USER.url(), new File(USER), query);
    Forbidden forbidden = response().getForbiddenMessage();
    assertThat(response().getResponse().getStatusCode()).isEqualTo(403);
    assertThat(forbidden.getTimestamp()).isNotNull();
    assertThat(forbidden.getStatus()).isEqualTo(403);
    assertThat(forbidden.getError()).isEqualTo("Forbidden");
    assertThat(forbidden.getMessage()).isEqualTo("Forbidden");
    assertThat(forbidden.getPath()).endsWith("/api/v1/users/110");
  }

  @Test(description = "verify response of GET /api/v1/users", priority = 1)
  public void testFindUserAuth() {
    final Map<String, Integer> query = new HashMap<>();
    query.put("id", 110);
    request().get(OneKlickShop.FIND_USER.url(), query);
    Forbidden forbidden = response().getForbiddenMessage();
    assertThat(response().getResponse().getStatusCode()).isEqualTo(403);
    assertThat(forbidden.getTimestamp()).isNotNull();
    assertThat(forbidden.getStatus()).isEqualTo(403);
    assertThat(forbidden.getError()).isEqualTo("Forbidden");
    assertThat(forbidden.getMessage()).isEqualTo("Forbidden");
    assertThat(forbidden.getPath()).endsWith("/api/v1/users/110");
  }

  @Test(description = "verify response of GET /api/v1/users", priority = 1)
  public void testFindAllUserAuth() {
    request().get(OneKlickShop.LIST_USERS.url());
    Forbidden forbidden = response().getForbiddenMessage();
    assertThat(response().getResponse().getStatusCode()).isEqualTo(403);
    assertThat(forbidden.getTimestamp()).isNotNull();
    assertThat(forbidden.getStatus()).isEqualTo(403);
    assertThat(forbidden.getError()).isEqualTo("Forbidden");
    assertThat(forbidden.getMessage()).isEqualTo("Forbidden");
    assertThat(forbidden.getPath()).endsWith("/api/v1/users");
  }

  @Test(description = "verify response of DELETE /api/v1/users", priority = 1)
  public void testDeleteUserAuth() {
    final Map<String, Integer> query = new HashMap<>();
    query.put("id", 110);
    request().delete(OneKlickShop.DELETE_USER.url(), query);
    Forbidden forbidden = response().getForbiddenMessage();
    assertThat(response().getResponse().getStatusCode()).isEqualTo(403);
    assertThat(forbidden.getTimestamp()).isNotNull();
    assertThat(forbidden.getStatus()).isEqualTo(403);
    assertThat(forbidden.getError()).isEqualTo("Forbidden");
    assertThat(forbidden.getMessage()).isEqualTo("Forbidden");
    assertThat(forbidden.getPath()).endsWith("/api/v1/users/110");
  }

  @Test(description = "verify response of POST /api/v1/products", priority = 1)
  public void testAddProductAuth() {
    String PRODUCT = "src/test/resources/payload/product/product.json";
    request().post(OneKlickShop.ADD_PRODUCT.url(), new File(PRODUCT));
    Forbidden forbidden = response().getForbiddenMessage();
    assertThat(response().getResponse().getStatusCode()).isEqualTo(403);
    assertThat(forbidden.getTimestamp()).isNotNull();
    assertThat(forbidden.getStatus()).isEqualTo(403);
    assertThat(forbidden.getError()).isEqualTo("Forbidden");
    assertThat(forbidden.getMessage()).isEqualTo("Forbidden");
    assertThat(forbidden.getPath()).endsWith("api/v1/products");
  }

  @Test(description = "verify response of PUT /api/v1/products", priority = 1)
  public void testUpdateProductAuth() {
    final Map<String, Integer> query = new HashMap<>();
    query.put("id", 110);
    String PRODUCT = "src/test/resources/payload/product/updateProduct.json";
    request().put(OneKlickShop.UPDATE_PRODUCT.url(), new File(PRODUCT), query);
    Forbidden forbidden = response().getForbiddenMessage();
    assertThat(response().getResponse().getStatusCode()).isEqualTo(403);
    assertThat(forbidden.getTimestamp()).isNotNull();
    assertThat(forbidden.getStatus()).isEqualTo(403);
    assertThat(forbidden.getError()).isEqualTo("Forbidden");
    assertThat(forbidden.getMessage()).isEqualTo("Forbidden");
    assertThat(forbidden.getPath()).endsWith("/api/v1/products/110");
  }
}
