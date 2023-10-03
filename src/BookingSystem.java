import java.util.Scanner;

public class BookingSystem {

    public static void main(String[] args) {
        boolean ProgramRunning = true;
        
        while (ProgramRunning) {
            Scanner Input = new Scanner(System.in);
            System.out.println("Please choose either \"addStudent\", \"addRoom\", \"addGroup\", \"addCourse\", \"Reservation\",\"addStudentToCourse\" or \"End\"");
            String Choice = Input.nextLine();
            switch (Choice) {
                case "addStudent" -> new Student();
                case "addRoom" -> {
                    new Room();
                    Room.printRooms();
                }
                case "addGroup" -> new Group();
                case "addCourse" -> new Course();
                case "Reservation" -> new Reservation();
                case "addStudentToCourse" -> {
                    System.out.println("What student");
                    String student = Input.nextLine();
                    System.out.println("What course");
                    String course = Input.nextLine();
                    Course.addStudentToCourse(student, course);
                }
                case "addStudentToGroup" -> {}
                case "End" -> {
                    System.out.println("System will now close");
                    ProgramRunning = false;
                }
                default -> System.out.println("Something went wrong, try again (System is case sensitive!)");
            }

        }
    }
}