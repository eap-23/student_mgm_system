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
        System.out.println("\nSCHOOL SUBJECTS");
        System.out.println("--------------------------");
        System.out.print("\t1 - Math\n\t2 - English\n\t3 - Computer Science\n\t4 - Lab Science\n\t5 - History");
        int input = Util.inputPrompt("\n\nEnter teacher's subject: ",
                "Invalid input. Please enter a number between 1 and 5: ",
                5);

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
        this.salary = Util.inputPrompt("Enter " + name + "'s starting salary: $",
                "Invalid command. Please enter a valid dollar amount: $");
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
        System.out.println("\nCurrent salary: $" + salary);
        int newSalary = Util.inputPrompt("Enter new salary for " + name + ": $",
                "Invalid command. Please enter a valid dollar amount: $");
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
