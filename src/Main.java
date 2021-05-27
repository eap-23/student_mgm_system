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
                int numTeachers = Util.inputPrompt("\nEnter number of new teachers to add to payroll: ",
                        "Invalid command. Please enter a valid number: ");
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

                    int teacherSelect = Util.inputPrompt("\nSelect teacher to pay (0 to return to main menu): ",
                            "Invalid command. Please enter a number between 0 and " + (x + 1) + ": ",
                            (x+1));

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
                    int x;
                    for (x = 0; x < teacherList.size(); x++) {
                        System.out.println("\t" + (x + 1) + ". " + teacherList.get(x).getName());
                    }

                    int teacherSelect = Util.inputPrompt("\nSelect teacher to adjust salary (0 to return to main menu): ",
                            "Invalid command. Please enter a number between 0 and " + x + ": ",
                            x);

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

