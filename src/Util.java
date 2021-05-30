import java.util.InputMismatchException;
import java.util.Scanner;

public final class Util {

    public static int inputPrompt(String firstMessage, String errorMessage) {
        Scanner in = new Scanner(System.in);
        int input;

        try {
            System.out.print(firstMessage);
            input = in.nextInt();
        }
        catch (InputMismatchException e) {
            in.nextLine();
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

    public static int inputPrompt(String firstMessage, String errorMessage, int maxInputNum) {
        Scanner in = new Scanner(System.in);
        int input = 0;

        try {
            System.out.print(firstMessage);
            input = in.nextInt();
        } catch (InputMismatchException e) {
            in.nextLine();
        }

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

    public static int inputPrompt(String firstMessage, String errorMessage, int minInputNum, int maxInputNum) {
        Scanner in = new Scanner(System.in);
        int input = 0;

        try {
            System.out.print(firstMessage);
            input = in.nextInt();
        }
        catch (InputMismatchException e) {
            in.nextLine();
        }

        //Below code block will execute if string mismatch or input not within accepted range
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

