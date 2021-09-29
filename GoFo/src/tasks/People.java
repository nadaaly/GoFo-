package tasks;

/**
 * interface for User and Owner classes
 */
public interface People {
    /**
     * A register object that links two classes together
     */
    public Register object = null;
    /**
     * overriden function in the other two classes
     */
    public void displayMenu();
    /**
     * overriden function in the other two classes
     * @return true
     */
    public boolean successOperation();
}
