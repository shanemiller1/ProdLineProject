package sample;

/**
 * Abstract class product implements Item.
 *
 * @author Shane Miller
 */
public abstract class Product implements Item {
  /**
   * fields in the product class.
   *
   * @author Shane Miller
   */
  private int id; //I know these naming parameters are causing checkstyle errors
  private ItemType type;
  private String manufacturer;
  private String name;

  /**
   * constructor setting this.variables to variables.
   *
   * @param name         the name.
   * @param manufacturer the name of manufacturer.
   * @param type         the type.
   */
  Product(String name, String manufacturer, ItemType type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;

  }

  /**
   * constructor setting this.variables to variables.
   *
   * @param name         the name.
   * @param manufacturer the manufactuer.
   */
  public Product(String name, String manufacturer) {
    this.name = name;
    this.manufacturer = manufacturer;
  }

  public Product() {

  }

  /**
   * constructor setting this.variables to variables.
   *
   * @param id           int id
   * @param type         itemtype is type
   * @param manufacturer string is manufacturer
   * @param name         string is name
   */
  public Product(int id, ItemType type, String manufacturer, String name) {
    this.id = id;
    this.type = type;
    this.manufacturer = manufacturer;
    this.name = name;
  }

  /**
   * constructor Product passes id, name , manufacturer and type.
   *
   * @param id           int id
   * @param name         string name
   * @param manufacturer string manufacturer
   * @param type         ItemType type
   */
  public Product(int id, String name, String manufacturer, ItemType type) {
  }

  // idk where this here
  public Product(int id, String name, String type, String manufacturer) {
  }

  public String toString() {
    return "Name: " + name + "\n" + "Manufacturer: " + manufacturer + "\n" + "Type: " + type;
  }

  /**
   * getManufacturer method receives manufacturer variable for manufacturer.
   *
   * @return the return.
   */
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * method setting manufacturer to manufacturer.
   *
   * @param manufacturer returns manufacturer.
   */
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   * getName method receives name variable for name.
   *
   * @return returns the name.
   */
  public String getName() {
    return name;
  }

  /**
   * setName method sets name variable for name.
   *
   * @param name the name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * getId method receives Id type variable for Id.
   *
   * @return returns id.
   */
  public int getId() {
    return id;
  }

  /**
   * setId method sets Id variable for Id.
   *
   * @param id the id.
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * getType method receives type variable for type.
   *
   * @return returns type.
   */
  public ItemType getType() {
    return type;
  }

  /**
   * setType method sets type variable for type.
   *
   * @param type the type.
   */
  public void setType(ItemType type) {
    this.type = type;
  }
}
