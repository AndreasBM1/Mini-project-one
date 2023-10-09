import java.util.*;

public class Group {
    private String groupName;
    private static ArrayList<Group> groupsList = new ArrayList<>();
    private ArrayList<Student> groupMembers = new ArrayList<>();

    public Group() {
        Scanner input = new Scanner(System.in);
        System.out.println("Write group to add to system");
        this.groupName = input.nextLine();
        groupsList.add(this);
        System.out.println("What course?");
        Course.addGroup(this, input.nextLine());
    }

    public String getGroupName() {
        return groupName;
    }

    public boolean isStudentInGroup(Student student) {
        return this.groupMembers.contains(student);
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
        for (Group obj : groupsList) {
            if (obj.groupName.equals(group) && !obj.isStudentInGroup(tempStudent)) {
                obj.groupMembers.add(tempStudent);
                System.out.println("Student added to group");
            } else {
                System.out.println("Student already in group");
            }
            return;
        }
        System.out.println("Group doesn't exist");
    }

    public static Group findGroup(String name) {
        for (Group obj : groupsList) {
            if (obj.groupName.equals(name)){
                return obj;
            }
        }
        return null;
    }
}
