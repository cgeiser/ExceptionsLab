package lab4;

import javax.swing.JOptionPane;

/**
 * This class is responsible for all input and output in the program.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class InputOutputGui {
    private NameService nameService;
    private boolean valid;
    private String fullName = null, exMsg = null;
    private Exception ine;

    public InputOutputGui() {
        nameService = new NameService();
    }

    public void startConversation()  {
        
        do {
            try {
                fullName = JOptionPane.showInputDialog("Enter your full name:").trim();
                if (fullName == null || fullName.length() == 0) {
                    exMsg = "Please make an entry.\nTry again...";
                    throw new InvalidNameException(exMsg);
                }
                if (!fullName.contains(" ")) {
                    exMsg = "Please enter your first AND last names.\nTry again...";
                    throw new InvalidNameException(exMsg);
                }
                if (fullName.indexOf(" ") != fullName.lastIndexOf(" ")) {
                    exMsg = "Please enter only your first and last names.\nTry again...";
                    throw new InvalidNameException(exMsg);
                }
                valid = true;
            } catch (InvalidNameException ine) {
                this.ine = ine;
                JOptionPane.showMessageDialog(null, ine.getMessage(), "Entry Error", JOptionPane.ERROR_MESSAGE);
                valid = false;
            } finally {
                if (!valid) {
                System.out.println("Exception thrown: " + ine.getMessage()); }
                else {System.out.println("No exception was thrown.");
                }
            }
        } while (valid == false);
        
        String firstName = nameService.extractFirstName(fullName);
        String lastName = nameService.extractLastName(fullName);
        String msg = "Your last name is: " + lastName +
                "\nYour first name is: " + firstName;
        JOptionPane.showMessageDialog(null, msg);
        
    }
     
}
