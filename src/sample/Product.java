package sample;

public abstract class Product implements Item {
  private int Id;
  private String Type;
  private String Manufacturer;
  private String Name;

  Product(String name, String manufacturer, String type){
    this.Name = name;
    this.Manufacturer = manufacturer;
    this.Type = type;

  }

  public Product(String name, String manufacturer) {
    this.Name = name;
    this.Manufacturer = manufacturer;
  }

  public Product() {

  }

  public String toString(){
    return "Name: " + Name + "\n" + "Manufacturer: " + Manufacturer + "\n" + "Type: " + Type;
  }

  public int getId(){
    return Id;
  }

  public String getManufacturer() {
    return Manufacturer;
  }

  public void setManufacturer(String manufacturer){
    Manufacturer = manufacturer;
  }

  public String getName(){
    return Name;
  }

  public void setName(String name){
    Name = name;
  }

  public void setId(int id) {
    Id = id;
  }

  public String getType() {
    return Type;
  }

  public void setType(String type) {
    Type = type;
  }
}

class Widget extends Product{
  public Widget(String name, String manufacturer, String type){
    super(name, manufacturer, type);
  }
}
