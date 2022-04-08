package com.oneklickshop.api.products.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.oneklickshop.api.BaseTest;
import com.oneklickshop.api.config.OneKlickShop;
import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Add Product Test Class.
 *
 * <p>Test POST /api/v1/products endpoint for adding product.
 *
 * @author Jagdeep Jain
 */
public class AddProductTest extends BaseTest {

  @BeforeTest
  public void setup() {
    admin();
  }

  @Test(description = "verify response of POST /api/v1/products", priority = 1)
  public void testAddProduct() {
    String PRODUCT = "src/test/resources/payload/product/product.json";
    request().post(OneKlickShop.ADD_PRODUCT.url(), new File(PRODUCT));
    assertThat(response().getResponse().getStatusCode()).isEqualTo(201);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP" + "/1.1 " + "201 ");
  }
}
