package in.prem.capp.exception;

public class UserBlockedException extends Exception{
    /**
     * Creates User object without error description.
     */ 
    // Constructor 1
    public UserBlockedException() {
    }
    /**
     * Creates User object with error description.
     */
    // Constructor 2
    public UserBlockedException(String errDesc) {
        super(errDesc);
    }    
}
