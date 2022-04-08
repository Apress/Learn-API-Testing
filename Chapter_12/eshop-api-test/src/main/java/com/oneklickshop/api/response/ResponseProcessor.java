package com.oneklickshop.api.response;

import com.oneklickshop.api.response.factory.ResponseAbstractFactory;
import com.oneklickshop.api.response.factory.ResponseFactoryCreator;
import com.oneklickshop.model.*;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ResponseProcessor class is used for processing the http response.
 *
 * <p>This class is used for processing the response types with ResponseFactoryCreator.
 *
 * @author Jagdeep Jain
 */
public class ResponseProcessor {
  final Logger log = LogManager.getLogger(this.getClass());
  ResponseAbstractFactory responseFactory = ResponseFactoryCreator.getFactory();
  private Response response;

  public Response getResponse() {
    return response;
  }

  public void setResponse(Response response) {
    this.response = response;
  }

  public User getUser() {
    return responseFactory.getUserResponse().setResponse(this.response).getUserPage();
  }

  public UserPage getUserPage() {
    return responseFactory.getUserPageResponse().setResponse(this.response).getUserPage();
  }

  public BillingAddress getBillingAddress() {
    return responseFactory
        .getBillingAddressResponse()
        .setResponse(this.response)
        .getBillingAddress();
  }

  public Item getItem() {
    return responseFactory.getItemResponse().setResponse(this.response).getItem();
  }

  public OrderDetail getOrderDetail() {
    return responseFactory.getOrderDetailResponse().setResponse(this.response).getOrderDetail();
  }

  public OrderHistory getOrderHistory() {
    return responseFactory.getOrderHistoryResponse().setResponse(this.response).getOrderHistory();
  }

  public PaymentInfo getPaymentInfo() {
    return responseFactory.getPaymentInfoResponse().setResponse(this.response).getPaymentInfo();
  }

  public Product getProduct() {
    return responseFactory.getProductResponse().setResponse(this.response).getProduct();
  }

  public ProductPage getProductPage() {
    return responseFactory.getProductPageResponse().setResponse(this.response).getProductPage();
  }

  public ShippingAddress getShippingAddress() {
    return responseFactory
        .getShippingAddressResponse()
        .setResponse(this.response)
        .getShippingAddress();
  }

  public ShoppingCart getShoppingCart() {
    return responseFactory.getShoppingCartResponse().setResponse(this.response).getShoppingCart();
  }

  public Forbidden getForbiddenMessage() {
    return responseFactory.getForbiddenResponse().setResponse(this.response).getForbiddenMessage();
  }

  public JwtPayload getJwtPayload() {
    return responseFactory.getAuthResponse().setResponse(this.response).getJwtPayload();
  }
}
