package sample;

/**
 * interface defining variables.
 *
 * @author Shane Miller
 */
public interface Item {
  int getId();

  void setName(String name);

  String getName();

  void setManufacturer(String manufacturer);

  String getManufacturer();
}
