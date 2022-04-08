package com.oneklickshop.api.users.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.oneklickshop.api.BaseTest;
import com.oneklickshop.api.config.OneKlickShop;
import com.oneklickshop.model.UserPage;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * User Page Test Class.
 *
 * <p>Test GET /api/v1/users endpoint for getting all active users in a page.
 *
 * @author Jagdeep Jain
 */
public class UserPageTest extends BaseTest {

  @BeforeTest
  public void setup() {
    admin();
  }

  @Test(description = "verify response body of GET /api/v1/users", priority = 1)
  public void testUserPage() {
    request().get(OneKlickShop.LIST_USERS.url());
    UserPage userPage = response().getUserPage();

    assertThat(response().getResponse().getContentType())
        .isEqualTo("application/json;charset=UTF-8");
    assertThat(response().getResponse().getStatusCode()).isEqualTo(200);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP/1.1 200 ");
    assertThat(userPage.getTotalItems()).isGreaterThan(20);
    assertThat(userPage.getTotalPages()).isGreaterThan(2);
    assertThat(userPage.getCurrentPage()).isZero();
    userPage
        .getUsers()
        .forEach(
            user -> {
              assertThat(user.getId()).isPositive();
              assertThat(user.getFirstname()).isNotEmpty();
              assertThat(user.getLastname()).isNotEmpty();
              assertThat(user.getEmail()).contains("@");
              assertThat(user.getUsername()).contains("@");
            });
  }

  @Test(description = "verify response body of GET /api/v1/users asc order", priority = 1)
  public void testUserListAscOrder() {
    request().get(OneKlickShop.LIST_USERS_ASC.url());
    UserPage userPage = response().getUserPage();

    assertThat(response().getResponse().getContentType())
        .isEqualTo("application/json;charset=UTF-8");
    assertThat(response().getResponse().getStatusCode()).isEqualTo(200);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP/1.1 200 ");
    assertThat(userPage.getUsers().get(0).getFirstname()).isEqualTo("Alkesh");
    assertThat(userPage.getUsers().get(0).getLastname()).isEqualTo("Ji");
    assertThat(userPage.getUsers().get(0).getUsername()).isEqualTo("alkeshji" + "@alkeshji-99.com");
    assertThat(userPage.getUsers().get(0).getEmail()).isEqualTo("alkeshji" + "@alkeshji-99.com");
    assertThat(userPage.getUsers().get(0).getRoles().get(0).getAuthority()).isEqualTo("ROLE_USER");
  }

  @Test(description = "verify response body of GET /api/v1/users by page", priority = 1)
  public void testUserByPage() {
    final Map<String, Object> query = new HashMap<>();
    query.put("page", 1);
    request().get(OneKlickShop.LIST_USERS_BY_PAGE.url(), query);
    UserPage userPage = response().getUserPage();

    assertThat(response().getResponse().getContentType())
        .isEqualTo("application/json;charset=UTF-8");
    assertThat(response().getResponse().getStatusCode()).isEqualTo(200);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP/1.1 200 ");
    assertThat(userPage.getUsers().get(0).getFirstname()).isEqualTo("Vidhut");
    assertThat(userPage.getUsers().get(0).getLastname()).isEqualTo("Singh");
    assertThat(userPage.getUsers().get(0).getUsername()).isEqualTo("vs@v-singh.com");
    assertThat(userPage.getUsers().get(0).getEmail()).isEqualTo("vs@v-singh.com");
    assertThat(userPage.getUsers().get(0).getRoles().get(0).getAuthority()).isEqualTo("ROLE_USER");
  }

  @Test(
      description = "verify response body of GET /api/v1/users by all " + "condition",
      priority = 1)
  public void testUserByFirstNameWithPageAndSize() {
    final Map<String, Object> query = new HashMap<>();
    query.put("firstname", "Jagdeep");
    query.put("page", 1);
    query.put("size", 1);

    request().get(OneKlickShop.LIST_USERS_BY_FIRSTNAME_WITH_PAGE_AND_SIZE.url(), query);
    UserPage userPage = response().getUserPage();

    assertThat(response().getResponse().getContentType())
        .isEqualTo("application/json;charset=UTF-8");
    assertThat(response().getResponse().getStatusCode()).isEqualTo(200);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP/1.1 200 ");
    assertThat(userPage.getUsers().get(0).getFirstname()).isEqualTo("Jagdeep");
    assertThat(userPage.getUsers().get(0).getLastname()).isEqualTo("Sinha");
    assertThat(userPage.getUsers().get(0).getUsername()).isEqualTo("jjain@total-123.com");
    assertThat(userPage.getUsers().get(0).getEmail()).isEqualTo("jsinha@total-123.com");
    assertThat(userPage.getUsers().get(0).getRoles().get(0).getAuthority()).isEqualTo("ROLE_USER");
  }

  @Test(
      description = "verify response body of GET /api/v1/users by page and " + "size",
      priority = 1)
  public void testUserByPageAndSize() {
    final Map<String, Integer> query = new HashMap<>();
    query.put("page", 1);
    query.put("size", 1);
    request().get(OneKlickShop.LIST_USERS_BY_PAGE_AND_SIZE.url(), query);
    UserPage userPage = response().getUserPage();

    assertThat(response().getResponse().getContentType())
        .isEqualTo("application/json;charset=UTF-8");
    assertThat(response().getResponse().getStatusCode()).isEqualTo(200);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP/1.1 200 ");
    assertThat(userPage.getUsers().get(0).getFirstname()).isEqualTo("Kuldeep");
    assertThat(userPage.getUsers().get(0).getLastname()).isEqualTo("Ji");
    assertThat(userPage.getUsers().get(0).getUsername()).isEqualTo("kld@kld-99.com");
    assertThat(userPage.getUsers().get(0).getEmail()).isEqualTo("kld@kld-99.com");
    assertThat(userPage.getUsers().get(0).getRoles().get(0).getAuthority()).isEqualTo("ROLE_USER");
  }

  @Test(description = "verify response body of GET /api/v1/users by size", priority = 1)
  public void testUserBySize() {
    final Map<String, Integer> query = new HashMap<>();
    query.put("size", 1);
    request().get(OneKlickShop.LIST_USERS_BY_SIZE.url(), query);
    UserPage userPage = response().getUserPage();

    assertThat(response().getResponse().getContentType())
        .isEqualTo("application/json;charset=UTF-8");
    assertThat(response().getResponse().getStatusCode()).isEqualTo(200);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP/1.1 200 ");
    assertThat(userPage.getUsers().get(0).getFirstname()).isEqualTo("Kalpesh");
    assertThat(userPage.getUsers().get(0).getLastname()).isEqualTo("Lohati");
    assertThat(userPage.getUsers().get(0).getUsername()).isEqualTo("kl@kl.com");
    assertThat(userPage.getUsers().get(0).getEmail()).isEqualTo("kl@kl.com");
    assertThat(userPage.getUsers().get(0).getRoles().get(0).getAuthority()).isEqualTo("ROLE_USER");
  }

  @Test(description = "verify response body of GET /api/v1/users desc order", priority = 1)
  public void testUserDescOrder() {
    request().get(OneKlickShop.LIST_USERS_DESC.url());
    UserPage userPage = response().getUserPage();

    assertThat(response().getResponse().getContentType())
        .isEqualTo("application/json;charset=UTF-8");
    assertThat(response().getResponse().getStatusCode()).isEqualTo(200);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP/1.1 200 ");
    assertThat(userPage.getUsers().get(0).getFirstname()).isEqualTo("Vidhut");
    assertThat(userPage.getUsers().get(0).getLastname()).isEqualTo("Singh");
    assertThat(userPage.getUsers().get(0).getUsername()).isEqualTo("vs@v-singh.com");
    assertThat(userPage.getUsers().get(0).getEmail()).isEqualTo("vs@v-singh.com");
    assertThat(userPage.getUsers().get(0).getRoles().get(0).getAuthority()).isEqualTo("ROLE_USER");
  }

  @Test(
      description = "verify response body of GET /api/v1/users filter by " + "firstname",
      priority = 1)
  public void testUserFilterByFirstname() {
    final Map<String, String> query = new HashMap<>();
    query.put("firstname", "Jagdeep");
    request().get(OneKlickShop.LIST_USERS_FILTER_BY_FIRSTNAME.url(), query);
    UserPage userPage = response().getUserPage();

    assertThat(response().getResponse().getContentType())
        .isEqualTo("application/json;charset=UTF-8");
    assertThat(response().getResponse().getStatusCode()).isEqualTo(200);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP/1.1 200 ");
    assertThat(userPage.getUsers().get(0).getFirstname()).isEqualTo("Jagdeep");
    assertThat(userPage.getUsers().get(0).getLastname()).isEqualTo("Sinha");
    assertThat(userPage.getUsers().get(0).getUsername()).isEqualTo("jjain@total-123.com");
    assertThat(userPage.getUsers().get(0).getEmail()).isEqualTo("jsinha@total-123.com");
    assertThat(userPage.getUsers().get(0).getRoles().get(0).getAuthority()).isEqualTo("ROLE_USER");
  }
}
