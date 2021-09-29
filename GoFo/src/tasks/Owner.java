package tasks;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * The owner class stores the owner information as well as accesssing the owner
            to add in their playgrounds with available time slots.
 * @author Nada Khaled Mohamed and Mohamed Saeed Ahmed
 * @version 1.0
 * @since 9 June 2021
 */
public class Owner implements People{

    private String email;
    private String password;
    private int phone;
    private String name;
    private String location;
    private int pricePerHour;
    private int ID;
    private String playgroundName;
    /**
     * signUp it is a SignUp object to get all the owners' that have registered
     */
    public SignUp signUp;
    private int playgroundSize;

    /**
     * confirmationNumber arrayList that stores all confirmation number that are associated with every time of the playground
     */
    private ArrayList<Integer> confirmationNumber;
    /**
     * time ArrayList that stores multiple dates of the playground
     */
    private ArrayList<Date> time;

    /**
     * time ArrayList that stores multiple time of the playground
     */
    private ArrayList<LocalTime> clock;
    /**
     * playground ArrayList that stores all the playgrounds so we can access them
     */
    public ArrayList<ArrayList> playground = new ArrayList<>();
    /**
     * owners ArrayList that stores all the owners' information to be able
            to access them.
     */
    public ArrayList<Owner> owners = new ArrayList<>();

    Scanner input = new Scanner(System.in);

    /**
     * getter for password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * setter for password
     * @param password the owners' password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Default constructor
     */
    public Owner() {
    }

    /**
     * Parameterized constructor that sets the signUp object.
     * @param signUp an object from signUp class
     */
    public Owner(SignUp signUp) {
        this.signUp = signUp;
    }

    /**
     * getter for the ID
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     * getter for the playground name
     * @return playgroundName
     */
    public String getPlaygroundName() {
        return playgroundName;
    }

    /**
     * setter for playgroundName
     * @param playgroundName the owners' playground name
     */
    public void setPlaygroundName(String playgroundName) {
        this.playgroundName = playgroundName;

    }

    /**
     * getter for the playground size
     * @return playgroundSize
     */
    public int getPlaygroundSize() {
        return playgroundSize;
    }

    /**
     * setter for the playground size
     * @param playgroundSize the owners' playground Size
     */
    public void setPlaygroundSize(int playgroundSize) {
        this.playgroundSize = playgroundSize;
    }

    /**
     * setter for the ID
     * @param ID the owners' ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * getter for the price per hour
     * @return pricePerHour
     */
    public int getpricePerHour() {
        return pricePerHour;
    }

    /**
     * setter for pricePerHour
     * @param pricePerHour the owners' playground price hourly
     */
    public void setpricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    /**
     * getter for email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * setter for confirmation number
     * @param confirmationNumber the owners' confirmation number for every time slot
     */
    public void setCofirm(ArrayList<Integer> confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    /**
     * getter for confirmation number
     * @return confirmationNumber
     */
    public ArrayList<Integer> getConfirm() {
        return confirmationNumber;
    }

    /**
     * setter for time
     * @param time the owners' dates for the playground
     */
    public void setTime(ArrayList<Date> time) {
        this.time = time;
    }

    /**
     * getter for time
     * @return time
     */
    public ArrayList<Date> getTime() {
        return time;
    }

    /**
     * setter for time
     * @param clock the owners' times for the playground
     */
    public void setClock(ArrayList<LocalTime> clock) {
        this.clock = clock;
    }

    /**
     * getter for time
     * @return time
     */
    public ArrayList<LocalTime> getClock() {
        return clock;
    }

    /**
     * setter for email
     * @param email the owners' email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * getter for phone
     * @return phone
     */

    public int getPhone() {
        return phone;
    }

    /**
     * getter for location
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * setter for location
     * @param location the owners' location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * getter for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * setter for name
     * @param name the owners' name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setter for the owners' phone
     * @param phone the owners' phone
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * the function that helps the owner to addPlayground for the owner.
     * @param playgroundName
     * @param time
     * @param clock
     * @param pricePerHour
     * @param confirm
     */
    void addPlayground(String playgroundName, ArrayList<Date> time, ArrayList<LocalTime> clock, int pricePerHour, ArrayList<Integer> confirm) {
        System.out.println("Enter your ID");
        int id = input.nextInt();
        for (int i = 0; i < signUp.owners.size(); i++) {
            if (signUp.owners.get(i).getID() == id) {
                signUp.owners.get(i).setPlaygroundName(playgroundName);
                signUp.owners.get(i).setpricePerHour(pricePerHour);

                Owner owner = new Owner();
                owner.setPlaygroundName(signUp.owners.get(i).getPlaygroundName());
                owner.setpricePerHour(signUp.owners.get(i).getpricePerHour());
                owners.add(owner);
                playground.add(owners);
                playground.add(time);
                playground.add(clock);
                playground.add(confirm);
                System.out.println("Added success...");
            } else
                System.out.println("Wrong ID try again....");
        }

    }

    /**
     * not used at the moment but it is for displaying several tabs for the owner
     */
    @Override
    public void displayMenu() {

    }
    /**
     * not used at the moment but it returns true if the owner had gone through all the right steps
     */
    @Override
    public boolean successOperation() {
        return true;

    }
}
