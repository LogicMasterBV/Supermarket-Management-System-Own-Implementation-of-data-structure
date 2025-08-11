

// This class manages the activities and products
public class MarketManager {
    // Counter variables for generating unique activity and product IDs
    private int nextActivityId = 1;
    private int nextProductId = 1;

    // Map to store products with their unique IDs
    public CustomHashMap<Integer, Product> products;



    // Constructor for creating MarketManager objects
    public MarketManager() {
        // Initialize the products map as a HashMap
        this.products = new CustomHashMap<>();
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
        // Get the values from the products map and print each one
        CustomArrayList<Product> valuesList = products.values();
        for (int i = 0; i < valuesList.size(); i++) {
            Product product = valuesList.get(i);
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
        CustomArrayList<Product> categoryProducts = new CustomArrayList<>();

        // Get the values from the products map
        CustomArrayList<Product> valuesList = products.values();

        // Iterate through all products and add those of the specified category to the list
        for (int i = 0; i < valuesList.size(); i++) {
            Product product = valuesList.get(i);
            if (product.getProductCategory().equalsIgnoreCase(category)) {
                categoryProducts.add(product);
            }
        }

        // Sort the products in descending order based on quantity using insertion sort
        insertionSort(categoryProducts);

        // Print the sorted products
        for (int i = 0; i < categoryProducts.size(); i++) {
            System.out.println(categoryProducts.get(i));
        }
    }


// Helper method for sorting a list of products in descending order based on quantity
    private void insertionSort(CustomArrayList<Product> productList) {
        // Get the size of the product list
        int n = productList.size();

        // Iterate through the list starting from the second element
        for (int i = 1; i < n; ++i) {
            // Select the current product as the key for comparison
            Product key = productList.get(i);
            // Initialize a pointer for the element to the left of the key
            int j = i - 1;

            // Move elements of productList[0..i-1] that are greater than key.getProductQuantity()
            // to one position ahead of their current position

            // Iterate through the sorted part of the list (left of the key)
            // and shift elements to the right until finding the correct position for the key
            while (j >= 0 && productList.get(j).getProductQuantity() < key.getProductQuantity()) {
                // Shift the element to the right
                productList.set(j + 1, productList.get(j));
                // Move to the previous element in the sorted part of the list
                j = j - 1;
            }

            // Place the key in its correct position in the sorted list
            productList.set(j + 1, key);
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

