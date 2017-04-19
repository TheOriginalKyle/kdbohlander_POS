package kdbohlander_pos;

import java.text.NumberFormat;
import java.util.Arrays;

public class Order
{
    //class variables

    private Customer orderCustomer;
    private Clerk orderClerk;
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

    public void setOrderProduct(Product aProduct, int aQty)
    {
        //TODO
        //EACH TIME A USER ADDS A PRODUCT TO THE ORDER
        //IF IT IS THE FIRST PRODUCT ADDED TO THE ORDER THEN
        //STORE IT IN THE orderProduct ARRAY

        //IF MORE PRODUCTS ARE ADDED, YOU HAVE TO RESIZE THE 
        //orderProduct and orderQuantity arrays.
        //the way to do that is to the the Arrays.copyOf method or
        //to create temp array for each
        //copy the current arrays into temp arrays
        //resize the current arrays
        //put back the temp arrays in the current arrays
        //in the newly sized arrays
        //add the new product
        //add the quantity
    }

    public void calcSubtotal()
    {
        //TODO
        //FOR LOOP THROUGH THE orderProduct array
        //get the price
        //get the quantity from the orderQuantity array
        //STORE IT IN subtotal VARIABLE

    }

    public void calcTax()
    {
        //TODO
        //CALCULATE THE TAX
        //STORE IT IN tax VARIABLE
    }

    public void calcTotal()
    {
        //TODO
        //CALCULATE THE TOTAL
        //STORE IT IN total VARIABLE
    }

    public String toString()
    {
        NumberFormat nf = NumberFormat.getCurrencyInstance();

        String result = "";

        result += "CASHIER @ REGISTER\n " + orderClerk.getFirstName() + " " + orderClerk.getLastName() + " @ " + orderClerk.getRegisterNbr() + "\n\n";

        //TODO
        //ADD REST OF SUMMARY TO RESULT
        //SEE LINE ABOVE FOR EXAMPLE OF HOW TO GET INFORMATION FROM 
        //OTHER OBJECTS THAT ARE AVAILABLE WITHIN THE ORDER CLASS
        //SEE PROJECT HANDOUT TO GET IDEA OF HOW YOUR SUMMARY SHOULD LOOK LIKE
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

}
