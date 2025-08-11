import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupermarketGUI extends JFrame {
    private MarketManager supermarketManager;
    private JTextArea outputTextArea;

    // Constructor for SupermarketGUI
    public SupermarketGUI() {
        this.supermarketManager = new MarketManager();
        initializeUI(); // Initialize the graphical user interface
    }

    // Method to set up the graphical user interface
    private void initializeUI() {
        setTitle("Supermarket Management System"); // Set the title of the JFrame
        setSize(1200, 300); // Set the size of the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation

        // Main panel with a colorful background
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 245, 245)); // Light gray background
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // JTextArea to display output with scrolling
        outputTextArea = new JTextArea(20, 40);
        outputTextArea.setEditable(false);
        outputTextArea.setBackground(new Color(255, 255, 255)); // White background
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Panel for buttons with a gradient background
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBackground(new Color(230, 230, 250)); // Lavender background

        // Adding buttons to the panel with gradient colors
        addButton(buttonPanel, "Display Products", this::displayProducts, new Color(70, 130, 180), new Color(0, 0, 128));
        addButton(buttonPanel, "Add Product", this::addProduct, new Color(50, 205, 50), new Color(0, 128, 0));
        addButton(buttonPanel, "Update Activities", this::updateActivities, new Color(255, 69, 0), new Color(178, 34, 34));
        addButton(buttonPanel, "Vendor Report", this::vendorReport, new Color(255, 140, 0), new Color(255, 69, 0));
        addButton(buttonPanel, "Delete Product", this::deleteProduct, new Color(255, 0, 0), new Color(139, 0, 0));
        addButton(buttonPanel, "Search by Category", this::searchByCategory, new Color(0, 191, 255), new Color(0, 0, 205));

        mainPanel.add(buttonPanel, BorderLayout.SOUTH); // Add button panel to the main panel

        // Adding the main panel to the JFrame
        add(mainPanel);
    }

    // Method to add a button with specific properties to a container
    private void addButton(Container container, String text, ActionListener listener, Color baseColor, Color hoverColor) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        button.setBackground(baseColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);

        // Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(hoverColor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(baseColor);
            }
        });

        container.add(button); // Add button to the specified container
    }

    // Action event method to display products
    private void displayProducts(ActionEvent e) {
        outputTextArea.setText("");
        supermarketManager.displayProducts();
    }

    // Action event method to add a product
    private void addProduct(ActionEvent e) {
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField dateField = new JTextField();
        JTextField quantityField = new JTextField();

        // Panel for user input with a light gray background
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBackground(new Color(245, 245, 245)); // Light gray background
        panel.add(new JLabel("Product ID:"));
        panel.add(idField);
        panel.add(new JLabel("Product Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);
        panel.add(new JLabel("Date:"));
        panel.add(dateField);
        panel.add(new JLabel("Quantity:"));
        panel.add(quantityField);

        // Show input dialog and handle user input
        int result = JOptionPane.showConfirmDialog(null, panel, "Add Product",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                int productId = Integer.parseInt(idField.getText());
                String productName = nameField.getText();
                String productCategory = categoryField.getText();
                String productDate = dateField.getText();
                int productQuantity = Integer.parseInt(quantityField.getText());

                // Validate input for negative values
                if (productId < 0 || productQuantity < 0) {
                    throw new NumberFormatException();
                }

                // Create a new product and add it to the supermarketManager
                supermarketManager.createProduct(productId, productName, productCategory, productDate, productQuantity);

                // Display a confirmation message in the outputTextArea
                outputTextArea.append("Product added: " + productName + " (ID: " + productId + ")\n");
            } catch (NumberFormatException ex) {
                // Display an error message for invalid input
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numbers for ID and Quantity.");
            }
        }
    }

    // Action event method to update activities
    private void updateActivities(ActionEvent e) {
        JTextField productIdField = new JTextField();
        JTextField activityNameField = new JTextField();
        JTextField quantityField = new JTextField();
        JTextField dateField = new JTextField();

        // Panel for user input with a light gray background
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBackground(new Color(245, 245, 245)); // Light gray background
        panel.add(new JLabel("Product ID:"));
        panel.add(productIdField);
        panel.add(new JLabel("Activity Name (Add to stock/Remove from stock):"));
        panel.add(activityNameField);
        panel.add(new JLabel("Quantity:"));
        panel.add(quantityField);
        panel.add(new JLabel("Date:"));
        panel.add(dateField);

        // Show input dialog and handle user input
        int result = JOptionPane.showConfirmDialog(null, panel, "Update Activities",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                int productId = Integer.parseInt(productIdField.getText());
                String activityName = activityNameField.getText();
                int activityQuantity = Integer.parseInt(quantityField.getText());
                String activityDate = dateField.getText();

                // Validate input for negative values
                if (activityQuantity < 0) {
                    throw new NumberFormatException();
                }

                // Create a new activity and update activities in the supermarketManager
                Activities activity = new Activities(supermarketManager.getNextActivityId(), activityName, activityQuantity, activityDate);
                supermarketManager.updateActivities(productId, activity);

                // Display a confirmation message in the outputTextArea
                outputTextArea.append("Activity updated for Product ID " + productId + "\n");
            } catch (NumberFormatException ex) {
                // Display an error message for invalid input
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number for Quantity.");
            }
        }
    }

    // Action event method to display a vendor report
    private void vendorReport(ActionEvent e) {
        JTextField productIdField = new JTextField();

        // Panel for user input with a light gray background
        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 10));
        panel.setBackground(new Color(245, 245, 245)); // Light gray background
        panel.add(new JLabel("Product ID:"));
        panel.add(productIdField);

        // Show input dialog and handle user input
        int result = JOptionPane.showConfirmDialog(null, panel, "Vendor Report",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                int productId = Integer.parseInt(productIdField.getText());
                outputTextArea.setText("");
                supermarketManager.displayVendorReport(productId);
            } catch (NumberFormatException ex) {
                // Display an error message for invalid input
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number for Product ID.");
            }
        }
    }

    // Action event method to delete a product
    private void deleteProduct(ActionEvent e) {
        JTextField productIdField = new JTextField();

        // Panel for user input with a light gray background
        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 10));
        panel.setBackground(new Color(245, 245, 245)); // Light gray background
        panel.add(new JLabel("Product ID:"));
        panel.add(productIdField);

        // Show input dialog and handle user input
        int result = JOptionPane.showConfirmDialog(null, panel, "Delete Product",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                int productId = Integer.parseInt(productIdField.getText());
                // Delete the product with the specified ID from the supermarketManager
                supermarketManager.deleteProduct(productId);
                // Display a confirmation message in the outputTextArea
                outputTextArea.append("Product with ID " + productId + " deleted.\n");
            } catch (NumberFormatException ex) {
                // Display an error message for invalid input
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number for Product ID.");
            }
        }
    }

    // Action event method to search products by category
    private void searchByCategory(ActionEvent e) {
        JTextField categoryField = new JTextField();

        // Panel for user input with a light gray background
        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 10));
        panel.setBackground(new Color(245, 245, 245)); // Light gray background
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);

        // Show input dialog and handle user input
        int result = JOptionPane.showConfirmDialog(null, panel, "Search by Category",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String category = categoryField.getText();
            outputTextArea.setText("");
            // Display products by category sorted by quantity in the outputTextArea
            supermarketManager.displayProductsByCategory(category);
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        // Create and make the GUI visible
        SwingUtilities.invokeLater(() -> new SupermarketGUI().setVisible(true));
    }
}
