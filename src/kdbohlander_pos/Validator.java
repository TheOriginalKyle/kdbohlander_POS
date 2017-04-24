package kdbohlander_pos;

import javax.swing.JOptionPane;

public class Validator
{

    public static String getValidFirstName(String anInput)
    {
        if (isValidFirstName(anInput) != false) //Its false by default see isValidFirstName for further details.
        {
            return anInput;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Name CANNOT be blank!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return getValidFirstName(JOptionPane.showInputDialog("Enter First Name")); //This seemed easier than having it retry in the main class.
        }
    }

    public static String getValidLastName(String anInput)
    {
        if (isValidLastName(anInput) != false)
        {
            return anInput;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Name CANNOT be blank!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return getValidLastName(JOptionPane.showInputDialog("Enter Last Name"));
        }
    }

    public static String getValidStreet(String anInput)
    {
        if (isValidStreet(anInput) != false)
        {
            return anInput;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Street CANNOT be blank!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return getValidStreet(JOptionPane.showInputDialog("Enter Street"));
        }
    }

    public static String getValidCity(String anInput)
    {
        if (isValidCity(anInput) != false)
        {
            return anInput;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "City CANNOT be blank!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return getValidCity(JOptionPane.showInputDialog("Enter City"));
        }
    }

    public static String getValidState(String anInput)
    {
        if (isValidState(anInput) != false)
        {
            return anInput;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid Format! Must be in format 'CA'!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return getValidState(JOptionPane.showInputDialog("Enter State"));
        }
    }

    public static String getValidZip(String anInput)
    {
        if (isValidZip(anInput) != false)
        {
            return anInput;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid Format! Must be in format '90210'!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return getValidZip(JOptionPane.showInputDialog("Enter Zip"));
        }
    }

    public static String getValidPhone(String anInput)
    {
        if (isValidPhone(anInput) != false)
        {
            
            return anInput.replaceFirst("(\\d{3})[-]?(\\d{3})[-]?(\\d{4})", "($1)$2-$3"); //Will reformat your valid number to something more readable
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid Format! Must be in format '(123)123-1234'.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return getValidPhone(JOptionPane.showInputDialog("Enter Phone"));
        }
    }

    public static String getValidMembership(String anInput)
    {
        if (isValidMembership(anInput) != false)
        {
            return anInput;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid Format! Must be in format 'MT1234'.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return getValidMembership(JOptionPane.showInputDialog("Enter Membership ID"));
        }
    }

    public static String getValidQuantity(String anInput)
    {
        if (isValidQuantity(anInput) != false)
        {
            return anInput;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid number, must be between 1 and 10.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return getValidQuantity(JOptionPane.showInputDialog("Enter Quantity"));
        }
    }

    private static boolean isValidFirstName(String anInput)
    {
        boolean result = false;
        //anInput.matches checks that anInput contains at least one or more non-whitespace character
        if (anInput != null && anInput.matches("([\\S])+(.)+"))
        {
            result = true;
        }
        return result;
    }

    private static boolean isValidLastName(String anInput)
    {
        boolean result = false;

        if (anInput != null && anInput.matches("([\\S])+(.)+")) //Same Regex as isValidFirstName
        {
            result = true;
        }
        return result;
    }

    private static boolean isValidStreet(String anInput)
    {
        boolean result = false;

        if (anInput != null && anInput.matches("([\\S])+(.)+"))
        {
            result = true;
        }
        return result;
    }

    private static boolean isValidCity(String anInput)
    {
        boolean result = false;

        if (anInput != null && anInput.matches("([\\S])+(.)+"))
        {
            result = true;
        }
        return result;
    }

    private static boolean isValidState(String anInput)
    {
        boolean result = false;

        if (anInput != null && anInput.matches("[a-zA-Z][a-zA-Z]")) //This Regex will match any two letter combination Ex. CA or ca or cA etc.
        {
            result = true;
        }
        return result;
    }

    private static boolean isValidZip(String anInput)
    {
        boolean result = false;

        if (anInput != null && anInput.matches("\\d{5}")) //Regex will match any 5 digit(0-9) number ex. 555555 but not 555-55
        {
            result = true;
        }
        return result;
    }

    private static boolean isValidPhone(String anInput)
    {
        boolean result = false;

        //This Regex will match any of the following formats: '555 555 5555', '(555)555-5555', '555-555-5555', '5555555555' with any 0-9 digit.
        if (anInput != null && anInput.matches("[(]?(\\d{3})[-)\\s]?(\\d{3})[-\\s]?(\\d{4})"))
        {
            result = true;
        }
        return result;
    }

    private static boolean isValidMembership(String anInput)
    {
        boolean result = false;

        if (anInput != null && anInput.matches("^[a-zA-Z]{2}\\d{4}")) //Regex will match any string that begins with any two characters and ends with 4 digits.
        {
            result = true;
        }
        return result;
    }

    private static boolean isValidQuantity(String anInput)
    {
        boolean result = false;

        if (anInput != null && anInput.matches("[1-9]|10")) //Regex will match any string that contains 1-9 or 10
        {
            result = true;
        }
        return result;
    }
}
