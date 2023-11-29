import java.util.ArrayList;
import java.util.Scanner;

public class Course {
    private String courseName;
    private static ArrayList<Course> coursesList = new ArrayList<>();
    private ArrayList<String> courseGroups = new ArrayList<>();
    private ArrayList<String> courseStudents = new ArrayList<>();

    public Course (){
        Scanner input = new Scanner(System.in);
        System.out.println("Write course to add to system");
        this.courseName = input.nextLine();
        for (Course course : coursesList) {
            if (course.getCourseName().equals(this.courseName)) {
                System.out.println("Course already exists");
                return;
            }
        }
        coursesList.add(this);
        System.out.println("Course added");
    }


    // Figure out what goes here :)
    public Course (String name, ArrayList<String> groups, ArrayList<String> students) {
        this.courseName = name;
        this.courseGroups = groups;
        this.courseStudents = students;
        coursesList.add(this);
    }



    public static void addGroup(String g, String s){
        for (Course obj : coursesList) {
            if (obj.courseName.equals(s)){
                obj.courseGroups.add(g);
                System.out.println("Group added to course");
                return;
            }
        }
        System.out.println("Course doesn't exist");
    }

    public boolean isStudentInCourse(String name) {
        return this.courseStudents.contains(name);
    }

    public static void addStudentToCourse(String studentName, String courseName){
        Student tempStudent = Student.findStudentByName(studentName);
        for (Course obj : coursesList) {
            if (obj.courseName.equals(courseName)){
                if(!obj.isStudentInCourse(studentName)) {
                    if (tempStudent.bumpStudentCourseAmount()) { //Consider handling this error
                        obj.courseStudents.add(studentName);
                        tempStudent.getStudentCourses().add(courseName);
                        System.out.println("Student added to course");
                        return;
                    } else {
                        System.out.println("Student has reached maximum courses");
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

    public String getCourseName() {
        return courseName;
    }

    public static void printCourses() {
        System.out.println("List of all registered courses: ");
        for (Course obj : coursesList) {
            System.out.println(" - " + obj.getCourseName() + " has groups --> " + obj.courseGroups + " and has students --> \n " + obj.courseStudents);
        }
    }
}
