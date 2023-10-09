import java.util.Scanner;

public class BookingSystem {
    private static final Scanner Input = new Scanner(System.in);
    private static final String[] commands = {
            "add student","add room","add group","add course","make reservation",
            "add student to course", "add student to group","room list","end"
    }; // This is a very incomplete list, but just make it as last thing

    public static void main(String[] args) {
        boolean ProgramRunning = true;
        System.out.println("Type help for command list");
        while (ProgramRunning) {
            String Choice = Input.nextLine();
            switch (Choice) {
                case "help" -> help();
                case "add student" -> new Student();
                case "add room" -> new Room();
                case "add group" -> new Group();
                case "add course" -> new Course();
                case "make reservation" -> new Reservation();
                case "add student to course" -> addStudentToCourse();
                case "add student to group" -> addStudentToGroup();
                case "room list" -> Room.printRooms();
                case "end" -> {
                    System.out.println("System will now close");
                    ProgramRunning = false;
                }
                default -> System.out.println("Illegal input, this incident will be reported! (System is case sensitive!)");
            }

        }
    }

    private static void help(){
        for (String string : commands) System.out.println(string);
    }
    private static void addStudentToCourse() {
        System.out.println("What student");
        String student = Input.nextLine();
        System.out.println("What course");
        String course = Input.nextLine();
        Course.addStudentToCourse(student, course);
    }

    private static void addStudentToGroup(){
        System.out.println("What course does group belong to");
        String course = Input.nextLine();
        System.out.println("What student");
        String student = Input.nextLine();
        System.out.println("What group");
        String group = Input.nextLine();
        Group.addStudentToGroup(course,student,group);
    }

}