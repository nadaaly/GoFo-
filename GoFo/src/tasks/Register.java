package tasks;

/**
 * interface for SignIn and SignUp class
 */
public interface Register {
    /**
     * function that returns true if the user entered the right email and password.
     * @return true
     */
    boolean validInformation();

    /**
     *  the user puts in their information.
     */
    void setInformation();

    /**
     * displays whether the person wants to be a user or an owner
     */
    void displayMenu();
}
