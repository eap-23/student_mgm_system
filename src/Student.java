/*
This class is responsible for keeping track of
students, name, ID, classes enrolled, fees paid
*/

import java.util.Scanner;

public class Student {
    private String name;
    private String gradeYear;
    private int gradeNum;
    private String studentID;
    private String courses="";
    private int tuitionBalance=0;
    private static int courseCost = 700;
    private static int id=1000;

    private static String[] subjects = {"Math", "English", "Computer Science",
            "Lab Science", "History"};
    private static String[] mathCourses = {"Algebra", "Discrete Mathematics",
            "Trigonometry", "Statistics", "Calculus"};
    private static String[] englishCourses = {"English Literature", "Creative Writing",
            "German Literature", "Old English", "Shakespeare"};
    private static String[] computerSciCourses = {"Programming", "Database Management",
            "Data Structures and Analysis", "Game Development",
            "Artificial Intelligence"};
    private static String[] labSciCourses = {"Ecology", "Genetics", "Cellular Biology",
            "Environmental Science", "Physics"};
    private static String[] historyCourses = {"American Government", "Epidemics",
            "World War II", "Medievel Europe", "Greek Mythology"};

    /*
    constructor
    Fees for every student is $40,000
    Fees paid when student initialized is $0
    Student ID must be unique
    Name of the Student
    Grade of the Student
    */
    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Student Name: ");
        this.name = in.nextLine();

        System.out.print("\n\t1 - Freshman\n\t2 - Sophmore\n\t3 - Junior\n\t4 - Senior\n");
        int input = Util.inputPrompt("\nEnter student class level: ",
                "Invalid command.  Please enter a number between 1 and 4: ",
                1, 4);

        this.gradeNum = input;

        if (input == 1) {
            this.gradeYear = "Freshman";
        }
        else if (input == 2) {
            this.gradeYear = "Sophmore";
        }
        else if (input == 3) {
            this.gradeYear = "Junior";
        }
        else if (input == 4) {
            this.gradeYear = "Senior";
        }

        setStudentID();

    }

    //Set a unique Student ID
    private void setStudentID() {
        // Grade Level + ID
        id++;
        this.studentID =  gradeNum + "" + id;
    }

    //Enroll student in course
    public void enroll() {
        //initialize a loop to enroll in courses, gives user option to quit
        boolean running = true;
        while (running) {
            System.out.println("\nSCHOOL SUBJECTS");
            System.out.println("--------------------------");
            for (int x=0; x < subjects.length; x++) {
                System.out.println("\t" + (x + 1) + ". " + subjects[x]);
            }

            int subject = Util.inputPrompt("\nEnter subject to view courses (0 to finish enrolling): ",
                    "Invalid command. Please enter a number less than " + (subjects.length + 1) + ": ",
                    subjects.length);
//            System.out.print("\nEnter subject to view courses (0 to finish enrolling): ");
//            Scanner in = new Scanner(System.in);
//            int subject = in.nextInt();

            //List class options dependent on subject selected
            if (subject == 0) {
                break;
            }
            else if (subject == 1) {
                System.out.println("\nMATH COURSES");
                System.out.println("--------------------------");
                subjectEnroll(mathCourses);
            }
            else if (subject == 2) {
                System.out.println("\nENGLISH COURSES");
                System.out.println("--------------------------");
                subjectEnroll(englishCourses);
            }
            else if (subject == 3) {
                System.out.println("\nCOMPUTER SCIENCE COURSES");
                System.out.println("--------------------------");
                subjectEnroll(computerSciCourses);
            }
            else if (subject == 4) {
                System.out.println("\nLAB SCIENCE COURSES");
                System.out.println("--------------------------");
                subjectEnroll(labSciCourses);
            }
            else if (subject == 5) {
                System.out.println("\nHISTORY COURSES");
                System.out.println("--------------------------");
                subjectEnroll(historyCourses);
            }
        }
        System.out.println("\n" + name + " is enrolled in the below courses: " + courses);
    }

    //Enroll in a course for one subject
    private void subjectEnroll(String[] subjectCourses) {

        for (int x=0; x<subjectCourses.length; x++) {
            System.out.println("\t" + (x + 1) + ". " + subjectCourses[x]);
        }

        boolean running = true;
        while (running) {
            System.out.print("\nEnter course to enroll (0 to return to subjects): ");
            Scanner in = new Scanner(System.in);
            int course = in.nextInt();
            if (course != 0) {
                courses = courses + "\n\t" + subjectCourses[course - 1];
                tuitionBalance = tuitionBalance + courseCost;
                System.out.println(name + " has been enrolled in " + subjectCourses[course - 1] + "!");
            }
            else {
                break;
            }
        }
    }

    //View Balance. Accessor Method
    public void viewBalance() {
        System.out.println("\n" + name + "'s balance is: $" + tuitionBalance);
    }

    //Pay Tuition. Mutator Method
    public void payTuition() {
        viewBalance();
        System.out.print("Enter their payment: $");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance = tuitionBalance - payment;
        // System.out.println("Thank you for entering payment of $" + payment);
        viewBalance();
        School.updateTotalMoneyEarned(payment);
    }


    //METHOD OVERRIDE
    public String toString() {
        return "\nStudent Info" +
                "\n--------------------------" +
                "\nName: " + name +
                "\nGrade Level: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nCourses Enrolled" + courses +
                "\nBalance: $" + tuitionBalance +
                "\n--------------------------" +
                "\n";
    }

}
