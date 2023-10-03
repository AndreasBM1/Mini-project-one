import java.util.ArrayList;
import java.util.Scanner;

public class Course {
    private String courseName;
    private static ArrayList<Course> coursesList = new ArrayList<>();
    private ArrayList<Group> courseGroups = new ArrayList<>();
    private ArrayList<Student> courseStudents = new ArrayList<>();

    public Course (){
        Scanner input = new Scanner(System.in);
        System.out.println("Write course to add to system");
        this.courseName = input.nextLine();
        coursesList.add(this);
        System.out.println("Course added");
    }

    public static void addGroup(Group g, String s){
        for (Course obj : coursesList) {
            if (obj.courseName.equals(s)){
                obj.courseGroups.add(g);
                System.out.println("Group added to course");
                return;
            }
        }
        System.out.println("Course doesn't exist");
    }

    public boolean isStudentInCourse(Student student) {
        return this.courseStudents.contains(student);
    }

    public static void addStudentToCourse(String studentName, String courseName){
        Student tempStudent = Student.findStudentByName(studentName);
        if (tempStudent == null) {
            System.out.println("Student does not exist");
            return;
        }

        for (Course obj : coursesList) {
            if (obj.courseName.equals(courseName)){
                if(!obj.isStudentInCourse(tempStudent)) {
                    if (tempStudent.bumpStudentCourseAmount()) {
                        obj.courseStudents.add(tempStudent);
                        System.out.println("Student added to course");
                        return;
                    }
                } else {
                    System.out.println("Student already in course");
                    return;
                }
            }
        }
        System.out.println("Course doesn't exist");
    }

    public static Course findCourseByName(String name){
        for (Course obj : coursesList) {
            if (obj.courseName.equals(name)){
                return obj;
            }
        }
        return null;
    }
}
