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

            if(verifyLogin(username, password, filePath) == true) {
                System.out.println("\n\t# Welcome " + username + "! # ");
                break;
            }
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

    private static boolean verifyLogin(String username, String password, String filePath) {
        boolean found = false; //Only perform search while match hasn't been found yet
        String searchUsername;
        String searchPassword;
        Scanner s;

        try {
            s = new Scanner(new File(filePath));
            s.useDelimiter("[,\n]");

            while(s.hasNext() && !found) {
                searchUsername = s.next();
                searchPassword = s.next();

                if(searchUsername.trim().equals(username.trim()) && searchPassword.trim().equals(password.trim())) {
                    found = true;
                }

            }
            s.close();
        }
        catch(Exception e) {
            System.out.println("Error");
        }

        if(found == true) {
            return true;
        }
        else {
            return false;
        }
    }
}

