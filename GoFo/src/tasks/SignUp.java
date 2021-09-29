package tasks;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is signing up any user/owner.
 *
 * @author Mohamed Saeed Ahmed and Nada Khaled
 * @version 1.0
 * @since 9 June 2021
 */
public class SignUp implements Register {
 /**
  * user a User object to link all system together
  */
 private  User user;
 /**
  * owner an Owner object to link all system together
  */
 private  Owner owner;
 /**
  * choice static field to know whether it is a user or an owner
  * */
 public static int choice = 0;
 /**
  * check static int to check if the information is valid or not
  */
 public static int check = 0;
 /**
  * users ArrayList to store all the users that have registered
  */
 public static ArrayList<User> users = new ArrayList<>();
 /**
  * owners ArrayList to store all the owners that have registered
  */
 public static ArrayList<Owner> owners = new ArrayList<>();

 Scanner input = new Scanner(System.in);

 /**
  * Parameterized constructor
  * @param objectUser assign objectUser to user
  * @param objectOwner assign objectOwner to owner
  */
 public SignUp(User objectUser, Owner objectOwner) {
  user = objectUser;
  owner = objectOwner;

 }
 /**
  * Display menu of options
  */
 @Override
 public void displayMenu() {
  System.out.println("Are you a user or owner? ");
  System.out.println("1-User 2- Owner");
  choice = input.nextInt();

  if (choice == 1) {
   upUser(user);
  } else {
   upOwner(owner);
  }
 }
 /**
  * Take information from a user and stores it in the form of a user object
  * @param user an attribute used to use setEmail/setPassword/setPhone/setId/
  *             setLocation
  * @return user
  */
 public User upUser(User user) {
  System.out.println("Enter your email");
  input.nextLine();
  String email = input.nextLine();
  user.setEmail(email);

  System.out.println("Enter your password");
  String password = input.nextLine();
  user.setPassword(password);

  System.out.println("Enter your phone");
  int phone = input.nextInt();
  user.setPhone(phone);

  System.out.println("Enter your ID");
  int iD = input.nextInt();
  user.setID(iD);

  System.out.println("Enter your Location");
  input.nextLine();
  String location = input.nextLine();
  user.setLocation(location);
  users.add(user);
  check = 1;
  return user;
 }

 /**
  * Take information from an owner and stores it in the form of an owner object
  * @param owner an attribute used to use setEmail/setPassword/setPhone/setId/
  *             setLocation
  * @return user
  */
 public Owner upOwner(Owner owner) {
  System.out.println("Enter your email");
  input.nextLine();
  String email = input.nextLine();
  owner.setEmail(email);

  System.out.println("Enter your password");
  String password = input.nextLine();
  owner.setPassword(password);

  System.out.println("Enter your phone");
  int phone = input.nextInt();
  owner.setPhone(phone);

  System.out.print("Your ID is : ");
  int id = (int) (100 + (Math.random() * 300));
  owner.setID(id);
  System.out.println(id);

  System.out.println("Enter your Location");
  input.nextLine();
  String location = input.nextLine();
  owner.setLocation(location);
  owners.add(owner);
  check = 1;

  return owner;

 }

 /**
  * To check on validation
  * @return true
  */
 @Override
 public boolean validInformation() {
  return true;
 }

 /**
  * To to set information
  */
 @Override
 public void setInformation() {

 }

}
