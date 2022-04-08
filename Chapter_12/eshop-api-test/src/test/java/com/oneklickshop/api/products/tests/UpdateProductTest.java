package com.oneklickshop.api.products.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.oneklickshop.api.BaseTest;
import com.oneklickshop.api.config.OneKlickShop;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Update Product Test Class.
 *
 * <p>Test POST /api/v1/products endpoint for updating product.
 *
 * @author Jagdeep Jain
 */
public class UpdateProductTest extends BaseTest {
  private static final int PRODUCT_ID = 1012;
  private final Map<String, Integer> query = new HashMap<>();

  @BeforeTest
  public void setup() {
    admin();
  }

  @Test(description = "verify response of POST /api/v1/products/{id}", priority = 2)
  public void testUpdateProduct() {
    query.put("id", PRODUCT_ID);
    String PRODUCT = "src/test/resources/payload/product/updateProduct.json";
    request().put(OneKlickShop.UPDATE_PRODUCT.url(), new File(PRODUCT), query);
    assertThat(response().getResponse().getStatusCode()).isEqualTo(200);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP" + "/1.1 " + "200 ");
  }
}
