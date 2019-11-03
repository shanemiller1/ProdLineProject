package sample;

public abstract class Product implements Item {
    /**
     * fields in the product class.
     *
     * @author Shane Miller
     */
    private int Id;
    private ItemType Type;
    private String Manufacturer;
    private String Name;

    /**
     * constructor setting this.variables to variables.
     *
     * @param name
     * @param manufacturer
     * @param type
     */
    Product(String name, String manufacturer, ItemType type) {
        this.Name = name;
        this.Manufacturer = manufacturer;
        this.Type = type;

    }

    /**
     * constructor setting this.variables to variables.
     *
     * @param name
     * @param manufacturer
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
     * @param id
     * @param type
     * @param manufacturer
     * @param name
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
     * @param id
     * @param name
     * @param manufacturer
     * @param type
     */
    public Product(int id, String name, String manufacturer, String type) {
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
     * method setting manufacturer to manufacturer
     *
     * @param manufacturer
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
     * @param name
     * @param manufacturer
     * @param type
     */
    public Widget(String name, String manufacturer, ItemType type) {
        super(name, manufacturer, type);
    }

    /**
     * constructor for widget passing super class parameters.
     *
     * @param id
     * @param name
     * @param manufacturer
     * @param type
     */
    public Widget(int id, String name, String manufacturer, String type) {
        super(id, name, manufacturer, type);
    }
}
