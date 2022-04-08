package com.oneklickshop.api.response.factory;

import com.oneklickshop.api.response.*;
import com.oneklickshop.api.response.impl.*;

/**
 * ResponseFactory implements ResponseAbstractFactory.
 *
 * <p>This class help in providing the different response type objects.
 *
 * @author Jagdeep Jain
 */
public class ResponseFactory implements ResponseAbstractFactory {
  @Override
  public UserResponse getUserResponse() {
    return new UserResponseImpl();
  }

  @Override
  public UserPageResponse getUserPageResponse() {
    return new UserPageResponseImpl();
  }

  @Override
  public BillingAddressResponse getBillingAddressResponse() {
    return new BillingAddressResponseImpl();
  }

  @Override
  public ItemResponse getItemResponse() {
    return new ItemResponseImpl();
  }

  @Override
  public OrderDetailResponse getOrderDetailResponse() {
    return new OrderDetailResponseImpl();
  }

  @Override
  public OrderHistoryResponse getOrderHistoryResponse() {
    return new OrderHistoryResponseImpl();
  }

  @Override
  public PaymentInfoResponse getPaymentInfoResponse() {
    return new PaymentInfoResponseImpl();
  }

  @Override
  public ProductResponse getProductResponse() {
    return new ProductResponseImpl();
  }

  @Override
  public ProductPageResponse getProductPageResponse() {
    return new ProductPageResponseImpl();
  }

  @Override
  public ShippingAddressResponse getShippingAddressResponse() {
    return new ShippingAddressResponseImpl();
  }

  @Override
  public ShoppingCartResponse getShoppingCartResponse() {
    return new ShoppingCartResponseImpl();
  }

  @Override
  public ForbiddenResponse getForbiddenResponse() {
    return new ForbiddenResponseImpl();
  }

  @Override
  public AuthResponse getAuthResponse() {
    return new AuthResponseImpl();
  }
}
