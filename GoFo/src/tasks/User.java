package tasks;

import java.time.LocalTime;
import java.util.Date;

/**
 * This class is for storing all the users information and have the function
 * Booking that allows the user to book available stored playgrounds.
 *  @author Nada Khaled Mohamed and Mohamed Saeed Ahmed
 *  @version 1.0
 *  @since 9 June 2021
 */
public class User implements People {

    private String email;
    private String password;
    private int phone;
    private String name;
    private String location;
    private Date time;
    private int price;
    private int ID;
    private LocalTime localTime;
    /**
     * signUp a SignUp object to link the owners/users' information
     */
    public SignUp signUp;
    /**
     * owner an Owner object to link all system together
     */
    public Owner owner;
    /**
     * auth a static int that checks for the playgrounds' availability
     */
    public static int auth;

    /**
     * Default constructor
     */
    public User(){};

    /**
     * Parameterized constructor that gets the signUp and owner
     * @param signUp an object from SignUp class
     * @param owner an object from the Owner class
     */
    public User(SignUp signUp,Owner owner){
        this.signUp=signUp;
        this.owner =owner;
    }

    /**
     * getter for ID
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Setter for ID
     * @param ID the users' ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * getter for email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * setter for email
     * @param email the users' email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * getter for password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * setter for password
     * @param password the users' password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getter for time
     * @return time
     */
    public Date getTime() {
        return time;
    }

    /**
     * getter for price
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * setter for price
     * @param price the price the user requires
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * setter for time
     * @param time the time the user required
     */
    public void setTime(Date time) {
        this.time = time;
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
     * @param location the users' location
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
     * @param name the users' name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setter for phone
     * @param phone the users' phone
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * This function is for displaying all available playgrounds that are stored
            when registering an owner.
     */
    public void playgrounds() {
        System.out.println("*** Playgrounds ***");
        if (owner.owners.size() > 0) {
            for(int i=0;i<owner.playground.get(0).size();i++) {
                System.out.print("Playground's name :");
                System.out.println(owner.owners.get(i).getPlaygroundName());

                System.out.print("Playground's price :");
                System.out.println(owner.owners.get(i).getpricePerHour());

                for (int j = 0; j < owner.playground.get(1).size(); j++) {

                    System.out.println("Playground's slots time : ");
                    System.out.println(owner.playground.get(1).get(j) + " ");
                    System.out.println(owner.playground.get(2).get(j) + " ");
                    System.out.println("Playground's confirmation number in the order : ");
                    System.out.println(owner.playground.get(3).get(j) + " ");
                }
            }
            auth = 1;
            System.out.println("*******************************************************");
        }else{
            System.out.println("Empty...");
        }
    }

    /**
     * This function helps the user to book the playground (s)he requires according
            to the date,name,and price (s)he chooses
     * @param time the required date for booking
     * @param localTime   the required time for booking
     * @param name the name of the playground
     * @param price the price of the playground
     * @param confirmationNumber the confirmation number for booking the playground
     */
    public void Booking(Date time, LocalTime localTime, String name, int price, int confirmationNumber) {

        Integer obj = confirmationNumber;
        boolean found = false;
        for(int i=0;i<owner.playground.get(0).size();i++) {
            for(int j=0; j<owner.playground.get(1).size(); j++) {
                if (obj.equals(owner.playground.get(3).get(j))) {
                    found = true;
                    owner.playground.get(1).remove(owner.playground.get(1).get(j));
                    owner.playground.get(2).remove(owner.playground.get(2).get(j));
                    owner.playground.get(3).remove(owner.playground.get(3).get(j));
                    if(owner.playground.get(1).size()==0){
                        owner.playground.get(0).remove(j);
                        auth=0;
                    }
                    break;
                } else {
                    found = false;
                }
            }
        }

        if(found==true)
            System.out.println("Booked successfully");
        else
            System.out.println("Can't book the playground, try again");

    }
    /**
     * not used at the moment but it is for displaying several tabs for the user
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
