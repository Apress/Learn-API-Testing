package com.oneklickshop.api.authorization.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.oneklickshop.api.BaseTest;
import com.oneklickshop.api.config.OneKlickShop;
import com.oneklickshop.model.Forbidden;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Admin Authorization Test Class.
 *
 * <p>Test OneKlickShop endpoint authorization.
 *
 * @author Jagdeep Jain
 */
public class AdminAuthorizationTest extends BaseTest {

  @BeforeTest
  public void setup() {
    admin();
  }

  @Test(description = "verify response of POST /api/v1/user/billing/address", priority = 1)
  public void testAddBillingAddressAuth() {

    String BILLING_ADDRESS = "src/test/resources/payload/billing/address.json";
    request().post(OneKlickShop.ADD_BILLING_ADDRESS.url(), new File(BILLING_ADDRESS));
    Forbidden forbidden = response().getForbiddenMessage();
    assertThat(response().getResponse().getStatusCode()).isEqualTo(403);
    assertThat(forbidden.getTimestamp()).isNotNull();
    assertThat(forbidden.getStatus()).isEqualTo(403);
    assertThat(forbidden.getError()).isEqualTo("Forbidden");
    assertThat(forbidden.getMessage()).isEqualTo("Forbidden");
    assertThat(forbidden.getPath()).endsWith("/api/v1/user/billing/address");
  }

  @Test(description = "verify response of POST /api/v1/user/billing/address", priority = 1)
  public void testUpdateBillingAddressAuth() {
    String BILLING_ADDRESS = "src/test/resources/payload/billing" + "/updateAddress.json";
    request().put(OneKlickShop.UPDATE_BILLING_ADDRESS.url(), new File(BILLING_ADDRESS));
    Forbidden forbidden = response().getForbiddenMessage();
    assertThat(response().getResponse().getStatusCode()).isEqualTo(403);
    assertThat(forbidden.getTimestamp()).isNotNull();
    assertThat(forbidden.getStatus()).isEqualTo(403);
    assertThat(forbidden.getError()).isEqualTo("Forbidden");
    assertThat(forbidden.getMessage()).isEqualTo("Forbidden");
    assertThat(forbidden.getPath()).endsWith("/api/v1/user/billing/address");
  }

  @Test(description = "verify response of GET /api/v1/user/billing/address", priority = 1)
  public void testFindBillingAddressAuth() {
    request().get(OneKlickShop.FIND_BILLING_ADDRESS.url());
    Forbidden forbidden = response().getForbiddenMessage();
    assertThat(response().getResponse().getStatusCode()).isEqualTo(403);
    assertThat(forbidden.getTimestamp()).isNotNull();
    assertThat(forbidden.getStatus()).isEqualTo(403);
    assertThat(forbidden.getError()).isEqualTo("Forbidden");
    assertThat(forbidden.getMessage()).isEqualTo("Forbidden");
    assertThat(forbidden.getPath()).endsWith("/api/v1/user/billing/address");
  }

  @Test(description = "verify response of POST /api/v1/user/shipping/address", priority = 1)
  public void testAddShippingAddressAuth() {
    String SHIPPING_ADDRESS = "src/test/resources/payload/shipping/address.json";
    request().post(OneKlickShop.ADD_SHIPPING_ADDRESS.url(), new File(SHIPPING_ADDRESS));
    Forbidden forbidden = response().getForbiddenMessage();
    assertThat(response().getResponse().getStatusCode()).isEqualTo(403);
    assertThat(forbidden.getTimestamp()).isNotNull();
    assertThat(forbidden.getStatus()).isEqualTo(403);
    assertThat(forbidden.getError()).isEqualTo("Forbidden");
    assertThat(forbidden.getMessage()).isEqualTo("Forbidden");
    assertThat(forbidden.getPath()).endsWith("/api/v1/user/shipping/address");
  }

  @Test(description = "verify response of PUT /api/v1/user/shipping/address", priority = 1)
  public void testUpdateShippingAddressAuth() {
    String SHIPPING_ADDRESS = "src/test/resources/payload/shipping/address.json";
    request().put(OneKlickShop.UPDATE_SHIPPING_ADDRESS.url(), new File(SHIPPING_ADDRESS));
    Forbidden forbidden = response().getForbiddenMessage();
    assertThat(response().getResponse().getStatusCode()).isEqualTo(403);
    assertThat(forbidden.getTimestamp()).isNotNull();
    assertThat(forbidden.getStatus()).isEqualTo(403);
    assertThat(forbidden.getError()).isEqualTo("Forbidden");
    assertThat(forbidden.getMessage()).isEqualTo("Forbidden");
    assertThat(forbidden.getPath()).endsWith("/api/v1/user/shipping/address");
  }

  @Test(description = "verify response of GET /api/v1/user/shipping/address", priority = 1)
  public void testFindShippingAddressAuth() {
    request().get(OneKlickShop.FIND_SHIPPING_ADDRESS.url());
    Forbidden forbidden = response().getForbiddenMessage();
    assertThat(response().getResponse().getStatusCode()).isEqualTo(403);
    assertThat(forbidden.getTimestamp()).isNotNull();
    assertThat(forbidden.getStatus()).isEqualTo(403);
    assertThat(forbidden.getError()).isEqualTo("Forbidden");
    assertThat(forbidden.getMessage()).isEqualTo("Forbidden");
    assertThat(forbidden.getPath()).endsWith("/api/v1/user/shipping/address");
  }

  @Test(description = "verify response of POST /api/v1/user/payment", priority = 1)
  public void testAddPaymentInfoAddressAuth() {
    String PAYMENT = "src/test/resources/payload/payment/payment.json";
    request().post(OneKlickShop.ADD_PAYMENT.url(), new File(PAYMENT));
    Forbidden forbidden = response().getForbiddenMessage();
    assertThat(response().getResponse().getStatusCode()).isEqualTo(403);
    assertThat(forbidden.getTimestamp()).isNotNull();
    assertThat(forbidden.getStatus()).isEqualTo(403);
    assertThat(forbidden.getError()).isEqualTo("Forbidden");
    assertThat(forbidden.getMessage()).isEqualTo("Forbidden");
    assertThat(forbidden.getPath()).endsWith("/api/v1/user/payment");
  }

  @Test(description = "verify response of PUT /api/v1/user/payment", priority = 1)
  public void testUpdatePaymentInfoAddressAuth() {
    String PAYMENT = "src/test/resources/payload/payment/payment.json";
    request().put(OneKlickShop.UPDATE_PAYMENT.url(), new File(PAYMENT));
    Forbidden forbidden = response().getForbiddenMessage();
    assertThat(response().getResponse().getStatusCode()).isEqualTo(403);
    assertThat(forbidden.getTimestamp()).isNotNull();
    assertThat(forbidden.getStatus()).isEqualTo(403);
    assertThat(forbidden.getError()).isEqualTo("Forbidden");
    assertThat(forbidden.getMessage()).isEqualTo("Forbidden");
    assertThat(forbidden.getPath()).endsWith("/api/v1/user/payment");
  }

  @Test(description = "verify response of GET /api/v1/user/payment", priority = 1)
  public void testFindPaymentInfoAddressAuth() {
    request().get(OneKlickShop.FIND_PAYMENT.url());
    Forbidden forbidden = response().getForbiddenMessage();
    assertThat(response().getResponse().getStatusCode()).isEqualTo(403);
    assertThat(forbidden.getTimestamp()).isNotNull();
    assertThat(forbidden.getStatus()).isEqualTo(403);
    assertThat(forbidden.getError()).isEqualTo("Forbidden");
    assertThat(forbidden.getMessage()).isEqualTo("Forbidden");
    assertThat(forbidden.getPath()).endsWith("/api/v1/user/payment");
  }

  @Test(
      description =
          "verify response of POST " + "/api/v1/user/cart" + "/{productId}/quantity/{qty}",
      priority = 1)
  public void testAddToCartAuth() {
    final Map<String, Integer> query = new HashMap<>();
    query.put("productId", 1012);
    query.put("qty", 2);
    request().post(OneKlickShop.ADD_CART.url(), query);
    Forbidden forbidden = response().getForbiddenMessage();
    assertThat(response().getResponse().getStatusCode()).isEqualTo(403);
    assertThat(forbidden.getTimestamp()).isNotNull();
    assertThat(forbidden.getStatus()).isEqualTo(403);
    assertThat(forbidden.getError()).isEqualTo("Forbidden");
    assertThat(forbidden.getMessage()).isEqualTo("Forbidden");
    assertThat(forbidden.getPath())
        .endsWith("/api/v1/user/cart/" + query.get("productId") + "/quantity/" + query.get("qty"));
  }

  @Test(description = "verify response of GET /api/v1/user/cart", priority = 1)
  public void testListCartAuth() {
    request().get(OneKlickShop.LIST_CART.url());
    Forbidden forbidden = response().getForbiddenMessage();
    assertThat(response().getResponse().getStatusCode()).isEqualTo(403);
    assertThat(forbidden.getTimestamp()).isNotNull();
    assertThat(forbidden.getStatus()).isEqualTo(403);
    assertThat(forbidden.getError()).isEqualTo("Forbidden");
    assertThat(forbidden.getMessage()).isEqualTo("Forbidden");
    assertThat(forbidden.getPath()).endsWith("/api/v1/user/cart");
  }

  @Test(description = "verify response of POST /api/v1/user/orders", priority = 1)
  public void testSubmitOrderAuth() {
    request().post(OneKlickShop.SUBMIT_ORDER.url());
    Forbidden forbidden = response().getForbiddenMessage();
    assertThat(response().getResponse().getStatusCode()).isEqualTo(403);
    assertThat(forbidden.getTimestamp()).isNotNull();
    assertThat(forbidden.getStatus()).isEqualTo(403);
    assertThat(forbidden.getError()).isEqualTo("Forbidden");
    assertThat(forbidden.getMessage()).isEqualTo("Forbidden");
    assertThat(forbidden.getPath()).endsWith("/api/v1/user/orders");
  }

  @Test(description = "verify response of GET /api/v1/user/orders", priority = 1)
  public void testListOrderAuth() {
    request().get(OneKlickShop.LIST_ORDERS.url());
    Forbidden forbidden = response().getForbiddenMessage();
    assertThat(response().getResponse().getStatusCode()).isEqualTo(403);
    assertThat(forbidden.getTimestamp()).isNotNull();
    assertThat(forbidden.getStatus()).isEqualTo(403);
    assertThat(forbidden.getError()).isEqualTo("Forbidden");
    assertThat(forbidden.getMessage()).isEqualTo("Forbidden");
    assertThat(forbidden.getPath()).endsWith("/api/v1/user/orders");
  }
}
