package tasks;

import java.util.Scanner;
import static java.lang.System.exit;

/**
 * This class is signing in any user/owner that already signed up.
 *
 * @author Mohamed Saeed Ahmed and Nada Khaled
 * @version 1.0
 * @since 9 June 2021
 */
public class SignIn implements Register {
    /**
     * user a User object to link all system together
     */
    public User user;
    /**
     * owner an Owner object to link all system together
     */
    public Owner owner;
    /**
     * choice static field to know whether it is a user or an owner
     * */
    public static int choice = 0;
    /**
     *check_in static int to check if the information is valid or not
     */
    public static int check_in = 0;
    /**
     * counter static int that loops around the arrays
     */
    public static int counter=-1;

    Scanner input = new Scanner(System.in);

    /**
     * Parameterized constructor
     * @param objectUser assign objectUser to user
     * @param objectOwner assign objectOwner to owner
     */
    public SignIn(User objectUser, Owner objectOwner) {
        this.user = objectUser;
        this.owner = objectOwner;
    }

    /**
     * sign SignUp object that sets the user and owner to get access of both of them
     */
    public SignUp sign = new SignUp(this.user,this.owner);

    /**
     * Display menu of options
     */
    @Override
    public void displayMenu() {
        System.out.println("Are you a user or owner? ");
        System.out.println("1-User 2- Owner");
        choice = input.nextInt();

        if (choice == 1) {
            inUser(user);
        } else {
            inOwner(owner);
        }
    }
    /**
     * Take information from a user and store it as a user object
     * @param user an attribute used to use setEmail and setPassword
     * @return user
     */
    public User inUser(User user) {
        System.out.println("Enter your email");
        input.nextLine();
        String email = input.nextLine();
        user.setEmail(email);

        System.out.println("Enter your password");
        String password = input.nextLine();
        user.setPassword(password);

        for (int i = 0; i < SignUp.users.size(); i++) {
            if (user.getEmail() != SignUp.users.get(i).getEmail() &&
                    user.getPassword() != SignUp.users.get(i).getPassword())
                continue;
            else {
                check_in = 1;
                break;
            }
        }
        if (check_in == 0) {
            System.out.println("Account Not Found");
            exit(0);
        }

        return user;
    }
    /**
     * Take information from an owner and stores it in the form of an owner object
     * @param owner an attribute used to use setEmail and setPassword
     * @return owner
     */
    public Owner inOwner(Owner owner) {

        System.out.println("Enter your email");
        input.nextLine();
        String email = input.nextLine();
        owner.setEmail(email);

        System.out.println("Enter your password");
        String password = input.nextLine();
        owner.setPassword(password);

        for (int i = 0; i < SignUp.owners.size(); i++) {
            if (owner.getEmail() != SignUp.owners.get(i).getEmail() &&
                    owner.getPassword() != SignUp.owners.get(i).getPassword())
                continue;
            else {
                check_in = 1;
                break;
            }
        }

        if (check_in == 0)
        {
            System.out.println("Account Not Found");
            exit(0);
        }
        return owner;

    }
    /**
     * To check on validation
     * @return true
     */

    @Override
    public boolean validInformation() {
        return false;
    }
    /**
     * To to set information
     */

    @Override
    public void setInformation() {

    }
}
