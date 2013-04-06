package lab1;

import javax.swing.JOptionPane;

/**
 * The purpose of this challenge is to give you practice time using
 * Java Exception handling techniques.
 * <p>
 * Your challenge is to consider all the possible things that can go wrong
 * with this program and use exception handling where appropriate to prevent
 * the program from crashing. In addition you must display a friendly error
 * message in a JOptionPane and ask the user to try again.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Challenge1 {

    public static void main(String[] args) {
        Challenge1 app = new Challenge1();
        boolean valid;
        String fullName = null;
        String lastName;
        String exMsg = null;
        
        do {
            try {
                fullName = JOptionPane.showInputDialog("Enter full name:").trim();
                if (fullName == null || fullName.length() == 0) {
                    exMsg = "Please make an entry.\nTry again...";
                    throw new IllegalArgumentException(exMsg);
                }
                if (!fullName.contains(" ")) {
                    exMsg = "Please enter your FULL name.\nTry again...";
                    throw new IllegalArgumentException(exMsg);
                }
                valid = true;
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null, iae.getMessage(), "Entry Error", JOptionPane.ERROR_MESSAGE);
                valid = false;
            }
        }
        while (valid == false);
        
        lastName = app.extractLastName(fullName);
        String msg = "Your last name is: " + lastName;
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public String extractLastName(String fullName) {
        if (fullName.contains(", ")) {
            return fullName.substring(0, fullName.indexOf(", "));
        }
        String[] nameParts = fullName.split(" ");
        return nameParts[nameParts.length-1];
    }

}
