package com.oneklickshop.api.billing.address.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.oneklickshop.api.BaseTest;
import com.oneklickshop.api.config.OneKlickShop;
import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Update User Billing Address Test Class.
 *
 * <p>Test POST /api/v1/user/billing/address endpoint for updating billing address of a user.
 *
 * @author Jagdeep Jain
 */
public class UpdateBillingAddressTest extends BaseTest {

  @BeforeTest
  public void setup() {
    user();
  }

  @Test(description = "verify response of POST /api/v1/user/billing/address", priority = 2)
  public void testUpdateBillingAddress() {
    String BILLING_ADDRESS = "src/test/resources/payload/billing" + "/updateAddress.json";
    request().put(OneKlickShop.UPDATE_BILLING_ADDRESS.url(), new File(BILLING_ADDRESS));
    assertThat(response().getResponse().getStatusCode()).isEqualTo(200);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP" + "/1.1 " + "200 ");
  }
}
