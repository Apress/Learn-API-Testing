package com.oneklickshop.api.products.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.oneklickshop.api.BaseTest;
import com.oneklickshop.api.config.OneKlickShop;
import com.oneklickshop.model.ProductPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Product Page Test Class.
 *
 * <p>Test GET /api/v1/products endpoint for getting all products in a page.
 *
 * @author Jagdeep Jain
 */
public class ProductPageTest extends BaseTest {

  @BeforeTest
  public void setup() {}

  @Test(
      description = "verify response body values type of GET /api/v1/products for admin",
      priority = 1)
  public void testProductPageAdminRole() {
    admin();
    request().get(OneKlickShop.LIST_PRODUCTS.url());
    ProductPage productPage = response().getProductPage();

    assertThat(response().getResponse().getContentType())
        .isEqualTo("application/json;charset=UTF-8");
    assertThat(response().getResponse().getStatusCode()).isEqualTo(200);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP/1.1 200 ");
    assertThat(productPage.getTotalItems()).isGreaterThan(1);
    assertThat(productPage.getTotalPages()).isGreaterThan(1);
    assertThat(productPage.getCurrentPage()).isZero();
    productPage
        .getProducts()
        .forEach(
            user -> {
              assertThat(user.getName()).isNotEmpty();
              assertThat(user.getShortDescription()).isNotEmpty();
              assertThat(user.getCategory()).isNotEmpty();
              assertThat(user.getCost()).isGreaterThan(0.00);
            });
  }

  @Test(
      description = "verify response body values type of GET /api/v1/products for user",
      priority = 1)
  public void testProductPageUserRole() {
    user();
    request().get(OneKlickShop.LIST_PRODUCTS.url());
    ProductPage productPage = response().getProductPage();

    assertThat(response().getResponse().getContentType())
        .isEqualTo("application/json;charset=UTF-8");
    assertThat(response().getResponse().getStatusCode()).isEqualTo(200);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP/1.1 200 ");
    assertThat(productPage.getTotalItems()).isGreaterThan(1);
    assertThat(productPage.getTotalPages()).isGreaterThan(1);
    assertThat(productPage.getCurrentPage()).isZero();
    productPage
        .getProducts()
        .forEach(
            user -> {
              assertThat(user.getName()).isNotEmpty();
              assertThat(user.getShortDescription()).isNotEmpty();
              assertThat(user.getCategory()).isNotEmpty();
              assertThat(user.getCost()).isGreaterThan(0.00);
            });
  }
}
