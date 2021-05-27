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
    List of teachers in the school
    List of students in the school
    */
    public School(List<Teacher> teachers, List<Student> students) {
        this.teachers = teachers;
        this.students = students;

        // totalMoneyEarned=0;
//       totalMoneySpent=0;
//       totalFunds=0;
    }

    //accessor methods
    //return list of teachers in the school
    public List<Teacher> getTeachers() {
        return teachers;
    }

    //return list of students in the school
    public List<Student> getStudents() {
        return students;
    }

    //return total money earned by school
    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    //return total money spent by school
    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }

    //mutator methods
    //Add a new teacher to the school
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    //Add a new student to the school
    public void addStudent(Student student) {
        students.add(student);
    }

    //Adds money earned to the total money earned
    public static void updateTotalMoneyEarned(int moneyEarned) {
        totalMoneyEarned += moneyEarned;
        updateTotalFunds();
    }

    /*Update the money spent by the school
    /Money spent is salary given to the teachers */
    public static void updateTotalMoneySpent(int moneySpent) {
        // totalMoneyEarned -= moneySpent;
        totalMoneySpent += moneySpent;
        updateTotalFunds();
    }

    //Update the total current funds of school
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
