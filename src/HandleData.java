import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class HandleData {
    // ********** TASK SEVEN ***********

    // File paths for all the parts of the system that reads data into the system from CSVs.
    private static final String csvStudentPath = "src/data/student.csv";
    private static final String csvGroupPath = "src/data/group.csv";
    private static final String csvCoursePath = "src/data/course.csv";
    private static final String csvRoomPath = "src/data/room.csv";
    private static final String csvReservationPath = "src/data/reservation.csv";

    // Figure out the order of loading, e.g. :  Courses --> Groups --> Students --> Rooms --> Reservations
    public static ArrayList<Course> loadCourses() {
        ArrayList<Course> courses = new ArrayList<>();

        //parsing a CSV file into Scanner class constructor
        try {
            Scanner sc = new Scanner(new File(csvCoursePath));
            sc.useDelimiter(",");   //sets the delimiter pattern

            // Add logic here, where we construct a Course to add to the courses arraylist.

            while (sc.hasNext())  //returns a boolean value
            {
                System.out.println(" - " + sc.next());  //find and returns the next complete token from this scanner
            }
            sc.close();  //closes the scanner
        } catch (FileNotFoundException fnfe) {
            System.err.println("The course csv file does not exist!");
        }

        return courses;
    }

    public static void main(String[] args) {
        System.out.println("Path: " + csvCoursePath);
        loadCourses();
    }
}
