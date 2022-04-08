package com.oneklickshop.api.shipping.address.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.oneklickshop.api.BaseTest;
import com.oneklickshop.api.config.OneKlickShop;
import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Update User Shipping Address Test Class.
 *
 * <p>Test POST /api/v1/user/shipping/address endpoint for updating shipping address of a user.
 *
 * @author Jagdeep Jain
 */
public class UpdateShippingAddressTest extends BaseTest {

  @BeforeTest
  public void setup() {
    user();
  }

  @Test(description = "verify response of POST /api/v1/user/shipping/address", priority = 3)
  public void testUpdateShippingAddress() {
    String SHIPPING_ADDRESS = "src/test/resources/payload/shipping" + "/updateAddress.json";
    request().put(OneKlickShop.UPDATE_SHIPPING_ADDRESS.url(), new File(SHIPPING_ADDRESS));
    assertThat(response().getResponse().getStatusCode()).isEqualTo(200);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP" + "/1.1 " + "200 ");
  }
}
