package kdbohlander_pos;

import javax.swing.JOptionPane;

public class Validator
{

    //TODO - CODE THE VALIDATOR
    public static String getValidFirstName(String anInput)
    {
        if(isValidFirstName(anInput) != false)
            return anInput;
        else
        {
            JOptionPane.showMessageDialog(null, "Name CANNOT be blank!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return getValidFirstName(JOptionPane.showInputDialog("Enter First Name"));
        }
    }

    public static String getValidLastName(String anInput)
    {
        if(isValidLastName(anInput) != false)
            return anInput;
        else
        {
            JOptionPane.showMessageDialog(null, "Name CANNOT be blank!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return getValidLastName(JOptionPane.showInputDialog("Enter Last Name"));
        }
    }

    public static String getValidStreet(String anInput)
    {
        if(isValidStreet(anInput) != false)
            return anInput;
        else
        {
            JOptionPane.showMessageDialog(null, "Street CANNOT be blank!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return getValidStreet(JOptionPane.showInputDialog("Enter Street"));
        }
    }

    public static String getValidCity(String anInput)
    {
        if(isValidCity(anInput) != false)
            return anInput;
        else
        {
            JOptionPane.showMessageDialog(null, "City CANNOT be blank!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return getValidCity(JOptionPane.showInputDialog("Enter City"));
        }
    }

    public static String getValidState(String anInput)
    {
        if(isValidState(anInput) != false)
            return anInput;
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid Format! Must be in format 'CA'!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return getValidState(JOptionPane.showInputDialog("Enter State"));
        }
    }

    public static String getValidZip(String anInput)
    {
        if(isValidZip(anInput) != false)
            return anInput;
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid Format! Must be in format '90210'!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return getValidZip(JOptionPane.showInputDialog("Enter Zip"));
        }
    }

    public static String getValidPhone(String anInput)
    {
        if(isValidPhone(anInput) != false)
            return anInput;
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid Format! Must be 10 digits (No Characters).", "ERROR", JOptionPane.ERROR_MESSAGE);
            return getValidPhone(JOptionPane.showInputDialog("Enter Phone"));
        }
    }

    public static String getValidMembership(String anInput)
    {
        if(isValidMembership(anInput) != false)
            return anInput;
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid Format! Must contain 2 Characters and 4 numbers! Ex. MT1234", "ERROR", JOptionPane.ERROR_MESSAGE);
            return getValidMembership(JOptionPane.showInputDialog("Enter Membership ID"));
        }
    }
    
    public static String getValidQuantity(String anInput)
    {
        if(isValidQuantity(anInput) != false)
            return anInput;
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid number, must be between 1 and 10.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return getValidQuantity(JOptionPane.showInputDialog("Enter Quantity"));
        }
    }

    private static boolean isValidFirstName(String anInput)
    {
        boolean result = false;
        
        if(anInput != null && anInput.matches("(\\S)+")) //anInput.matches checks that anInput contains at least one non-whitespace character
        {
            result = true;
        }
        return result;
    }

    private static boolean isValidLastName(String anInput)
    {
        boolean result = false;
        
        if(anInput != null && anInput.matches("(\\S)+")) //Same Regex as isValidFirstName
        {
            result = true;
        }
        return result;
    }

    private static boolean isValidStreet(String anInput)
    {
        boolean result = false;
        
        if(anInput != null && anInput.matches("(\\S)+"))
        {
            result = true;
        }
        return result;
    }

    private static boolean isValidCity(String anInput)
    {
        boolean result = false;
        
        if(anInput != null && anInput.matches("(\\S)+"))
        {
            result = true;
        }
        return result;
    }

    private static boolean isValidState(String anInput)
    {
        boolean result = false;
        
        if(anInput != null && anInput.matches("[a-zA-Z][a-zA-Z]")) //This Regex will match any two letter combination Ex. CA or ca or cA etc.
        {
            result = true;
        }
        return result;
    }

    private static boolean isValidZip(String anInput)
    {
        boolean result = false;
        
        if(anInput != null && anInput.matches("\\d{5}")) //Regex will match any 5 digit(0-9) number ex. 555555 but not 555-55
        {
            result = true;
        }
        return result;
    }

    private static boolean isValidPhone(String anInput)
    {
       boolean result = false;
        
        if(anInput != null && anInput.matches("\\d{10}")) //Regex will match any 10 digit number (cannot have spaces or dashes).
        {
            result = true;
        }
        return result;
    }

    private static boolean isValidMembership(String anInput)
    {
        boolean result = false;
        
        if(anInput != null && anInput.matches("^[a-zA-Z]{2}\\d{4}")) //Regex will match any string that begins with any two characters and ends with 4 digits.
        {
            result = true;
        }
        return result;
    }
    private static boolean isValidQuantity(String anInput)
    {
        boolean result = false;
        
        if(anInput != null && anInput.matches("[1-9]|10")) //Regex will match any string that contains 1-9 or 10
        {
            result = true;
        }
        return result;
    }
}
