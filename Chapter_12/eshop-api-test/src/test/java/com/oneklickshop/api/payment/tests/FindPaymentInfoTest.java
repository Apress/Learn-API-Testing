package com.oneklickshop.api.payment.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.oneklickshop.api.BaseTest;
import com.oneklickshop.api.config.OneKlickShop;
import com.oneklickshop.model.PaymentInfo;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Find User Payment Test Class.
 *
 * <p>Test GET /api/v1/user/payment endpoint for fetching user payment address for a given user.
 *
 * @author Jagdeep Jain
 */
public class FindPaymentInfoTest extends BaseTest {
  private static final int RESPONSE_LENGTH = 13;

  @BeforeTest
  public void setup() {
    user();
  }

  @Test(description = "verify response of GET " + "/api/v1/user/payment", priority = 1)
  public void testFindPayment() {
    request().get(OneKlickShop.FIND_PAYMENT.url());
    PaymentInfo paymentInfo = response().getPaymentInfo();

    assertThat(response().getResponse().getContentType())
        .isEqualTo("application/json;charset=UTF-8");
    assertThat(response().getResponse().getStatusCode()).isEqualTo(200);
    assertThat(response().getResponse().getStatusLine()).isEqualTo("HTTP" + "/1.1 200 ");
    assertThat(paymentInfo.getCardExpiry()).startsWith("12/202");
    assertThat(paymentInfo.getCardNumber()).isNotEmpty();
    assertThat(paymentInfo.getNameOnCard()).startsWith("Jagdeep");
  }
}
