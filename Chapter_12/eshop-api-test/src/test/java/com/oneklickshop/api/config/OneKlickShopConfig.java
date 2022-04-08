package com.oneklickshop.api.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * OneKlickShopConfig a spring configuration class having API endpoint handles.
 *
 * <p>This class will provide the endpoints of the OneKlickShopConfig APIs to the test classes.
 *
 * @author Jagdeep Jain
 */
@Configuration
@PropertySource("classpath:properties/REST-endpoints.properties")
public class OneKlickShopConfig {
  protected final Logger log = LogManager.getLogger(this.getClass());

  @Value("${login}")
  private String LOGIN;

  @Value("${users.list}")
  private String LIST_USERS;

  @Value("${users.list.size}")
  private String LIST_USERS_BY_SIZE;

  @Value("${users.list.page}")
  private String LIST_USERS_BY_PAGE;

  @Value("${users.list.filter.firstname}")
  private String LIST_USERS_FILTER_BY_FIRSTNAME;

  @Value("${users.list.page.size}")
  private String LIST_USERS_BY_PAGE_AND_SIZE;

  @Value("${users.list.firstname.page.size}")
  private String LIST_USERS_BY_FIRSTNAME_WITH_PAGE_AND_SIZE;

  @Value("${users.list.asc}")
  private String LIST_USERS_ASC;

  @Value("${users.list.desc}")
  private String LIST_USERS_DESC;

  @Value("${users.add}")
  private String ADD_USER;

  @Value("${users.find}")
  private String FIND_USER;

  @Value("${users.update}")
  private String UPDATE_USER;

  @Value("${users.delete}")
  private String DELETE_USER;

  @Value("${user.shipping.add}")
  private String ADD_SHIPPING_ADDRESS;

  @Value("${user.shipping.update}")
  private String UPDATE_SHIPPING_ADDRESS;

  @Value("${user.shipping.find}")
  private String FIND_SHIPPING_ADDRESS;

  @Value("${user.billing.add}")
  private String ADD_BILLING_ADDRESS;

  @Value("${user.billing.update}")
  private String UPDATE_BILLING_ADDRESS;

  @Value("${user.billing.find}")
  private String FIND_BILLING_ADDRESS;

  @Value("${user.payment.add}")
  private String ADD_PAYMENT;

  @Value("${user.payment.update}")
  private String UPDATE_PAYMENT;

  @Value("${user.payment.find}")
  private String FIND_PAYMENT;

  @Value("${products.list}")
  private String LIST_PRODUCTS;

  @Value("${products.list.size}")
  private String PRODUCTS_LIST_BY_SIZE;

  @Value("${products.list.page}")
  private String PRODUCTS_LIST_BY_PAGE;

  @Value("${products.list.filter.category}")
  private String PRODUCT_LIST_FILTER_BY_CATEGORY;

  @Value("${products.list.page.size}")
  private String PRODUCT_LIST_BY_PAGE_AND_SIZE;

  @Value("${products.list.category.page.size}")
  private String PRODUCT_LIST_BY_CATEGORY_WITH_PAGE_AND_SIZE;

  @Value("${products.list.asc}")
  private String LIST_PRODUCTS_ASC;

  @Value("${products.list.desc}")
  private String LIST_PRODUCTS_DESC;

  @Value("${products.add}")
  private String ADD_PRODUCT;

  @Value("${products.find}")
  private String FIND_PRODUCT;

  @Value("${products.update}")
  private String UPDATE_PRODUCT;

  @Value("${add.cart}")
  private String ADD_CART;

  @Value("${list.cart}")
  private String LIST_CART;

  @Value("${submit.order}")
  private String SUBMIT_ORDER;

  @Value("${list.order}")
  private String LIST_ORDERS;

  public String LOGIN() {
    return LOGIN.split(",")[1];
  }

  public String LIST_USERS() {
    return LIST_USERS.split(",")[1];
  }

  public String LIST_USERS_BY_SIZE() {
    return LIST_USERS_BY_SIZE.split(",")[1];
  }

  public String LIST_USERS_BY_PAGE() {
    return LIST_USERS_BY_PAGE.split(",")[1];
  }

  public String LIST_USERS_FILTER_BY_FIRSTNAME() {
    return LIST_USERS_FILTER_BY_FIRSTNAME.split(",")[1];
  }

  public String LIST_USERS_BY_PAGE_AND_SIZE() {
    return LIST_USERS_BY_PAGE_AND_SIZE.split(",")[1];
  }

  public String LIST_USERS_BY_FIRSTNAME_WITH_PAGE_AND_SIZE() {
    return LIST_USERS_BY_FIRSTNAME_WITH_PAGE_AND_SIZE.split(",")[1];
  }

  public String LIST_USERS_ASC() {
    return (LIST_USERS_ASC.split(",")[1] + "," + LIST_USERS_ASC.split(",")[2]);
  }

  public String LIST_USERS_DESC() {
    return (LIST_USERS_DESC.split(",")[1] + "," + LIST_USERS_DESC.split(",")[2]);
  }

  public String ADD_USER() {
    return ADD_USER.split(",")[1];
  }

  public String FIND_USER() {
    return FIND_USER.split(",")[1];
  }

  public String UPDATE_USER() {
    return UPDATE_USER.split(",")[1];
  }

  public String DELETE_USER() {
    return DELETE_USER.split(",")[1];
  }

  public String ADD_SHIPPING_ADDRESS() {
    return ADD_SHIPPING_ADDRESS.split(",")[1];
  }

  public String UPDATE_SHIPPING_ADDRESS() {
    return UPDATE_SHIPPING_ADDRESS.split(",")[1];
  }

  public String FIND_SHIPPING_ADDRESS() {
    return FIND_SHIPPING_ADDRESS.split(",")[1];
  }

  public String ADD_BILLING_ADDRESS() {
    return ADD_BILLING_ADDRESS.split(",")[1];
  }

  public String UPDATE_BILLING_ADDRESS() {
    return UPDATE_BILLING_ADDRESS.split(",")[1];
  }

  public String FIND_BILLING_ADDRESS() {
    return FIND_BILLING_ADDRESS.split(",")[1];
  }

  public String ADD_PAYMENT() {
    return ADD_PAYMENT.split(",")[1];
  }

  public String UPDATE_PAYMENT() {
    return UPDATE_PAYMENT.split(",")[1];
  }

  public String FIND_PAYMENT() {
    return FIND_PAYMENT.split(",")[1];
  }

  public String LIST_PRODUCTS() {
    return LIST_PRODUCTS.split(",")[1];
  }

  public String PRODUCTS_LIST_BY_SIZE() {
    return PRODUCTS_LIST_BY_SIZE.split(",")[1];
  }

  public String PRODUCTS_LIST_BY_PAGE() {
    return PRODUCTS_LIST_BY_PAGE.split(",")[1];
  }

  public String PRODUCT_LIST_FILTER_BY_CATEGORY() {
    return PRODUCT_LIST_FILTER_BY_CATEGORY.split(",")[1];
  }

  public String PRODUCT_LIST_BY_PAGE_AND_SIZE() {
    return PRODUCT_LIST_BY_PAGE_AND_SIZE.split(",")[1];
  }

  public String PRODUCT_LIST_BY_CATEGORY_WITH_PAGE_AND_SIZE() {
    return PRODUCT_LIST_BY_CATEGORY_WITH_PAGE_AND_SIZE.split(",")[1];
  }

  public String LIST_PRODUCTS_ASC() {
    return LIST_PRODUCTS_ASC.split(",")[1];
  }

  public String LIST_PRODUCTS_DESC() {
    return LIST_PRODUCTS_DESC.split(",")[1];
  }

  public String ADD_PRODUCT() {
    return ADD_PRODUCT.split(",")[1];
  }

  public String FIND_PRODUCT() {
    return FIND_PRODUCT.split(",")[1];
  }

  public String UPDATE_PRODUCT() {
    return UPDATE_PRODUCT.split(",")[1];
  }

  public String ADD_CART() {
    return ADD_CART.split(",")[1];
  }

  public String LIST_CART() {
    return LIST_CART.split(",")[1];
  }

  public String SUBMIT_ORDER() {
    return SUBMIT_ORDER.split(",")[1];
  }

  public String LIST_ORDERS() {
    return LIST_ORDERS.split(",")[1];
  }
}
