/*This class is to verify user login to student management system
User has 3 attempts to successfully login
Username and password entered is checked against username/passwords in users.txt
If a match is found, then login successful and user can access student management system*/

import java.io.File;
import java.util.*;

public class Login {

    private Scanner in = new Scanner(System.in);
    private String username;
    private String password;
    private int numAttempts = 3;
    private String filePath = "users.txt";

    public void startLogin() {

        System.out.println("Welcome to EduAssist!");
        System.out.println("--------------------------");

        while(numAttempts > 0) {
            System.out.print("\tEnter Username: ");
            this.username = in.nextLine();
            System.out.print("\tEnter Password: ");
            this.password = in.nextLine();

            /*Break from loop if username/password match found
            Access to student management system allowed after loop break*/
            if(verifyLogin(username, password, filePath) == true) {
                System.out.println("\n\t# Welcome " + username + "! # ");
                break;
            }
            /*If no username/password match then number of attempts allowed goes down by one
            After user fails 3 attempts, program will exit*/
            else {
                numAttempts--;
                if (numAttempts == 0) {
                    System.out.println("\n\tYou have exceeded your number of attempts to login.");
                    System.out.println("\tPlease contact your system administrator for further assistance.");
                    System.out.println("\tGoodbye.");
                    System.exit(0);
                }
                else {
                    System.out.println("\n\tIncorrect Username and Password. Try Again.");
                    if (numAttempts == 1) {
                        System.out.println("\tYou have " + numAttempts + " more attempt.");
                    }
                    else {
                        System.out.println("\tYou have " + numAttempts + " more attempts.");
                    }
                }
            }
        }
    }

    //Search for username/password match in users.txt file
    private static boolean verifyLogin(String username, String password, String filePath) {
        boolean matchFound = false; //Only perform search while match hasn't been found yet
        String searchUsername;
        String searchPassword;
        Scanner s;

        try {
            s = new Scanner(new File(filePath));
            s.useDelimiter("[,\n]");

            while(s.hasNext() && !matchFound) {
                searchUsername = s.next();
                searchPassword = s.next();

                if(searchUsername.trim().equals(username.trim()) && searchPassword.trim().equals(password.trim())) {
                    matchFound = true;
                }

            }
            s.close();
        }
        catch(Exception e) {
            System.out.println("Error");
        }

        return matchFound;
    }
}

