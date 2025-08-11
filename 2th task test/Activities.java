// This class represents an activity with some attributes
public class Activities {
    // Declare private attributes for activity
    private int activityId;
    private String activityName;
    private int activityQuantity;
    private String activityDate;

    // Constructor used to create a new activity
    public Activities(int activityId, String activityName, int activityQuantity, String activityDate) {
        // Assign the parameters to the fields
        this.activityId = activityId;
        this.activityName = activityName;
        this.activityQuantity = activityQuantity;
        this.activityDate = activityDate;
    }

    // Getter method for each activity
    public int getActivityId() {
        return activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public int getActivityQuantity() {
        return activityQuantity;
    }

    public String getActivityDate() {
        return activityDate;
    }

    // Return a string representation of the activity
    public String toString() {
        return "ID: " + activityId +
                ", Name: " + activityName +
                ", Quantity: " + activityQuantity +
                ", Date: " + activityDate;
    }

}
