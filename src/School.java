/*
This class is responsible for keeping track of
multiple teachers, multiple students
Use ArrayList for teachers and students
*/

import java.util.List;

public class School {
    private List<Teacher> teachers;
    private List<Student> students;
    private static int totalMoneyEarned;
    private static int totalMoneySpent;
    private static int totalFunds;

    /*constructor method
    Create new school object
    Parameters include:
    List of teachers in the school
    List of students in the school*/
    public School(List<Teacher> teachers, List<Student> students) {
        this.teachers = teachers;
        this.students = students;
    }

    /*Updates total funds and total money earned
    Money earned by the school is adjusted by tuition payed by students*/
    public static void updateTotalMoneyEarned(int moneyEarned) {
        totalMoneyEarned += moneyEarned;
        updateTotalFunds();
    }

    /*Updates total funds and total money spent
    Money spent is salary given to the teachers */
    public static void updateTotalMoneySpent(int moneySpent) {
        totalMoneySpent += moneySpent;
        updateTotalFunds();
    }

    //Updates the total funds of school
    private static void updateTotalFunds() {
        if (totalMoneyEarned >= totalMoneySpent){
            totalFunds = totalMoneyEarned - totalMoneySpent;
        }
        else {
            totalFunds = totalMoneySpent - totalMoneyEarned;
        }
    }

    public String toString() {
        return "\nSCHOOL FUNDS" +
                "\n--------------------------" +
                "\nTotal money spent to date: $" + totalMoneySpent +
                "\nTotal money earned to date: $" + totalMoneyEarned +
                "\nTotal current school funds: $" + totalFunds;
    }
}
