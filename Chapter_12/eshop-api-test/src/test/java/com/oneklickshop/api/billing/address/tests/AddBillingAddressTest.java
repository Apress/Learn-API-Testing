package com.oneklickshop.api.billing.address.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.oneklickshop.api.BaseTest;
import com.oneklickshop.api.config.OneKlickShop;
import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Add User Billing Address Test Class.
 *
 * <p>Test POST /api/v1/user/billing/address endpoint for adding billing address of a user.
 *
 * @author Jagdeep Jain
 */
public class AddBillingAddressTest extends BaseTest {

  @BeforeTest
  public void setup() {
    user();
  }

  @Test(description = "verify response of POST /api/v1/user/billing/address", priority = 1)
  public void testAddBillingAddress() {
    String BILLING_ADDRESS = "src/test/resources/payload/billing/address.json";
    request().post(OneKlickShop.ADD_BILLING_ADDRESS.url(), new File(BILLING_ADDRESS));
    assertThat(response().getResponse().getStatusCode()).isEqualTo(201);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP" + "/1.1 " + "201 ");
  }
}
