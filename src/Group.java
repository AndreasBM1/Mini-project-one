import java.util.*;

public class Group {
    private String groupName;
    private static ArrayList<Group> groupsList = new ArrayList<>();

    public Group(){
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

}
