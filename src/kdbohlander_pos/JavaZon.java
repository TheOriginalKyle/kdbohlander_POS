package kdbohlander_pos;

import java.util.concurrent.ThreadLocalRandom;

public class JavaZon
{

    private Clerk[] arrClerks;
    private Order jvzOrder;

    //CLASS CONSTRUCTOR
    public JavaZon()
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
        jvzOrder.calcSubtotal();
        jvzOrder.calcTax();
        jvzOrder.calcTotal();
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
    }

    //METHOD TO SET A CLERK TO THE ORDER
    public void setClerk()
    {
        int i = ThreadLocalRandom.current().nextInt(0, 3); //Went with this instead it seemed easier ¯\_(ツ)_/¯ 
        jvzOrder.setOrderClerk(arrClerks[i]); //Note ThreadLocalRandom depends upon Java 1.7 or later so yea hopefully you have that.
    }

    //RETURN RECEIPT
    public String getReceipt()
    {
        String result;

        result = "JAVAZON WHOLESALE STORE\n\n";

        result += "90404 CENTRAL AVE\n";
        result += "MONTCLAIR, CA, 91763\n";
        result += "  (909)345-9876\n\n";

        result += jvzOrder.toString(); //This is in the Order class it DOES NOT convert jvzOrder to a string

        return result;

    }
}
