public class HasPriorityTest {
    public static void main(String[] args) {
        new Course();
        Group a = new Group();
        Group b = new Group();
        a.setReservationPriority("0");
        b.setReservationPriority("240");
        System.out.println("This should be negative: " + a.compareTo(b));
        a.setReservationPriority("240");
        b.setReservationPriority("240");
        System.out.println("This should be 0:" + a.compareTo(b));
        a.setReservationPriority("480");
        b.setReservationPriority("240");
        System.out.println("This should be positive: " + a.compareTo(b));
    }
}