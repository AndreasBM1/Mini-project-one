import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
public class Group implements Comparable<Group>{
    private String groupName;
    private Integer reservationPriority = null;
    private static ArrayList<Group> groupsList = new ArrayList<>();
    private ArrayList<String> groupMembers = new ArrayList<>();

    public Group() {
        Scanner input = new Scanner(System.in);
        System.out.println("Write group to add to system");
        this.groupName = input.nextLine();
        groupsList.add(this);
        System.out.println("What course?");
        Course.addGroup(this.groupName, input.nextLine());
    }

    public Group(String name, int reservedTime, String courseName, ArrayList<String> students) {
        this.groupName = name;
        this.reservationPriority = reservedTime;
        this.groupMembers = students;

        Course.addGroup(this.groupName,courseName);
        groupsList.add(this);
    }

    public int getReservationPriority() {
        return reservationPriority;
    }

    public void setReservationPriority(int reservationPriority) {
        this.reservationPriority = reservationPriority;
    }

    public String getGroupName() {
        return groupName;
    }

    public boolean isStudentInGroup(Student student) {
        return this.groupMembers.contains(student);
    }

    @Override
    public int compareTo(Group group){
        return this.getReservationPriority() - group.getReservationPriority();
    }

    // ********** TASK ONE ***********
    public boolean hasPriority(Group group) {
        //if (this.reservationPriority <= 240 && group.getReservationPriority() > 240) return true;
        //if (this.reservationPriority < group.getReservationPriority()) return true;
        //if (this.reservationPriority == group.getReservationPriority() && this.groupMembers.size() > group.groupMembers.size()) return true;
        // Kept here if I made seriously bad code and need to revert :O
        if (compareTo(group) < 0) return true;
        if (compareTo(group) == 0 && this.groupMembers.size() > group.groupMembers.size()) return true;
        if (compareTo(group) > 0) return false;
        return false;
    }



    public static void addStudentToGroup(String course, String student, String group) {
        Course tempCourse = Course.findCourseByName(course);
        if (tempCourse == null) {
            System.out.println("Course does not exist");
            return;
        }
        Student tempStudent = Student.findStudentByName(student);
        if (tempStudent == null) {
            System.out.println("Student does not exist");
            return;
        }

        if (!tempStudent.getStudentCourses().contains(tempCourse)) {
            System.out.println("Student is not in the group's course. ");
            return;
        }

        for (Group obj : groupsList) {
            if (obj.groupName.equals(group) && !obj.isStudentInGroup(tempStudent)) {
                obj.groupMembers.add(student);
                System.out.println("Student added to group");
                return;
            }
        }
        if (groupsList.contains(group)){
            System.out.println("Student already in group");
        } else{
            System.out.println("Group doesn't exist");
        }
    }

    public static Group findGroup(String name) {
        for (Group obj : groupsList) {
            if (obj.groupName.equals(name)){
                return obj;
            }
        }
        return null;
    }

    public ArrayList<String> getGroupMembers() {
        return groupMembers;
    }

    public static void printGroups() {
        System.out.println("List of all registered groups: ");
        for (Group obj : groupsList) {
            System.out.println(" - " + obj.getGroupName() + " has members --> " + obj.getGroupMembers());
        }
    }
}
