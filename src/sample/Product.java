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
    private int Id; //I know these naming parameters are causing checkstyle errors
    private ItemType Type;
    private String Manufacturer;
    private String Name;

    /**
     * constructor setting this.variables to variables.
     *
     * @param name the name.
     * @param manufacturer  the name of manufacturer.
     * @param type  the type.
     */
    Product(String name, String manufacturer, ItemType type) {
        this.Name = name;
        this.Manufacturer = manufacturer;
        this.Type = type;

    }

    /**
     * constructor setting this.variables to variables.
     *
     * @param name  the name.
     * @param manufacturer  the manufactuer.
     */
    public Product(String name, String manufacturer) {
        this.Name = name;
        this.Manufacturer = manufacturer;
    }

    public Product() {

    }

    /**
     * constructor setting this.variables to variables.
     *
     * @param id    int id
     * @param type  itemtype is type
     * @param manufacturer string is manufacturer
     * @param name  string is name
     */
    public Product(int id, ItemType type, String manufacturer, String name) {
        this.Id = id;
        this.Type = type;
        this.Manufacturer = manufacturer;
        this.Name = name;
    }

    /**
     * constructor Product passes id, name , manufacturer and type.
     *
     * @param id    int id
     * @param name  string name
     * @param manufacturer  string manufacturer
     * @param type ItemType type
     */
    public Product(int id, String name, String manufacturer, ItemType type) {
    }

    // idk where this here
    public Product(int id, String name, String type, String manufacturer) {
    }

    public String toString() {
        return "Name: " + Name + "\n" + "Manufacturer: " + Manufacturer + "\n" + "Type: " + Type;
    }

    /**
     * getManufacturer method receives manufacturer variable for manufacturer.
     *
     * @return
     */
    public String getManufacturer() {
        return Manufacturer;
    }

    /**
     * method setting manufacturer to manufacturer.
     *
     * @param manufacturer returns manufacturer.
     */
    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    /**
     * getName method receives name variable for name.
     *
     * @return
     */
    public String getName() {
        return Name;
    }

    /**
     * setName method sets name variable for name.
     *
     * @return
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * getId method receives Id type variable for Id.
     *
     * @return
     */
    public int getId() {
        return Id;
    }

    /**
     * setId method sets Id variable for Id.
     *
     * @return
     */
    public void setId(int id) {
        Id = id;
    }

    /**
     * getType method receives type variable for type.
     *
     * @return
     */
    public ItemType getType() {
        return Type;
    }

    /**
     * setType method sets type variable for type.
     *
     * @return
     */
    public void setType(ItemType type) {
        Type = type;
    }
}

class Widget extends Product {
    /**
     * constructor for widget passing super class parameters.
     *
     * @param name string name.
     * @param manufacturer string manufacturer.
     * @param type ItemType type.
     */
    public Widget(String name, String manufacturer, ItemType type) {
        super(name, manufacturer, type);
    }
}
