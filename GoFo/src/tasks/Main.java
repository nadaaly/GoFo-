package tasks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * CLASS MAIN THAT RUNS THE SYSTEM
 * @author Mohamed Saeed Ahmed and Nada Khaled Mohamed and Omar Hamed
 * @version 1.0
 * @since 9 June 2021
 */
public class Main {
    /**
     * class main that runs the program and throws the exception if any user/owner
      types in wrong date
     * @param args default arguments
     * @throws ParseException exception for invalid dates
     */
    public static void main(String[] args) throws ParseException {

        Scanner input = new Scanner(System.in);
        User user = new User();
        Owner owner = new Owner();
        SignIn signIn = new SignIn(user, owner);
        SignUp signUp = new SignUp(user, owner);
        owner = new Owner(signUp);
        user = new User(signUp, owner);
        Date t = new Date();
        ArrayList<Integer> confirm = new ArrayList<>();
        ArrayList<Date> times = new ArrayList<>();
        ArrayList<LocalTime> clock = new ArrayList<>();

        String name = "";
        String playgroundName = " ";
        Date date = new Date();
        int pricePerHour = 0;
        int p = 0;

        int confirmationNumber = 0;

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("1- SignUp  2- SignIn 3- Exit");
            int option = input.nextInt();

            if (option == 1) {
                signUp.displayMenu();
                if (SignUp.choice == 1 && SignUp.check == 1) {
                    System.out.println("...You are now booking a playground...");
                    date = null;
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    System.out.println("Enter date in this format \"dd/MM/yyyy\"");
                    input.nextLine();
                    String time = input.nextLine();
                    if (null != time && time.trim().length() > 0) {
                        date = format.parse(time);
                    }
                    System.out.println("Enter time in this format \"hh:mm:ss\"");
                    Scanner scan=new Scanner(System.in);
                    String time1=scan.next();  //default format: hh:mm:ss
                    LocalTime lt=LocalTime.parse(time1);

                    System.out.println("Enter the playground name");
                    playgroundName = input.nextLine();

                    System.out.println("Enter the desired playground price");
                    int price = input.nextInt();

                    input.nextLine();
                    user.playgrounds();

                    if (User.auth == 1) {
                        System.out.println("Choose suitable confirmation number for you ");
                        confirmationNumber = input.nextInt();
                    }
                    user.Booking(date,lt, playgroundName, price, confirmationNumber);

                    SignUp.choice = 0;
                    SignUp.check = 0;

                } else if (signUp.check == 1 && signUp.choice != 1) {
                    System.out.println("How many dates you want to enter?");
                    int datesTime = input.nextInt();
                    for (int i = 0; i < datesTime; i++) {
                        date = null;
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        System.out.println("Enter date in this format \"dd/MM/yyyy\"");
                        String time = in.nextLine();
                        if (null != time && time.trim().length() > 0) {
                            date = format.parse(time);

                            System.out.println("Enter time in this format \"hh:mm:ss\"");
                            Scanner scan=new Scanner(System.in);
                            String time1=scan.next();  //default format: hh:mm:ss
                            LocalTime lt=LocalTime.parse(time1);

                            times.add(date);
                            clock.add(lt);
                            confirmationNumber = (int) (5 + (Math.random() * 100));
                            confirm.add(confirmationNumber);
                        }
                    }
                    SignIn.counter++;
                    System.out.println("Enter playground name");
                    playgroundName = in.nextLine();
                    signUp.owners.get(SignIn.counter).setPlaygroundName(playgroundName);
                    name = signUp.owners.get(SignIn.counter).getPlaygroundName();

                    System.out.println("Enter price per hour");
                    pricePerHour = input.nextInt();

                    signUp.owners.get(SignIn.counter).setpricePerHour(pricePerHour);
                    p = signUp.owners.get(SignIn.counter).getpricePerHour();
                    owner.addPlayground(name, times,clock, p, confirm);

                    SignUp.choice = 0;
                    SignUp.check = 0;
                }

            } else if (option == 2) {
                signIn.displayMenu();
                if (SignIn.choice == 1 && SignIn.check_in == 1) {
                    System.out.println("...You are now booking a playground...");
                    date = null;
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    System.out.println("Enter date in this format \"dd/MM/yyyy\"");
                    input.nextLine();
                    String time = input.nextLine();
                    if (null != time && time.trim().length() > 0) {
                        date = format.parse(time);
                    }
                    System.out.println("Enter time in this format \"hh:mm:ss\"");
                    Scanner scan=new Scanner(System.in);
                    String time1=scan.next();  //default format: hh:mm:ss
                    LocalTime lt=LocalTime.parse(time1);

                    System.out.println("Enter the playground name");
                    playgroundName = input.nextLine();

                    System.out.println("Enter the desired playground price");
                    int price = input.nextInt();

                    input.nextLine();
                    user.playgrounds();
                    if (User.auth == 1) {
                        System.out.println("Choose suitable confirmation number for you ");
                        confirmationNumber = input.nextInt();
                    }
                    user.Booking(date, lt, playgroundName, price, confirmationNumber);

                    SignIn.choice = 0;
                    SignIn.check_in = 0;

                } else if (SignIn.choice != 1 && SignIn.check_in == 1) {
                    System.out.println("How many dates you want to enter?");
                    int datesTime = input.nextInt();
                    for (int i = 0; i < datesTime; i++) {
                        date = null;
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        System.out.println("Enter date in this format \"dd/MM/yyyy\"");
                        String time = in.nextLine();
                        if (null != time && time.trim().length() > 0) {
                            date = format.parse(time);

                            System.out.println("Enter time in this format \"hh:mm:ss\"");
                            Scanner scan=new Scanner(System.in);
                            String time1=scan.next();  //default format: hh:mm:ss
                            LocalTime lt=LocalTime.parse(time1);

                            times.add(date);
                            clock.add(lt);
                            confirmationNumber = (int) (5 + (Math.random() * 100));
                            confirm.add(confirmationNumber);
                        }
                    }
                    SignIn.counter++;
                    System.out.println("Enter playground name");
                    playgroundName = in.nextLine();
                    signUp.owners.get(SignIn.counter).setPlaygroundName(playgroundName);
                    name = signUp.owners.get(SignIn.counter).getPlaygroundName();

                    System.out.println("Enter price per hour");
                    pricePerHour = input.nextInt();

                    signUp.owners.get(SignIn.counter).setpricePerHour(pricePerHour);
                    p = signUp.owners.get(SignIn.counter).getpricePerHour();
                    owner.addPlayground(name, times,clock, p, confirm);

                    SignIn.choice = 0;
                    SignIn.check_in = 0;
                }

            } else if (option == 3) {
                System.out.println("Exit...");
                break;
            } else
                System.out.println("Wrong option !!");

            if (option == 3) {
                break;
            } else {
                continue;
            }
        }

    }
}