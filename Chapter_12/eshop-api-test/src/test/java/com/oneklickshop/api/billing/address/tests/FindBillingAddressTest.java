package com.oneklickshop.api.billing.address.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.oneklickshop.api.BaseTest;
import com.oneklickshop.api.config.OneKlickShop;
import com.oneklickshop.model.BillingAddress;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Find User Billing Address Test Class.
 *
 * <p>Test GET /api/v1/user/billing/address endpoint for fetching user billing address for a given
 * user.
 *
 * @author Jagdeep Jain
 */
public class FindBillingAddressTest extends BaseTest {
  private static final int RESPONSE_LENGTH = 13;

  @BeforeTest
  public void setup() {
    user();
  }

  @Test(description = "verify response of GET " + "/api/v1/user/billing/address", priority = 1)
  public void testFindBillingAddress() {
    request().get(OneKlickShop.FIND_BILLING_ADDRESS.url());
    BillingAddress billingAddress = response().getBillingAddress();

    assertThat(response().getResponse().getContentType())
        .isEqualTo("application/json;charset=UTF-8");
    assertThat(response().getResponse().getStatusCode()).isEqualTo(200);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP" + "/1.1 200 ");
    assertThat(billingAddress.getAddress1()).endsWith("Billing Address 1");
    assertThat(billingAddress.getAddress2()).endsWith("Billing Address 2");
    assertThat(billingAddress.getCity()).isEqualTo("Mumbai");
    assertThat(billingAddress.getCountry()).isEqualTo("India");
    assertThat(billingAddress.getState()).isEqualTo("Maharashtra");
    assertThat(billingAddress.getZip()).isEqualTo("460001");
  }
}
