public class TestMarketSystem {
    public static void main(String []args) {
        // Create an instance of MarketManager for testing
        MarketManager marketManager = new MarketManager();

        // Test methods

        // Create and add products to the marketManager
        marketManager.createProduct(1, "Banana", "Fruits", "01/02/2022", 200);
        marketManager.createProduct(2, "Tuna", "Fish", "01/02/2022", 150);

        // Display all products in the marketManager
        marketManager.displayProducts();

        // Update activities for products
        marketManager.updateActivities(1, new Activities(1, "Add to stock", 30, "01/02/2022"));
        marketManager.updateActivities(2, new Activities(2, "Remove from stock", 40, "01/02/2022"));

        // Display vendor reports for specific products
        marketManager.displayVendorReport(1);
        marketManager.displayVendorReport(2);

        // Display products by category sorted by quantity
        marketManager.displayProductsByCategory("Fruits");

        // Delete a product from the marketManager
        marketManager.deleteProduct(1);

        // Display remaining products in the marketManager
        marketManager.displayProducts();
    }
}
