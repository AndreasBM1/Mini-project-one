import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private String studentName;
    private int studentCourseAmount = 0;
    private static ArrayList<Student> studentsList = new ArrayList<>();

    public Student (){
        Scanner input = new Scanner(System.in);
        System.out.println("Write student to add to system");
        this.studentName = input.nextLine();
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
}
