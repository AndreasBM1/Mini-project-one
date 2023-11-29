import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private String studentName;
    private int studentCourseAmount = 0;
    private ArrayList<String> studentCourses = new ArrayList<>();
    private static ArrayList<Student> studentsList = new ArrayList<>();

    public Student (){
        Scanner input = new Scanner(System.in);
        System.out.println("Write student to add to system");
        this.studentName = input.nextLine();
        studentsList.add(this);
        System.out.println("Student added");
    }

    public Student (String name, ArrayList<String> courses) {
        this.studentName = name;
        this.studentCourses = courses;
        this.studentCourseAmount = courses.size();
        studentsList.add(this);
    }

    public boolean bumpStudentCourseAmount() {
        if (studentCourseAmount < 5) {
            this.studentCourseAmount++;
            return true;
        }
        return false;
    }

    public static Student findStudentByName(String name){
        for (Student obj : studentsList) {
            if (obj.studentName.equals(name)){
                return obj;
            }
        }
        return null;
    }

    public ArrayList<String> getStudentCourses() {
        return studentCourses;
    }

    public String getStudentName() {
        return studentName;
    }

    public static void printStudents() {
        System.out.println("List of all registered students: ");
        for (Student obj : studentsList) {
            System.out.println(" - " + obj.getStudentName() + " is in " + obj.studentCourseAmount + " of courses --> " + obj.getStudentCourses());
        }
    }
}
