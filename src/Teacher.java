/*
This class is responsible for keeping track of
teachers, name, ID, salary
*/

import java.util.Scanner;

public class Teacher {
    private String name;
    private String subject;
    private int salary;
    private int salaryEarned;
    private String teacherID;
    private static int id=1000;

    /*
    constructor
    Create a new Teacher object
    Teacher ID must be unique
    Name of the Teacher
    Salary of the Teacher
    */
    public Teacher() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Teacher Name: ");
        this.name = in.nextLine();

        setTeacherSubject();
        setInitialSalary();
        setTeacherID();
    }

    public String getName() {
        return name;
    }

    private void setTeacherSubject() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nSCHOOL SUBJECTS");
        System.out.println("--------------------------");
        System.out.print("\t1 - Math\n\t2 - English\n\t3 - Computer Science\n\t4 - Lab Science\n\t5 - History\n\nEnter teacher's subject: ");
        int input = in.nextInt();

        while ((input > 5) || (input == 0)) {
            System.out.println("\tInvalid input. Please enter 1, 2, 3, 4, or 5");
            System.out.print("\tEnter teacher's subject: ");
            input = in.nextInt();
        }

        if (input == 1) {
            subject = "Math";
        }
        else if (input == 2) {
            subject = "English";
        }
        else if (input == 3) {
            subject = "Computer Science";
        }
        else if (input == 4) {
            subject = "Lab Science";
        }
        else if (input == 5) {
            subject = "History";
        }
    }

    //Set Teacher's salary
    private void setInitialSalary() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter " + name + "'s starting salary: $");
        this.salary = in.nextInt();
    }

    //Set a unique Teacher ID
    private void setTeacherID() {
      /* 5 + ID, teacher IDs will always start with 5
      to distinguish teachers from students
      */
        id++;
        this.teacherID =  5 + "" + id;
    }

    /*Pay teacher their biweekly salary
    Keep track of money earned by teacher
    Update money spent by school */
    public void payTeacher() {
        salaryEarned += (salary / 26);
        System.out.println("\n" + name + " has been payed!");
        System.out.println(name + " has earned $" + salaryEarned + " this year");
        School.updateTotalMoneySpent(salary / 26);
    }

    //Give Teacher a raise!
    public void adjustSalary() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nCurrent salary: $" + salary);
        System.out.print("Enter new salary for " + name + ": $");
        int newSalary = in.nextInt();
        if (newSalary > salary) {
            System.out.println(name + "'s salary has been increased to $" + newSalary + "!");
        }
        else if (newSalary < salary) {
            System.out.println(name + "'s salary has been decreased to $" + newSalary + ".");
        }

        this.salary = newSalary;
    }


    //METHOD OVERRIDE
    public String toString() {
        return "\nTeacher Info" +
                "\n--------------------------" +
                "\nName: " + name +
                "\nSubject: " + subject +
                "\nTeacher ID: " + teacherID +
                "\nSalary: $" + salary +
                "\n--------------------------" +
                "\n";
    }
}
