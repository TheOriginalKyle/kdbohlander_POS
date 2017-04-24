package kdbohlander_pos;

public class Product
{

    private String sku;
    private String type;
    private String description;
    private double price;

    public Product(String aSku, String aType, String aDesc, double aPrice)
    {
        this.sku = sku;
        this.type = aType;
        this.description = aDesc;
        this.price = aPrice;
    }

    //We don't use sku's anywhere.
    public String getSku()
    {
        return sku;
    }

    //Just why?
    public void setSku(String sku)
    {
        this.sku = sku;
    }

    //Type is also unused
    public String getType()
    {
        return type;
    }

    //Unused
    public void setType(String type)
    {
        this.type = type;
    }

    //Used for the menu
    public String getDescription()
    {
        return description;
    }

    //Not sure if used I didn't see it anywhere but ¯\_(ツ)_/¯ 
    public void setDescription(String description)
    {
        this.description = description;
    }

    //Used for the receipt and for calculations.
    public double getPrice()
    {
        return price;
    }

    //I'm not sure if this was ever used. ¯\_(ツ)_/¯ 
    public void setPrice(double price)
    {
        this.price = price;
    }

}
