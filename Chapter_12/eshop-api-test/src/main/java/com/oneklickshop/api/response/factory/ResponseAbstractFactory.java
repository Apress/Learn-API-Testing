package com.oneklickshop.api.response.factory;

import com.oneklickshop.api.response.*;

/**
 * ResponseAbstractFactory implements the Abstract Factory Pattern.
 *
 * <p>This interface help in providing the different response types.
 *
 * @author Jagdeep Jain
 */
public interface ResponseAbstractFactory {
  UserResponse getUserResponse();

  UserPageResponse getUserPageResponse();

  BillingAddressResponse getBillingAddressResponse();

  ItemResponse getItemResponse();

  OrderDetailResponse getOrderDetailResponse();

  OrderHistoryResponse getOrderHistoryResponse();

  PaymentInfoResponse getPaymentInfoResponse();

  ProductResponse getProductResponse();

  ProductPageResponse getProductPageResponse();

  ShippingAddressResponse getShippingAddressResponse();

  ShoppingCartResponse getShoppingCartResponse();

  ForbiddenResponse getForbiddenResponse();

  AuthResponse getAuthResponse();
}
