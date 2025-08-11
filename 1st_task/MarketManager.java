import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

// This class manages the activities and products
public class MarketManager {
    // Counter variables for generating unique activity and product IDs
    private int nextActivityId = 1;
    private int nextProductId = 1;

    // Map to store products with their unique IDs
    public Map<Integer, Product> products;

    // Constructor for creating MarketManager objects
    public MarketManager() {
        // Initialize the products map as a HashMap
        this.products = new HashMap<>();
    }

    // Method for creating a new product
    public void createProduct(int productId, String productName, String productCategory, String productDate, int productQuantity) {
        // Create a new Product object
        Product product = new Product(productId, productName, productCategory, productDate, productQuantity);
        // Add the product to the products map with its unique ID
        products.put(productId, product);
    }

    // Method for displaying all products
    public void displayProducts() {
        // Iterate through the values (products) in the products map and print each one
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }

    // Method for deleting a product based on its ID
    public void deleteProduct(int productId) {
        // Remove the product with the specified ID from the products map
        products.remove(productId);
    }

    // Method for displaying products of a specific category, sorted by quantity
    public void displayProductsByCategory(String category) {
        // Create a list to store products of the specified category
        List<Product> categoryProducts = new ArrayList<>();

        // Iterate through all products and add those of the specified category to the list
        for (Product product : products.values()) {
            if (product.getProductCategory().equalsIgnoreCase(category)) {
                categoryProducts.add(product);
            }
        }

        // Sort the products in descending order based on quantity
        Collections.sort(categoryProducts, (p1, p2) -> Integer.compare(p2.getProductQuantity(), p1.getProductQuantity()));

        // Print the sorted products
        for (Product product : categoryProducts) {
            System.out.println(product);
        }
    }

    // Method for updating product activities and quantity
    public void updateActivities(int productId, Activities activity) {
        // Get the product with the specified ID from the products map
        Product product = products.get(productId);

        // Check if the product exists
        if (product != null) {
            // Calculate the new quantity based on the activity type
            int newQuantity = (activity.getActivityName().equals("AddToStock"))
                    ? product.getProductQuantity() + activity.getActivityQuantity()
                    : product.getProductQuantity() - activity.getActivityQuantity();

            // Check if the new quantity is non-negative
            if (newQuantity >= 0) {
                // Update the product quantity and add the activity to the product's activities list
                product.setProductQuantity(newQuantity);
                product.addActivity(activity);
            } else {
                // Display an error message for negative quantity
                System.out.println("Error: Negative quantity is not allowed.");
            }
        } else {
            // Display an error message for product not found
            System.out.println("Error: Product not found.");
        }
    }

    // Method for displaying a vendor report for a specific product
    public void displayVendorReport(int productId) {
        // Get the product with the specified ID from the products map
        Product product = products.get(productId);

        // Check if the product exists
        if (product != null) {
            // Print the vendor report header
            System.out.println("Vendor Report for Product ID " + productId);

            // Iterate through the activities of the product and print each one
            for (Activities activity : product.getActivities()) {
                System.out.println(activity);
            }
        } else {
            // Display an error message for product not found
            System.out.println("Error: Product not found.");
        }
    }

    // Getter method for obtaining the next activity ID
    public int getNextActivityId() {
        return nextActivityId++;
    }

    // Getter method for obtaining the next product ID
    public int getNextProductId() {
        return nextProductId++;
    }
}
