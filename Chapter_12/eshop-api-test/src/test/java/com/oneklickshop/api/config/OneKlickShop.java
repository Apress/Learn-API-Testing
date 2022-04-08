package com.oneklickshop.api.config;

/**
 * OneKlickShopConfig API Endpoints
 *
 * @author Jagdeep Jain
 */
public enum OneKlickShop {
  LOGIN {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().LOGIN();
    }
  },
  ADD_BILLING_ADDRESS {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().ADD_BILLING_ADDRESS();
    }
  },

  ADD_CART {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().ADD_CART();
    }
  },

  ADD_PAYMENT {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().ADD_PAYMENT();
    }
  },

  ADD_PRODUCT {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().ADD_PRODUCT();
    }
  },

  ADD_SHIPPING_ADDRESS {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().ADD_SHIPPING_ADDRESS();
    }
  },
  ADD_USER {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().ADD_USER();
    }
  },
  DELETE_USER {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().DELETE_USER();
    }
  },
  FIND_BILLING_ADDRESS {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().FIND_BILLING_ADDRESS();
    }
  },
  FIND_PAYMENT {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().FIND_PAYMENT();
    }
  },
  FIND_PRODUCT {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().FIND_PRODUCT();
    }
  },
  FIND_SHIPPING_ADDRESS {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().FIND_SHIPPING_ADDRESS();
    }
  },
  FIND_USER {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().FIND_USER();
    }
  },
  LIST_CART {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().LIST_CART();
    }
  },

  LIST_ORDERS {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().LIST_ORDERS();
    }
  },
  LIST_PRODUCTS {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().LIST_PRODUCTS();
    }
  },
  LIST_PRODUCTS_ASC {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().LIST_PRODUCTS_ASC();
    }
  },
  LIST_PRODUCTS_DESC {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().LIST_PRODUCTS_DESC();
    }
  },
  LIST_USERS {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().LIST_USERS();
    }
  },
  LIST_USERS_ASC {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().LIST_USERS_ASC();
    }
  },
  LIST_USERS_BY_FIRSTNAME_WITH_PAGE_AND_SIZE {
    @Override
    public String url() {
      return AppConfig.getUrl()
          + AppConfig.getOneKlickShopConfig().LIST_USERS_BY_FIRSTNAME_WITH_PAGE_AND_SIZE();
    }
  },
  LIST_USERS_BY_PAGE {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().LIST_USERS_BY_PAGE();
    }
  },
  LIST_USERS_BY_PAGE_AND_SIZE {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().LIST_USERS_BY_PAGE_AND_SIZE();
    }
  },
  LIST_USERS_BY_SIZE {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().LIST_USERS_BY_SIZE();
    }
  },
  LIST_USERS_DESC {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().LIST_USERS_DESC();
    }
  },
  LIST_USERS_FILTER_BY_FIRSTNAME {
    @Override
    public String url() {
      return AppConfig.getUrl()
          + AppConfig.getOneKlickShopConfig().LIST_USERS_FILTER_BY_FIRSTNAME();
    }
  },
  PRODUCT_LIST_BY_CATEGORY_WITH_PAGE_AND_SIZE {
    @Override
    public String url() {
      return AppConfig.getUrl()
          + AppConfig.getOneKlickShopConfig().PRODUCT_LIST_BY_CATEGORY_WITH_PAGE_AND_SIZE();
    }
  },
  PRODUCT_LIST_BY_PAGE_AND_SIZE {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().PRODUCT_LIST_BY_PAGE_AND_SIZE();
    }
  },
  PRODUCT_LIST_FILTER_BY_CATEGORY {
    @Override
    public String url() {
      return AppConfig.getUrl()
          + AppConfig.getOneKlickShopConfig().PRODUCT_LIST_FILTER_BY_CATEGORY();
    }
  },
  PRODUCTS_LIST_BY_PAGE {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().PRODUCTS_LIST_BY_PAGE();
    }
  },
  PRODUCTS_LIST_BY_SIZE {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().PRODUCTS_LIST_BY_SIZE();
    }
  },
  SUBMIT_ORDER {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().SUBMIT_ORDER();
    }
  },
  UPDATE_BILLING_ADDRESS {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().UPDATE_BILLING_ADDRESS();
    }
  },
  UPDATE_PAYMENT {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().UPDATE_PAYMENT();
    }
  },
  UPDATE_PRODUCT {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().UPDATE_PRODUCT();
    }
  },
  UPDATE_SHIPPING_ADDRESS {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().UPDATE_SHIPPING_ADDRESS();
    }
  },
  UPDATE_USER {
    @Override
    public String url() {
      return AppConfig.getUrl() + AppConfig.getOneKlickShopConfig().UPDATE_USER();
    }
  };

  public abstract String url();
}
