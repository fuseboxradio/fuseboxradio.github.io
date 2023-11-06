import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList; 
import java.util.*;
import java.util.concurrent.ThreadLocalRandom; // using for the creation of random numbers for the program

class ProductShelf {
    private String productName;
    private int minThreshold;
    private int maxThreshold;
    private int currentCount;
    private List<Notification> notifications;
    private Date markdownDate;
    private List<Product> products;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    // Constructor for the ProductShelf class

    public ProductShelf(String productName, int minThreshold, int maxThreshold, Date markdownDate) throws ParseException {
        this.productName = productName;
        this.minThreshold = minThreshold;
        this.maxThreshold = maxThreshold;
        this.currentCount = 0;
        this.notifications = new ArrayList<>();
        this.markdownDate = markdownDate;
        this.products = new ArrayList<>();
                
        Product product = new Product("Product A", 0, markdownDate, 0);
        
    }
    
    // Method to add products to the shelf and send notifications if necessary
  
    public void addToShelf(int quantity) {
        currentCount += quantity;
        if (currentCount >= maxThreshold) {
            sendNotification("Replenish required!");
        }
    }
    
    // Method to remove products from the shelf and send notifications if necessary

    public void removeFromShelf(int quantity) {
        currentCount -= quantity;
        if (currentCount <= minThreshold) {
            sendNotification("Stock is running low.");
        }
    }
    

    // Method to send a notification and save it to a database
    
    public void sendNotification(String message) {
        Date timestamp = new Date();
        Notification notification = new Notification(productName, timestamp, message);
        notifications.add(notification);
        // Save this information to the database
        saveToDatabase(notification);
    }
    
    // Helper method to send our a markdown notification and save it to a database

    public void sendMarkdownNotification(String message) {
        Date timestamp = new Date();
        Notification notification = new Notification(productName, timestamp, message);
        notifications.add(notification);
        // Save this information to the database
        saveToDatabase(notification);
    }
    
    // Method to create a new product for the store and add it to the shelves

    public void createProduct(String productName, int productId, Date expiryDate, int timeDurationForMarkdown) {
        try {
            if (productExists(productId)) {
                System.out.println("Product with the same ProductID already exists. ProductName should have a unique ID.");
            } else {
                if (expiryDate == null) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.MONTH, 3);
                    expiryDate = calendar.getTime();
                }
                if (timeDurationForMarkdown == 0) {
                    timeDurationForMarkdown = ThreadLocalRandom.current().nextInt(1, 10);
                }

                Product newProduct = new Product(productName, productId, expiryDate, timeDurationForMarkdown);
                products.add(newProduct);

                System.out.println(productName + " with ProductID " + productId + " created successfully.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    // Helper method to check if a product with the same ProductID already exists in the system

    private boolean productExists(int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return true;
            }
        }
        return false;
    }
    
    // Helper method to save a notification to a database (not implemented here)

    private void saveToDatabase(Notification notification) {
        // Implement your database saving logic here
        // For simplicity, we'll just print the data to the console in this example.
        System.out.println("Saved to database - " + notification);
    }

    // Method to display a listing of products that need replenishing
    
    public void displayProductToRefill() {
        boolean replenishRequired = false;
        for (Product product : products) {
            if (product.getQuantity() < minThreshold) {
                System.out.println("Product: " + product.getProductName() + " (ProductID: " + product.getProductId() + ") needs replenishing. Quantity to replenish: " + (maxThreshold - product.getQuantity()));
                replenishRequired = true;
            }
        }
        if (!replenishRequired) {
            System.out.println("No products need replenishing at this time.");
        }
    }

    // Overloaded method to display information for a specific product that needs replenishing
    
    public void displayProductToRefill(int productId) {
        Product product = getProductById(productId);
        if (product != null) {
            if (product.getQuantity() < minThreshold) {
                System.out.println("Product: " + product.getProductName() + " (ProductID: " + product.getProductId() + ") needs replenishing. Quantity to replenish: " + (maxThreshold - product.getQuantity()));
            } else {
                System.out.println("Product: " + product.getProductName() + " (ProductID: " + product.getProductId() + ") does not need replenishing at this time.");
            }
        } else {
            System.out.println("Product with ProductID " + productId + " not found.");
        }
    }

    // Method to display the current count of all products on the shelf

    void displayProductCount() {
        if (products.isEmpty()) {
            System.out.println("No products on the shelf.");
        } else {
            for (Product product : products) {
                System.out.println("Product: " + product.getProductName() + " (ProductID: " + product.getProductId() + ") - Quantity: " + product.getQuantity());
            }
        }
    }
    
    // Display the count of a specific product on the store shelves

    public void displayProductCount(int productId) {
        Product product = getProductById(productId);
        if (product != null) {
            System.out.println("Product: " + product.getProductName() + " (ProductID: " + product.getProductId() + ") - Quantity: " + product.getQuantity());
        } else {
            System.out.println("Product with ProductID " + productId + " not found.");
        }
    }
    
    // To display the expiry/expiration dates of all of the store shelves' products

    public void displayProductsExpiryDate() {
        if (products.isEmpty()) {
            System.out.println("No products on the shelf.");
        } else {
            for (Product product : products) {
                System.out.println("Product: " + product.getProductName() + " (ProductID: " + product.getProductId() + ") - Expiry Date: " + dateFormat.format(product.getExpiryDate()));
            }
        }
    }
    
    // To display the expiry/expiration date of a specific product on the store shelves

    public void displayProductsExpiryDate(int productId) {
        Product product = getProductById(productId);
        if (product != null) {
            System.out.println("Product: " + product.getProductName() + " (ProductID: " + product.getProductId() + ") - Expiry Date: " + dateFormat.format(product.getExpiryDate()));
        } else {
            System.out.println("Product with ProductID " + productId + " not found.");
        }
    }

    // To display a list of the current expired products on the store's shelves

    public void displayExpiredProducts() {
        boolean expiredProductsFound = false;
        for (Product product : products) {
            if (product.getExpiryDate().before(new Date())) {
                System.out.println("Product: " + product.getProductName() + " (ProductID: " + product.getProductId() + ") has expired on " + dateFormat.format(product.getExpiryDate()));
                expiredProductsFound = true;
            }
        }
        if (!expiredProductsFound) {
            System.out.println("No expired products on the shelf.");
        }
    }

    // To display a list of products that need to be marked down in the near future
    
    public void displayProductsInMarkDown() {
        boolean markdownProductsFound = false;
        for (Product product : products) {
            Calendar currentDate = Calendar.getInstance();
            Calendar markdownDate = Calendar.getInstance();
            markdownDate.setTime(product.getExpiryDate());
            markdownDate.add(Calendar.DAY_OF_MONTH, -product.getTimeDurationForMarkdown());
            if (currentDate.after(markdownDate)) {
                System.out.println("Product: " + product.getProductName() + " (ProductID: " + product.getProductId() + ") needs to be marked down.");
                markdownProductsFound = true;
            }
        }
        if (!markdownProductsFound) {
            System.out.println("No products need to be marked down at this time.");
        }
    }
    
    // To display products that will need be marked down in a week

    public void displayProductsForMarkDown() {
        boolean productsForMarkdownFound = false;
        Calendar oneWeekFromNow = Calendar.getInstance();
        oneWeekFromNow.add(Calendar.DAY_OF_MONTH, 7);
        for (Product product : products) {
            Calendar markdownDate = Calendar.getInstance();
            markdownDate.setTime(product.getExpiryDate());
            markdownDate.add(Calendar.DAY_OF_MONTH, -product.getTimeDurationForMarkdown());
            if (markdownDate.after(Calendar.getInstance()) && markdownDate.before(oneWeekFromNow)) {
                System.out.println("Product: " + product.getProductName() + " (ProductID: " + product.getProductId() + ") will be marked down in a week.");
                productsForMarkdownFound = true;
            }
        }
        if (!productsForMarkdownFound) {
            System.out.println("No products need to be marked down in the coming week.");
        }
    }

    // Helper method to get a product by its ProductID
    
    private Product getProductById(int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

	public void add(Product product) {
		// TODO Auto-generated method stub
		
	}

	public List<Product> getProducts() {
		return products;
	}
}

//Notification class to store product-related notifications

class Notification {
    private String productName;
    private Date timestamp;
    private String message;

    // Constructor for the Notification class
    
    public Notification(String productName, Date timestamp, String message) {
        this.productName = productName;
        this.timestamp = timestamp;
        this.message = message;
    }

    // Custom toString method to display the notification details
    
    @Override
    public String toString() {
        return "Product: " + productName + ", Timestamp: " + timestamp + ", Message: " + message;
    }
}

//Product class to represent individual products

class Product {
    private String productName;
    private int productId;
    private Date expiryDate;
    private int timeDurationForMarkdown;
    private int quantity;
    

    public Product(String productName, int productId, Date expiryDate, int timeDurationForMarkdown) {
        this.productName = productName;
        this.productId = productId;
        this.expiryDate = expiryDate;
        this.timeDurationForMarkdown = timeDurationForMarkdown;
        this.quantity = ThreadLocalRandom.current().nextInt(0, 30); // Random initial quantity of items to stimulate what would happen with a store or warehouse of products due to sales, returns, etc.
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public int getTimeDurationForMarkdown() {
        return timeDurationForMarkdown;
    }

    public int getQuantity() {
        return quantity;
    }
       
    }
   
// Establishing the main class for the application

public class MrKStore {
		
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date markdownDate;
        try {
            markdownDate = dateFormat.parse("2023-01-15");
        } catch (Exception e) {
            markdownDate = new Date();
        }
        ProductShelf productShelf = new ProductShelf("Sample Product", 10, 50, markdownDate);
        
        List<Product> products = new ArrayList<>(); 
        
        // Version 2.0 would have an active array list and/or database to connect to with products currently in the system
                     
        Scanner scanner = new Scanner(System.in); // Create a scanner for user input to make menu selections   
        
        System.out.println("Welcome to the Mister K Mini-Product Management System (Sandbox Edition)!");

        while (true) {
            System.out.println("\r"+ "Please select one of the options below:" + "\r");
            System.out.println("1. Create New Product(s) To Stock In The Store [Input 3 Test Items Before Moving Into The Next Steps]");
            System.out.println("2. Display The Current Product Count On The Store Shelves");
            System.out.println("3. Display Products That Need To Be Replenished");
            System.out.println("4. Display Product Count [based on the ProductID #]");
            System.out.println("5. Display The Expiry/Expiration Dates Of Current In Stock Products");
            System.out.println("6. Display The Expiry/Expiration Date [based on ProductID #]");
            System.out.println("7. Display List Of All Expired Products");
            System.out.println("8. Display List Of Products For Markdown");
            System.out.println("9. Display List Of Products That Will Be Marked Down In A Week");
            System.out.println("10. Exit The Program");
            System.out.print("\r" + "Please Enter Your Choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
            
                case 1:
                    System.out.print("Enter product name: ");
                    String productName = scanner.next();
                    System.out.print("Enter ProductID: ");
                    int productId = scanner.nextInt();
                    System.out.print("Enter expiry/expiration date (yyyy-MM-dd) [3 months after today's date]: ");
                    String expiryDateStr = scanner.next();
                    Date expiryDate;
                    if (expiryDateStr.isEmpty()) {
                        expiryDate = null;
                    } else {
                        try {
                            expiryDate = dateFormat.parse(expiryDateStr);
                        } catch (Exception e) {
                            System.out.println("Invalid date format. Using default.");
                            expiryDate = null;
                        }
                    }
                    System.out.print("Enter In TheF Time Duration By Days For Product Price Markdown [enter in 7 days UNLESS you have recieved written manager approval that has been uploaded previously into our system]: ");
                    int timeDurationForMarkdown = scanner.nextInt();
                    productShelf.createProduct(productName, productId, expiryDate, timeDurationForMarkdown);
                    break;
                    
                case 2:
                	 productShelf.getProducts();
                     break;
                     
                case 3:
                    productShelf.displayProductToRefill();
                    break;
                    
                case 4:
                    System.out.print("Enter ProductID: ");
                    int productID = scanner.nextInt();
                    productShelf.displayProductCount(productID);
                    break;
                    
                case 5:
                    productShelf.displayProductsExpiryDate();
                    break;
                    
                case 6:
                    System.out.print("Enter ProductID: ");
                    int productID2 = scanner.nextInt();
                    productShelf.displayProductsExpiryDate(productID2);
                    break;
                    
                case 7:
                    productShelf.displayExpiredProducts();
                    break;
                    
                case 8:
                    productShelf.displayProductsInMarkDown();
                    break;
                    
                case 9:
                    productShelf.displayProductsForMarkDown();
                    break;
                    
                case 10:
                    scanner.close();
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid choice. Please select a valid option. Thank you!!");
            }
        }
    }
}
