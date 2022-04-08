package com.oneklickshop.api.request.headers.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.oneklickshop.api.BaseTest;
import com.oneklickshop.api.config.OneKlickShop;
import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * API Request Body Test Class.
 *
 * <p>Test OneKlickShop endpoint request body.
 *
 * @author Jagdeep Jain
 */
public class AdminRequestHeaderTest extends BaseTest {

  @BeforeTest
  public void setup() {
    admin();
  }

  @Test(description = "verify invalid token not allowed on request payload", priority = 3)
  public void testInvalidToken() {
    String USER = "src/test/resources/payload/user/user.json";
    setJwtToken("");
    request().post(OneKlickShop.ADD_USER.url(), new File(USER));
    assertThat(response().getResponse().getStatusCode()).isEqualTo(401);
    assertThat(response().getResponse().jsonPath().getString("error")).isEqualTo("Unauthorized");
    assertThat(response().getResponse().jsonPath().getString("message"))
        .isEqualTo("Unauthorized : Server");
    assertThat(response().getResponse().jsonPath().getString("path"))
        .isEqualTo("/eshop/api/v1/users");
  }

  @Test(
      description = "verify invalid content type not allowed on request " + "payload",
      priority = 3)
  public void testInvalidContentType() {
    String USER = "src/test/resources/payload/user/user.json";
    setContentType("text/html");
    request().post(OneKlickShop.ADD_USER.url(), new File(USER));
    assertThat(response().getResponse().getStatusCode()).isEqualTo(415);
    assertThat(response().getResponse().jsonPath().getString("message"))
        .isEqualTo("Content type 'text/html;charset=ISO-8859-1' not supported");
  }
}
