package com.oneklickshop.api.shipping.address.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.oneklickshop.api.BaseTest;
import com.oneklickshop.api.config.OneKlickShop;
import com.oneklickshop.model.ShippingAddress;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Find User Shipping Address Test Class.
 *
 * <p>Test GET /api/v1/user/shipping/address endpoint for fetching user shipping address for a given
 * user.
 *
 * @author Jagdeep Jain
 */
public class FindShippingAddressTest extends BaseTest {
  private static final int RESPONSE_LENGTH = 13;

  @BeforeTest
  public void setup() {
    user();
  }

  @Test(description = "verify response of GET " + "/api/v1/user/shipping/address", priority = 1)
  public void testFindShippingAddress() {
    request().get(OneKlickShop.FIND_SHIPPING_ADDRESS.url());
    ShippingAddress shippingAddress = response().getShippingAddress();

    assertThat(response().getResponse().getContentType())
        .isEqualTo("application/json;charset=UTF-8");
    assertThat(response().getResponse().getStatusCode()).isEqualTo(200);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP" + "/1.1 200 ");
    assertThat(shippingAddress.getAddress1()).endsWith("Shipping Address 1");
    assertThat(shippingAddress.getAddress2()).endsWith("Shipping Address 2");
    assertThat(shippingAddress.getCity()).isEqualTo("Mumbai");
    assertThat(shippingAddress.getCountry()).isEqualTo("India");
    assertThat(shippingAddress.getState()).isEqualTo("Maharashtra");
    assertThat(shippingAddress.getZip()).isEqualTo("460001");
  }
}
