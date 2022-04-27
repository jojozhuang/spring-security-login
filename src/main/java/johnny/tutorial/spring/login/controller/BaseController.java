package johnny.tutorial.spring.login.controller;

public abstract class BaseController {
  protected static final String ATTRIBUTE_KEY_MODULE = "module";
  protected static final String ATTRIBUTE_KEY_CUSTOMERS = "customers";
  protected static final String ATTRIBUTE_KEY_CUSTOMER = "customer";
  protected static final String ATTRIBUTE_KEY_PRODUCTS = "products";
  protected static final String ATTRIBUTE_KEY_PRODUCT = "product";
  protected static final String ATTRIBUTE_KEY_ORDERS = "orders";

  protected static final String MODULE_CUSTOMERS = "customers";
  protected static final String MODULE_PRODUCTS = "products";
  protected static final String MODULE_ORDERS = "orders";

  protected static final String TEMPLATE_NAME_INDEX = "index";
  protected static final String TEMPLATE_NAME_LOGIN = "login";
  protected static final String TEMPLATE_NAME_CUSTOMERS = "customers";
  protected static final String TEMPLATE_NAME_CUSTOMER_DETAILS = "customer-details";
  protected static final String TEMPLATE_NAME_PRODUCTS = "products";
  protected static final String TEMPLATE_NAME_PRODUCT_DETAILS = "product-details";
  protected static final String TEMPLATE_NAME_ORDERS = "orders";

  protected static final String ERROR_ENTITY_NOT_FOUND = "entity not found";
}
