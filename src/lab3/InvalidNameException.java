package lab3;

/**
 *
 * @author Instlogin
 */
public class InvalidNameException extends Exception {
    private static final String ERR_MSG =
            "Sorry, you must provide both a first name and a last name. "
            + "Please try again.";
    

    public InvalidNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNameException(String message) {
        super(message);
    }

    public InvalidNameException() {
        super(ERR_MSG);
    }


    
}
