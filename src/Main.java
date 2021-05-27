import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Login newLogin = new Login();
        newLogin.startLogin();

        Scanner in = new Scanner(System.in);
        boolean running = true;
        List<Student> studentList = new ArrayList<>();
        List<Teacher> teacherList = new ArrayList<>();

        SYSTEM:
        while (running) {
            System.out.println("\n######### Main Menu ##########\n");

            System.out.println("\t1. Add New Students");
            System.out.println("\t2. Add New Teachers");
            System.out.println("\t3. Pay Teachers");
            System.out.println("\t4. Adjust Salaries");
            System.out.println("\t5. Check School Funds");
            System.out.println("\t6. Logout");

            int input = Util.inputPrompt("\nWhat would you like to do?: ",
                    "Invalid command. Please enter a number between 1 and 6: ",
                    1, 6);

            if (input == 1) {

                //Ask admin how many students they would like to add
                int numStudents = Util.inputPrompt("\nEnter number of new students to enroll: ",
                        "Invalid command. Please enter a valid number: ");
//
                for (int n = 0; n < numStudents; n++) {
                    Student student = new Student();
                    studentList.add(student);
                    student.enroll();
                    student.payTuition();
                    System.out.println(student);
                }
            } else if (input == 2) {
                //Ask Admin how many teachers they would like to add
                System.out.print("\nEnter number of new teachers to add to payroll: ");
                int numTeachers = in.nextInt();
                in.nextLine(); //consume newline left-over from above nextInt()
                for (int h = 0; h < numTeachers; h++) {
                    Teacher teacher = new Teacher();
                    teacherList.add(teacher);
                    System.out.println(teacher);
                }
            } else if (input == 3) {
                //print list of teachers and prompt user to select teacher to pay
                boolean payingTeachers = true;
                while (payingTeachers) {
                    System.out.println("\nTEACHERS");
                    System.out.println("--------------------------");
                    int x;
                    for (x = 0; x < teacherList.size(); x++) {
                        System.out.println("\t" + (x + 1) + ". " + teacherList.get(x).getName());
                    }
                    System.out.println("\t" + (x + 1) + ". " + "Pay All Teachers!");
                    System.out.print("\nSelect teacher to pay (0 to return to main menu): ");
                    // Scanner in = new Scanner(System.in);
                    int teacherSelect = in.nextInt();

                    if (teacherSelect == 0) {
                        break;
                    } else if (teacherSelect - 1 == x) {
                        for (Teacher i : teacherList) {
                            i.payTeacher();
                        }
                        System.out.println("\nAll teachers have been paid their biweekly salary!");
                    } else {
                        teacherList.get(teacherSelect - 1).payTeacher();
                    }
                }
            } else if (input == 4) {
            /*print list of teachers and prompt selection of
            teacher to give raise */
                boolean givingRaises = true;
                while (givingRaises) {
                    System.out.println("\nSALARY ADJUSTMENT");
                    System.out.println("--------------------------");
                    for (int x = 0; x < teacherList.size(); x++) {
                        System.out.println("\t" + (x + 1) + ". " + teacherList.get(x).getName());
                    }
                    System.out.print("\nSelect teacher to adjust salary (0 to return to main menu): ");
                    int teacherSelect = in.nextInt();

                    if (teacherSelect == 0) {
                        break;
                    } else {
                        teacherList.get(teacherSelect - 1).adjustSalary();
                    }
                }
            } else if (input == 5) {
            /*Create school object based on current studentList and teacherList
            Print out School Fund Information*/
                School nehs = new School(teacherList, studentList);
                System.out.println(nehs);

            } else if (input == 6) {
                //Exit the program
                System.out.println("\n######################");
                System.out.println("###    Goodbye!    ###");
                System.out.println("######################");
                System.exit(0);
            }
        }
    }
}

//    public static int inputPrompt(String firstMessage, String errorMessage, int maxInputNum) {
//        Scanner in = new Scanner(System.in);
//        int input = 0;
//
//        try {
//            System.out.print(firstMessage);
//            input = in.nextInt();
//        }
//        catch (InputMismatchException e) {
//            in.nextLine();
//        }
//
//        //Below code block will execute if string mismatch or input not within accepted range
//        while (input < 1 || input > maxInputNum) {
//            try {
//                System.out.print(errorMessage);
//                input = in.nextInt();
//                in.nextLine();
//            }
//            catch (InputMismatchException e) {
//                in.nextLine();
//            }
//        }
//
//        return input;
//    }
//}
