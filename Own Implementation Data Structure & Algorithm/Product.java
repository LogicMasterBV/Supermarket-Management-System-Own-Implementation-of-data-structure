import java.util.ArrayList;
import java.util.List;

// This class represents a product with some attributes and activities
public class Product {
    // Declare private fields for product properties
    private int productId;
    private String productName;
    private String productCategory;
    private String productDate;
    private int productQuantity;
    private List<Activities> last4activities;

    // Constructor used to create new objects
    public Product(int productId, String productName, String productCategory,
                         String productDate, int productQuantity) {
        // Assign the parameters to the fields
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productDate = productDate;
        this.productQuantity = productQuantity;
        // Initialize an empty list for activities
        this.last4activities = new ArrayList<>();

    }

    // Setter and getter method for each attribute
    public int getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public String getProductCategory() {
        return productCategory;
    }
    public void setProductQuantity(int productQuantity) {

        this.productQuantity = productQuantity;
    }
    public int getProductQuantity() {
        return productQuantity;
    }

    // Get the list of activities
    public List<Activities> getActivities() {
        return last4activities;
    }

    // Return a string representation of the product
    public String toString() {
        return "Product ID: " + productId +
                ", Name: " + productName +
                ", Category: " + productCategory +
                ", Date: " + productDate +
                ", Quantity: " + productQuantity +
                ", Activities: " + last4activities;
    }

    // Add an activity to the list and remove the oldest one if the activities are greater than 4
    public void addActivity(Activities activity) {
        last4activities.add(activity);
        if (last4activities.size() > 4) {
            last4activities.remove(0);
        }
    }


}
