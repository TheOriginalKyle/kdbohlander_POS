package kdbohlander_pos;

import javax.swing.JOptionPane;

public class Kdbohlander_POS_APP
{

    public static void main(String[] args)
    {
        //COLLECT INFORMATION USING JOPTIONPANE
        String firstName = Validator.getValidFirstName(JOptionPane.showInputDialog("Enter First Name"));

        //Do the same for the other variables
        String lastName = "";
        String street = "";
        String city = "";
        String state = "";
        String zip = "";
        String phone = "";
        String membership = "";

        //CREATE A NEW CUSTOMER OBJECT (uncomment line below)
        Customer customer = new Customer(firstName, lastName, street, city, state, zip, phone, membership);

        //CREATE NEW ORDER OBJECT
        Order order = new Order();

        //SET ORDER CUSTOMER
        order.setOrderCustomer(customer);

        //LOOP TO COLLECT PRODUCTS SELECTED BY USER AND THEIR QUANTITIES
        do
        {
            //CREATE MENU OBJECT
            Menu menu = new Menu();

            //Get the items from the menu class, and load them into the
            //JOptionPane menu
            String menuItems[] = menu.getMenuDescriptions();

            int intCode = 0;
            intCode = JOptionPane.showOptionDialog(null, "Select an Option",
                    "Menu Items", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, menuItems, menuItems[0]);

            //RETURN PRODUCT FROM MENU
            Product product = menu.getMenu()[intCode];

            //PROMPT USER TO ENTER QUANTITY
            String qty = JOptionPane.showInputDialog("Enter Quantity");

            //ADD PRODUCT AND QUANTITY TO ORDER
            order.setOrderProduct(product, Integer.parseInt(qty));

        }
        while (JOptionPane.showConfirmDialog(null,
                "Enter More Products?",
                "User Selection",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null) != JOptionPane.NO_OPTION);

        //CREATE A NEW JAVAZON STORE
        Kdbohlander_POS jz = new Kdbohlander_POS();

        //ADD THE ORDER TO THE STORE
        jz.setOrder(order);

        //ASSIGN A CLERK TO THE ORDER
        jz.setClerk();

        //PROCESS ORDER
        jz.processOrder();

        //DISPLAY THE RESULT
        JOptionPane.showMessageDialog(null, jz.getReceipt());

    }

}
