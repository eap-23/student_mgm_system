/*This class is for error catching methods
Methods are used when user prompted for input and integer is expected
Method overloading used to alter method depending on need*/

import java.util.InputMismatchException;
import java.util.Scanner;

public final class Util {

    /*Version 1
    Catch error and print error message if user input is NOT an integer
    To be used when any number entered is valid*/
    public static int inputPrompt(String firstMessage, String errorMessage) {
        Scanner in = new Scanner(System.in);
        int input;

        //Always print first message. Proceed to error message if input mismatch
        try {
            System.out.print(firstMessage);
            input = in.nextInt();
        }
        catch (InputMismatchException e) {
            in.nextLine();

            /*Below code block will execute if string mismatch
            Keep printing error message while input mismatches*/
            while(true) {
                try {
                    System.out.print(errorMessage);
                    input = in.nextInt();
                    break;
                }
                catch (InputMismatchException e2) {
                    in.nextLine();
                }
            }
        }

        return input;
    }

    /*Version 2
    Catch error and print error message if user input is NOT an integer
    To be used when there is a max integer valid number
    Use this version when user has a 0 to quit option*/
    public static int inputPrompt(String firstMessage, String errorMessage, int maxInputNum) {
        Scanner in = new Scanner(System.in);
        int input = 0;

        //Always print first message. Proceed to error message if input mismatch
        try {
            System.out.print(firstMessage);
            input = in.nextInt();
        } catch (InputMismatchException e) {
            in.nextLine();
        }

        /*Below code block will execute if string mismatch or input greater than max input allowed
        /Keep printing error message while input mismatches*/
        while (input > maxInputNum) {
            try {
                System.out.print(errorMessage);
                input = in.nextInt();
                in.nextLine();
            }
            catch (InputMismatchException e) {
                in.nextLine();
            }
        }

        return input;
    }

    /*Version 3
    Catch error and print error message if user input is NOT an integer
    To be used when there is a max integer and minimum integer value
    Use this version when there is no 0 option to quit*/
    public static int inputPrompt(String firstMessage, String errorMessage, int minInputNum, int maxInputNum) {
        Scanner in = new Scanner(System.in);
        int input = 0;

        //Always print first message. Proceed to error message if input mismatch
        try {
            System.out.print(firstMessage);
            input = in.nextInt();
        }
        catch (InputMismatchException e) {
            in.nextLine();
        }

        /*Below code block will execute if string mismatch or input not within accepted range
        /Keep printing error message while input mismatches*/
        while (input < minInputNum || input > maxInputNum) {
            try {
                System.out.print(errorMessage);
                input = in.nextInt();
                in.nextLine();
            }
            catch (InputMismatchException e) {
                in.nextLine();
            }
        }

        return input;
    }
}

