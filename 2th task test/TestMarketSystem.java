public class TestMarketSystem {
    public static void main(String []args) {
        // Create an instance of MarketManager for testing
        MarketManager marketManager = new MarketManager();

        // Test methods

        // Create and add products to the marketManager
        marketManager.createProduct(1, "Tomato", "Vegetable", "01/12/2023", 80);
        marketManager.createProduct(2, "Yogurt", "Dairy", "03/12/2023", 45);

        // Display all products in the marketManager
        marketManager.displayProducts();

        // Update activities for products
        marketManager.updateActivities(1, new Activities(1, "Add to stock", 50, "05/12/2023"));
        marketManager.updateActivities(2, new Activities(2, "Remove from stock", 20, "09/12/2023"));

        // Display vendor reports for specific products
        marketManager.displayVendorReport(1);
        marketManager.displayVendorReport(2);

        // Delete a product from the marketManager
        marketManager.deleteProduct(1);

        // Display remaining products in the marketManager
        marketManager.displayProducts();
    }
}
