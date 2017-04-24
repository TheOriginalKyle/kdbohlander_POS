package kdbohlander_pos;

import java.text.NumberFormat;
import java.util.Arrays;

public class Order
{

    private Customer orderCustomer;
    public Clerk orderClerk;
    private Product[] orderProduct;
    private int[] orderQuantity;

    //store totals
    private double subtotal;
    private double tax;
    private double total;

    //constant defining tax
    private static double TAX_RATE = 0.0825;

    //keep track of how many products were added
    private int productCount;

    //constructor
    public Order()
    {
        orderProduct = new Product[1];
        orderQuantity = new int[1];
    }

    //setter to assign customer
    public void setOrderCustomer(Customer aCustomer)
    {
        orderCustomer = aCustomer;
    }

    //setter to assign clerk
    public void setOrderClerk(Clerk aClerk)
    {
        orderClerk = aClerk;
    }

    //Adds the products and their quantities to the order.
    public void setOrderProduct(Product aProduct, int aQty)
    {
        if (productCount < orderProduct.length && productCount < orderQuantity.length) //If the new product doesn't exceed Array size add it in.
        {
            orderProduct[productCount] = aProduct;
            orderQuantity[productCount] = aQty;
            productCount++;
        }
        else //If its not the first product, resize the array and then add it in.
        {
            orderProduct = Arrays.copyOf(orderProduct, (orderProduct.length + 1));
            orderQuantity = Arrays.copyOf(orderQuantity, (orderQuantity.length + 1));
            orderProduct[productCount] = aProduct;
            orderQuantity[productCount] = aQty;
            productCount++;
        }
    }

    //Does what you think it does.
    public void calcSubtotal()
    {
        for (int i = 0; i < orderProduct.length; i++)
        {
            subtotal += (orderQuantity[i] * orderProduct[i].getPrice());
        }

    }

    //Does what you think it does.
    public void calcTax()
    {
        tax = (subtotal * TAX_RATE);
    }

    //Does what you think it does.
    public void calcTotal()
    {
        total = (subtotal + tax);
    }

    //This is basically everything in the receipt I don't see why we broke it up into three classes. I normally would've gave it its own class or shoved everything in here.
    public String toString()
    {
        NumberFormat nf = NumberFormat.getCurrencyInstance();

        String result = "";

        result += "CASHIER @ REGISTER\n " + orderClerk.getFirstName() + " " + orderClerk.getLastName() + " @ " + orderClerk.getRegisterNbr() + "\n\n";
        result += "Customer Info\n" + orderCustomer.toString() + "\n";
        result += "NUMBER OF ITEMS SOLD = " + getNumberItemsSold() + "\n\n";
        result += getReceiptBreakDown();
        result += "TOTALS\n";
        result += "Subtotal: " + nf.format(subtotal) + "\n";
        result += "Tax: " + nf.format(tax) + "\n";
        result += "Total: " + nf.format(total) + "\n";
        return result;
    }

    //Returns the number of items sold
    public int getNumberItemsSold()
    {
        int totalQty = 0;
        for (int i = 0; i < orderQuantity.length; i++)
        {
            totalQty += orderQuantity[i];
        }

        return totalQty;
    }

    //I seperated this from the toString() method for readability.
    public String getReceiptBreakDown()
    {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        String BreakDown = "";

        for (int i = 0; i < orderProduct.length; i++)
        {
            BreakDown += orderQuantity[i] + " " + "@ ";
            BreakDown += nf.format(orderProduct[i].getPrice()) + " = " + nf.format((orderProduct[i].getPrice() * orderQuantity[i])) + "\n";
            BreakDown += "    " + orderProduct[i].getDescription();
            BreakDown += "\n\n";
        }

        return BreakDown;
    }
}
