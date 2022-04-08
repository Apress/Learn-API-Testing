package com.oneklickshop.api.payment.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.oneklickshop.api.BaseTest;
import com.oneklickshop.api.config.OneKlickShop;
import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Add User Payment Info Test Class.
 *
 * <p>Test POST /api/v1/user/payment endpoint for adding payment info of a user.
 *
 * @author Jagdeep Jain
 */
public class AddPaymentInfoTest extends BaseTest {

  @BeforeTest
  public void setup() {
    user();
  }

  @Test(description = "verify response of POST /api/v1/user/payment", priority = 1)
  public void testAddPayment() {
    String PAYMENT = "src/test/resources/payload/payment/payment.json";
    request().post(OneKlickShop.ADD_PAYMENT.url(), new File(PAYMENT));
    assertThat(response().getResponse().getStatusCode()).isEqualTo(201);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP" + "/1.1 " + "201 ");
  }
}
