package kdbohlander_pos;

import javax.swing.JOptionPane;

public class Validator
{

    public static String getValidFirstName(String anInput)
    {
        if (isValidName(anInput) != false) //Its false by default see isValidFirstName for further details.
        {
            return anInput.trim(); //Trims the data so itll look perdier.
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Name CANNOT be blank!", "ERROR", JOptionPane.ERROR_MESSAGE); //Tells you you screwed up.
            return getValidFirstName(JOptionPane.showInputDialog("Enter First Name")); //This seemed easier than having it retry in the main class.
        }
    }

    public static String getValidLastName(String anInput)
    {
        if (isValidName(anInput) != false)
        {
            return anInput.trim();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Name CANNOT be blank!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return getValidLastName(JOptionPane.showInputDialog("Enter Last Name"));
        }
    }

    public static String getValidStreet(String anInput)
    {
        if (isValidName(anInput) != false)
        {
            return anInput.trim().toUpperCase();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Street CANNOT be blank!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return getValidStreet(JOptionPane.showInputDialog("Enter Street"));
        }
    }

    public static String getValidCity(String anInput)
    {
        if (isValidName(anInput) != false)
        {
            return anInput.trim().toUpperCase();
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
            return anInput.trim().toUpperCase();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid Format! Must be in format 'CA'!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return getValidState(JOptionPane.showInputDialog("Enter State 'CA'"));
        }
    }

    public static String getValidZip(String anInput)
    {
        if (isValidZip(anInput) != false)
        {
            return anInput.trim();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid Format! Must be in format '90210'!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return getValidZip(JOptionPane.showInputDialog("Enter Zip '90210'"));
        }
    }

    public static String getValidPhone(String anInput)
    {
        if (isValidPhone(anInput) != false)
        {
            //Will reformat your valid number to something more readable with a RegEx. If it fails it'll save it as is so no harm done. ¯\_(ツ)_/¯ 
            return anInput.trim().replaceFirst("[(]?(\\d{3})[-\\s)]?(\\d{3})[-\\s]?(\\d{4})", "($1)$2-$3");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid Format! Must be in format '(123)123-1234'.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return getValidPhone(JOptionPane.showInputDialog("Enter Phone '(123)123-1234'"));
        }
    }

    public static String getValidMembership(String anInput)
    {
        if (isValidMembership(anInput) != false)
        {
            return anInput.trim().toUpperCase();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid Format! Must be in format 'MT1234'.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return getValidMembership(JOptionPane.showInputDialog("Enter Membership ID 'MT1234'"));
        }
    }

    public static String getValidQuantity(String anInput)
    {
        if (isValidQuantity(anInput) != false)
        {
            return anInput.trim();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid number, must be between 1 and 10.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return getValidQuantity(JOptionPane.showInputDialog("Enter Quantity"));
        }
    }

    private static boolean isValidName(String anInput)
    {
        boolean result = false;

        //trims off any leading or ending spaces then matches it against a RegExp.
        //This particular regex matches anything with at least one non-whitespace character.
        //Ex. 'Kyle', 'Kyle Bohlander', 'K Y L E' but will not match ' '
        if (anInput != null && anInput.trim().matches("[\\S].+?"))
        {
            result = true;
        }
        if (anInput == null)
        {
            quitConfirm(anInput); //If the input is null the user hit 'Cancel' so this will ask the user if they want to end the program.
        }
        return result;
    }

    private static boolean isValidState(String anInput)
    {
        boolean result = false;

        //This Regex will match any two letter combination Ex. 'CA' or 'ca' or 'cA' but not 'C A'
        if (anInput != null && anInput.trim().matches("[a-zA-Z]{2}"))
        {
            result = true;
        }
        if (anInput == null)
        {
            quitConfirm(anInput);
        }
        return result;
    }

    private static boolean isValidZip(String anInput)
    {
        boolean result = false;

        //Regex will match any 5 digit(0-9) number ex. 555555 but not 555-55
        if (anInput != null && anInput.trim().matches("\\d{5}"))
        {
            result = true;
        }
        if (anInput == null)
        {
            quitConfirm(anInput);
        }
        return result;
    }

    private static boolean isValidPhone(String anInput)
    {
        boolean result = false;

        //This Regex will match any of the following formats: '555 555 5555', '(555)555-5555', '555-555-5555', '5555555555' with any 0-9 digit.
        if (anInput != null && anInput.trim().matches("[(]?(\\d{3})[-)\\s]?(\\d{3})[-\\s]?(\\d{4})"))
        {
            result = true;
        }
        if (anInput == null)
        {
            quitConfirm(anInput);
        }
        return result;
    }

    private static boolean isValidMembership(String anInput)
    {
        boolean result = false;

        //Regex will match any string that begins with any two characters and ends with 4 digits.
        if (anInput != null && anInput.trim().matches("[a-zA-Z]{2}\\d{4}"))
        {
            result = true;
        }
        if (anInput == null)
        {
            quitConfirm(anInput);
        }
        return result;
    }

    private static boolean isValidQuantity(String anInput)
    {
        boolean result = false;

        //Regex will match any string that contains 1-9 or 10 ex. '9' but not 'nine' or '9a' or '910'
        if (anInput != null && anInput.trim().matches("[1-9]|10"))
        {
            result = true;
        }
        if (anInput == null)
        {
            quitConfirm(anInput);
        }
        return result;
    }

    private static boolean quitConfirm(String anInput)
    {
        //Exits the program if you confirm you want to cancel. I got annoyed with being forced into completting the whole program
        //when all I wanted to do was test 1 thing. I'm also 99% sure I don't need to require anInput but I do need some sort of string.

        boolean result = false;

        if (JOptionPane.showConfirmDialog(null, "Are you sure you want to Quit?", anInput, 0) == 0)
        {
            //This will exit the program so no return is actually necessary.
            System.exit(0);
        }

        //It returns false so you can re-enter whatever still needed to be filled in.
        return result;
    }
}
