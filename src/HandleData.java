import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.time.LocalDateTime;

public class HandleData {
    // ********** TASK SEVEN ***********

    // File paths for all the parts of the system that reads data into the system from CSVs.
    private static final String csvStudentPath = "src/data/student.csv";
    private static final String csvGroupPath = "src/data/group.csv";
    private static final String csvCoursePath = "src/data/course.csv";
    private static final String csvRoomPath = "src/data/room.csv";
    private static final String csvReservationPath = "src/data/reservation.csv";

    // Figure out the order of loading, e.g. : Students --> Courses --> Groups --> Rooms --> Reservations

    public static void loadStudents(){
        try {
            FileReader fr = new FileReader(csvStudentPath);
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()) {
                ArrayList<String> studentCourses = new ArrayList<>();
                String line = sc.nextLine();
                StringTokenizer st = new StringTokenizer(line,",");
                String studentName = st.nextToken();
                while(st.hasMoreTokens()) { // This could check for the limit of MAX COURSES
                     studentCourses.add(st.nextToken());
                }
                new Student(studentName, studentCourses);
            }
            Student.printStudents();
            sc.close();
        } catch (FileNotFoundException fnfe) {
            System.err.println("The student csv file does not exist!");
        }

    }

    // Load courses before groups
    public static void loadGroups(){
        try {
            FileReader fr = new FileReader(csvGroupPath);
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()) {
                ArrayList<String> groupMembers = new ArrayList<>();
                String line = sc.nextLine();
                StringTokenizer st = new StringTokenizer(line,",");
                String groupName = st.nextToken();
                int reservedTime = Integer.parseInt(st.nextToken());
                String courseName = st.nextToken();
                while(st.hasMoreTokens()) { // This could check for the limit of MAX COURSES
                    groupMembers.add(st.nextToken());
                }
                new Group(groupName, reservedTime, courseName, groupMembers);
            }
            Group.printGroups();
            sc.close();
        } catch (FileNotFoundException fnfe) {
            System.err.println("The group csv file does not exist!");
        }

    }

    public static void loadCourses() {
        ArrayList<Course> courses = new ArrayList<>();

        //parsing a CSV file into Scanner class constructor
        try {
            FileReader fr = new FileReader(csvCoursePath);
            Scanner sc = new Scanner (fr);
            // Add logic here, where we construct a Course to add to the courses arraylist.
            while (sc.hasNextLine())
            {
                ArrayList<String> courseGroups = new ArrayList<>();
                ArrayList<String> courseStudents = new ArrayList<>();
                StringTokenizer st = new StringTokenizer(sc.nextLine(),",");
                String courseName = st.nextToken();
                StringTokenizer st2 = new StringTokenizer(sc.nextLine(),",");
                while(st2.hasMoreTokens()) {
                    courseGroups.add(st2.nextToken());
                }
                StringTokenizer st3 = new StringTokenizer(sc.nextLine(),",");
                while(st3.hasMoreTokens()) {
                    courseStudents.add(st3.nextToken());
                }
                Course c = new Course(courseName, courseGroups, courseStudents);
            }
            Course.printCourses();
            sc.close();
        } catch (FileNotFoundException fnfe) {
            System.err.println("The course csv file does not exist!");
        }
    }

    public static void loadRooms(){
        try {
            FileReader fr = new FileReader(csvRoomPath);
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                StringTokenizer st = new StringTokenizer(line,",");
                String roomName = st.nextToken();
                new Room(roomName);
            }
            Room.printRooms();
            sc.close();
        } catch (FileNotFoundException fnfe) {
            System.err.println("The room csv file does not exist!");
        }

    }

    private static void loadReservations() {
        try {
            FileReader fr = new FileReader(csvReservationPath);
            Scanner sc = new Scanner(fr);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                StringTokenizer st = new StringTokenizer(line,",");
                String groupName = st.nextToken();
                String roomName = st.nextToken();
                int duration = Integer.parseInt(st.nextToken());
                LocalDateTime startTime = LocalDateTime.parse(st.nextToken(), formatter);
                LocalDateTime endTime = LocalDateTime.parse(st.nextToken(), formatter);
                new Reservation(groupName, startTime, endTime, duration, roomName);
            }
            Room.printRoomReservations();
            sc.close();
        } catch (FileNotFoundException fnfe) {
            System.err.println("The reservation csv file does not exist!");
        }


    }


    public static void main(String[] args) {
        System.out.println("Path: " + csvStudentPath);
        loadStudents();
        loadCourses();
        loadGroups();
        loadRooms();
        loadReservations();
    }

}
