package sample;

/**
 * class for widget extending product.
 * @author Shane Miller
 */

class Widget extends Product {
  /**
   * constructor for widget passing super class parameters.
   *
   * @param name         string name.
   * @param manufacturer string manufacturer.
   * @param type         ItemType type.
   */
  public Widget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
  }
}