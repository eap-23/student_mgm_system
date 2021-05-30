/*This class is responsible for keeping track of
teacher information including name, ID, salary,
and subject they teach*/

import java.util.Scanner;

public class Teacher {
    private String name;
    private String subject;
    private int salary;
    private int salaryEarned;
    private String teacherID;
    private static int id=1000;

    /*constructor
    Create a new Teacher object
    Name of teacher
    Teacher's subject
    Teacher's salary
    Unique teacher ID is auto-generated*/
    public Teacher() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Teacher Name: ");
        this.name = in.nextLine();

        setTeacherSubject();
        setInitialSalary();
        setTeacherID();
    }

    //Accessor method. Return teacher's name
    public String getName() {
        return name;
    }

    /*Set teacher's subject
    Generate list of subject options and prompt user selection*/
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
      to distinguish teachers from students (IDs set 1-4)*/
        id++;
        this.teacherID =  5 + "" + id;
    }

    /*Pay teacher their biweekly salary
    Keep track of money earned by teacher
    Update money spent by school*/
    public void payTeacher() {
        salaryEarned += (salary / 26);
        System.out.println("\n" + name + " has been payed!");
        System.out.println(name + " has earned $" + salaryEarned + " this year");
        School.updateTotalMoneySpent(salary / 26);
    }

    //Give teacher a raise or pay cut
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


    //METHOD OVERRIDE. Print teacher info
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
