package com.oneklickshop.api.payment.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.oneklickshop.api.BaseTest;
import com.oneklickshop.api.config.OneKlickShop;
import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Update User Payment Info Test Class.
 *
 * <p>Test POST /api/v1/user/payment endpoint for updating payment info of a user.
 *
 * @author Jagdeep Jain
 */
public class UpdatePaymentInfoTest extends BaseTest {

  @BeforeTest
  public void setup() {
    user();
  }

  @Test(description = "verify response of POST /api/v1/user/payment", priority = 2)
  public void testUpdatePayment() {
    String PAYMENT = "src/test/resources/payload/payment/updatePayment.json";
    request().put(OneKlickShop.UPDATE_PAYMENT.url(), new File(PAYMENT));
    assertThat(response().getResponse().getStatusCode()).isEqualTo(200);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP" + "/1.1 " + "200 ");
  }
}
