package com.oneklickshop.api.products.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.oneklickshop.api.BaseTest;
import com.oneklickshop.api.config.OneKlickShop;
import com.oneklickshop.model.Product;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Find Product Test Class.
 *
 * <p>Test GET /api/v1/products endpoint for fetching product.
 *
 * @author Jagdeep Jain
 */
public class FindProductTest extends BaseTest {
  private static final int RESPONSE_LENGTH = 13;
  private static final int PRODUCT_ID = 1013;

  @BeforeTest
  public void setup() {}

  @Test(description = "verify response of GET " + "/api/v1/products for admin", priority = 1)
  public void testFindProductAdminRole() {
    admin();
    final Map<String, Integer> query = new HashMap<>();
    query.put("id", PRODUCT_ID);
    request().get(OneKlickShop.FIND_PRODUCT.url(), query);
    Product product = response().getProduct();

    assertThat(response().getResponse().getContentType())
        .isEqualTo("application/json;charset=UTF-8");
    assertThat(response().getResponse().getStatusCode()).isEqualTo(200);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP" + "/1.1 200 ");
    assertThat(product.getCategory()).isEqualTo("TV");
    assertThat(product.getName()).startsWith("Nonida 32 Inch");
    assertThat(product.getShortDescription()).isEqualTo("Ghost inside, catch all the actions");
    assertThat(product.getCost()).isEqualTo(12000.00);
  }

  @Test(description = "verify response of GET " + "/api/v1/products for user", priority = 1)
  public void testFindProductUserRole() {
    user();
    final Map<String, Integer> query = new HashMap<>();
    query.put("id", PRODUCT_ID);
    request().get(OneKlickShop.FIND_PRODUCT.url(), query);
    Product product = response().getProduct();

    assertThat(response().getResponse().getContentType())
        .isEqualTo("application/json;charset=UTF-8");
    assertThat(response().getResponse().getStatusCode()).isEqualTo(200);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP" + "/1.1 200 ");
    assertThat(product.getCategory()).isEqualTo("TV");
    assertThat(product.getName()).startsWith("Nonida 32 Inch");
    assertThat(product.getShortDescription()).isEqualTo("Ghost inside, catch all the actions");
    assertThat(product.getCost()).isEqualTo(12000.00);
  }
}
