package kdbohlander_pos;

public class Kdbohlander_POS
{

    private Clerk[] arrClerks;
    private Order jvzOrder;

    //CLASS CONSTRUCTOR
    public Kdbohlander_POS()
    {
        loadClerkList();
    }

    //ASSIGN AN ORDER THROUGH SETTER
    public void setOrder(Order anOrder)
    {
        jvzOrder = anOrder;
    }

    //PROCESS ORDER
    public void processOrder()
    {
        //TODO CALL JVZ ORDER METHODS TO PERFORM CALCULATIONS
        //SUBTOTAL
        //TAX
        //TOTAL

    }

    //METHOD TO LOAD CLERKS
    public void loadClerkList()
    {
        arrClerks = new Clerk[3];
        Clerk musicClerk = new Clerk("EMP100", 1, "Homer", "Simpson", "243 North Main", "Spingfield", "CA", "98765", "909-987-6666");
        arrClerks[0] = musicClerk;
        Clerk bookClerk = new Clerk("EMP200", 2, "Bart", "Simpson", "454 North Euclid", "Spingfield", "CA", "98765", "909-987-4444");
        arrClerks[1] = bookClerk;
        Clerk gameClerk = new Clerk("EMP300", 3, "Lisa", "Simpson", "767 North Holt", "Spingfield", "CA", "98765", "909-987-3333");
        arrClerks[2] = gameClerk;

        //TODO 
        //ADD THESE CLERKS TO THE CLERK ARRAY
    }

    //METHOD TO SET A CLERK TO THE ORDER
    public void setClerk()
    {
        //TODO
        //Randomly assign a clerk to order using .setOrderClerk 
        //(see your textbook to see how to use the Random class to generate random numbers)
        //GenErate a random number between 0 and 2
        //use the number as the index of the clerk array 
        //add your code below

        //pass the clerk object to the setOrderClerk method OF THE JVZORDER 
        //add your code below
    }

    //RETURN RECEIPT
    public String getReceipt()
    {
        String result;

        result = "JAVAZON WHOLESALE STORE\n\n";

        result += "90404 CENTRAL AVE\n";
        result += "MONTCLAIR, CA, 91763\n";
        result += "  (909)345-9876\n\n";

        result += jvzOrder.toString();

        return result;

    }
}
