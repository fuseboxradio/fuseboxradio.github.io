import java.util.ArrayList; // Java Framework to create and manage array lists
import java.util.HashMap; // Java Framework to store key-value pairs and provides efficient look-up and retrieval of values based on their keys
import java.util.List;
import java.util.Map;
import java.util.Scanner; // Java Framework so a user can input information for a response via the program

// CURRENT VERSION OF SAM'S CLUB STORE INVENTORY MANAGEMENT PROGRAM ASSIGNMENT VIA TECHBRIDGE (DUE 11/5/2023); FIRST VERSION (1.0)

// ADDITIONS TO ADD FOR FUTURE: 

// 1. GUI (GRAPHIC INTERFACE) + INTEGRATION INTO CURRENT SYSTEM; CURRENT VERSION IS ALL BACKEND CODE
// 2. BEING ABLE TO ADD ONTO GENERAL INVENTORY LIST VIA THE STORE ADMIN FUNCTION; CURRENTLY HAVE STORE STAFF ABLE TO SUGGEST ADDITIONS TO STORE MANAGER & ABOVE
// 3. BEING ABLE TO USE API OR EXISTING DATABASE TO PULL UP MORE DETAILED ITEM INFORMATION; TEST PROGRAM IS CURRENTLY USING A SYSTEM BASED OFF OF ARRAYS; TRIED TO START OFF ON THAT END AND IT DID NOT WORK WELL BEFORE GOING INTO AN ALTERNATE ROUTE TO HAVE A FUNCTIONAL FIRST DRAFT OF THE PROGRAM
// 4. EXPANSTION OF USERS, TYPES AND ROLES FOR VARIOUS LEVELS OF ACCESS
// 5. BEING ABLE TO GO BACK INTO MAIN MENU PRE-EXITING

class InventoryItem {
	// private class for creating an item for the store's inventory
	
    private String name; //item name is defined by a string
    private int quantity; // number of the item is defined by an integer
    private double price; // item price is defined by a double
    private String suppliername; //supplier name is defined by a string


    public InventoryItem(String name, int quantity, double price, String suppliername) {
    	// for creating a store inventory array
    	
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.suppliername = suppliername;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
    
    public String getSupplierName() {
        return suppliername;
    }


    public void updateQuantity(int soldQuantity) {
        if (soldQuantity <= quantity) {
            quantity -= soldQuantity; 
            // if the amount of an item sold is less than or equal to the current quantity in stock, then the current quantity of the item is the past quantity minus the sold amount
            
        } else {
        	// otherwise, the line will print below letting people know there is not enough of the item available to sale at that time
        	
            System.out.println("There is presently not enough of the item available to fulfill the sale.");
        }
    }
}

class Store { 
	// private class and variables for creating a store
    private String name;
    private String city;
    private String state;
    private String phoneNumber;
    private String type;
    private String openingDate;

    public Store(String name, String state, String city, String phoneNumber, String type, String openingDate) {
    	// for creating a store array
        this.name = name;
        this.state = state;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.openingDate = openingDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }
    
    
    // creation of a method to check if the entered in store information matches the entered in search criteria
    
    public boolean matchesSearchCriteria(String location, String type, String date, String name) {
        boolean locationMatches = location.isEmpty() || (state.equalsIgnoreCase(location) && city.equalsIgnoreCase(name));
        boolean typeMatches = type.isEmpty() || this.type.equalsIgnoreCase(type);
        boolean dateMatches = date.isEmpty() || openingDate.equalsIgnoreCase(date);
        boolean nameMatches = name.isEmpty() || this.name.equalsIgnoreCase(name);

        return locationMatches && typeMatches && dateMatches && nameMatches;
    }

    @Override
    public String toString() {
        return "Store Name: " + name + "\nLocation: " + state + ", " + city + "\nPhone Number: " + phoneNumber
                + "\nStore Type: " + type + "\nOpening Date: " + openingDate;
    }
}

class User {
	// private class to create a user and their role for the store management system
    private String username;
    private String role;

    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Username: " + username + "\nRole: " + role;
    }
}

public class StoreManagementDos {
    private static List<InventoryItem> inventory = new ArrayList<>(); 
    // creation of an array list where we can start out with a few items and be able to add new ones in accordingly as per the store manager's request
    
    private static ArrayList<Store> stores = new ArrayList<>(); 
    // creation of an array list where we can start engaging in the creation of stores
    
    private static ArrayList<User> users = new ArrayList<>();
    // creation of an array list to store users by username and typed in role by a store administrator
    
    static Map<String, String> userRoles = new HashMap<>(); 
    // creation of a list via a Hash Map to store user roles  
  
    private static int purchaseOrderCounter = 1; 
    // setting up the number to start off the purchase order numbering system
    
    public static void listAllStores() {
    	
    	// to list all of the current franchise stores
        System.out.println("List of All Our Current Stores:" + "\r");
        for (Store store : stores) {
            System.out.println(store);
            System.out.println("------------------------------");
        }
    }
    
    
    public static void listAllUsers() {
    	// to list all of the current management system users
    	
        System.out.println("List of All Our Current Managment System Users:" + "\r");
        for (User user : users) {
            System.out.println(user);
            System.out.println("------------------------------");
        }
    }
    

    public static void deleteStore(String storeName) {
        // Creating a method to be able to delete stores via the store admin function

        Store storeToDelete = null;
        for (Store store : stores) {
            if (store.getName().equalsIgnoreCase(storeName)) {
                storeToDelete = store;
                break;
            }
        }
        
        if (storeToDelete != null) {
            stores.remove(storeToDelete);
            System.out.println("Store information deleted successfully.");
        } else {
            System.out.println("Store not found. Deletion failed.");
        }
    }


    public static void main(String[] args) {
        // Creating the store's (an artisanal cocktail mini-mart) basic inventory with 5 items by name, amount, price and supplier with an array list
    	// For the example run of this program, there are 200 of each item 
     
    	inventory.add(new InventoryItem("Luxury Lime Juice", 200, 10.99, "Juice World"));
        inventory.add(new InventoryItem("Gatsby's Ginger Ale", 200, 19.99, "Soda Central"));
        inventory.add(new InventoryItem("Velvet Vodka", 200, 5.99, "ABC Store"));
        inventory.add(new InventoryItem("Sumptuous Lime Slices", 200, 7.49, "Fantastic Fruits"));
        inventory.add(new InventoryItem("Sir The Ice Silver Spoon", 200, 12.99, "Useful Utensils"));
        
        // Creating a starter list of 5 stores by name, city, state, phone number, type and open date with an array list
        
     	stores.add(new Store("Store Uno", "My Town", "MD", "123-456-7890", "retail", "01/02/23"));
     	stores.add(new Store("Store Dos", "Your Place", "DC", "789-654-3210", "warehouse", "03/02/13"));
     	stores.add(new Store("Store Tres", "Her Spot", "VA", "123-456-7895", "retail", "01/02/23"));
     	stores.add(new Store("Store Four", "That Place", "NY", "123-458-7890", "retail", "06/02/00"));
     	stores.add(new Store("Store Cinco", "His Locale", "CA", "555-456-7890", "retail", "01/02/20"));
      
        // Creating a starter list of 5 users by name [First and Last Name] & user role
     	
     	users.add(new User("A Person", "admin"));
     	users.add(new User("That Guy", "manager"));
     	users.add(new User("This Individual", "manager"));
     	users.add(new User("G Status", "staff"));
     	users.add(new User("Teach Alot", "staff"));

     	
        Scanner scanner = new Scanner(System.in);

        // Welcome message + opening menu of the store management program
        
        System.out.println("Welcome to the Moscow Mule Mini-Mart Store Management System!");
        System.out.print("\rPlease select if you are a store manager (M), a store staff member (S), store administrator (A) or want to exit the program (Q): ");
        System.out.print("\rEnter M, S, A or Q: ");
        String userType = scanner.nextLine();
        
        // what happens when one enters in a letter
        // .equalsIgnoreCase () = can enter in a letter either via upper or lowercase to move to the next step of the program

        if (userType.equalsIgnoreCase("M")) {
            storeManagerMenu(scanner); 
            // if you select the manager option ("M"), you will go to the manager menu options and respective functions
            
        } else if (userType.equalsIgnoreCase("S")) {
            storeStaffMenu(scanner); 
            // if you choose the store staff option ("S"), you will to go the store staff menu option and respective functions
            
        } else if (userType.equalsIgnoreCase("A")) {
            storeAdminMenu(scanner); 
            // if you choose the store admin option ("A"), you will go to the store administrator menu option and respective functions
            
        } else if (userType.equalsIgnoreCase("Q")) {
            storeExitMenu(scanner); 
            // if you choose the quit option ("Q"), you will exit the program
            
        } else {
            System.out.println("You have chosen an invalid user type. Exiting the program...goodbye!"); // if you choose neither option, then you will be told that is an invalid selection and automatically kicked out of the program
        } 
    }

    // Establishing the Store Manager menu and access post-selection //
    
    private static void storeManagerMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nStore Manager Menu: ");
            System.out.println("1. View The Current Store Inventory");
            System.out.println("2. Add Special Items To The Store's Inventory");
            System.out.println("3. Enter In The Amount Of Items Sold In Bulk At The Store [Manager Approval Only] For Inventory Update");
            System.out.println("4. Create A Purchase Order Of Our Currently Available Inventory Items");
            System.out.println("5. Exit The Program");
            System.out.print("\rPlease Enter Your Choice (1, 2, 3, 4 or 5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            // Select a number so that one can move into the switch statement to get into the next function for the store manager

            switch (choice) {
                case 1:
                    viewInventory();
                    break;
                case 2:
                    itemAdditionToStore(scanner);
                    break;
                case 3:
                    updateItemQuantities(scanner);
                    break;
                case 4:
                    generatePurchaseOrder(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the program...Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Establishing the Store Staff menu and access post-selection //
    
    
    private static void storeStaffMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nStore Staff Menu");
            System.out.println("1. View the Current Shift's Latest Store Inventory List");
            System.out.println("2. Make A Sale");
            System.out.println("3. View the Amount of Items In Stock [post- the current amount of today's sales] ");
            System.out.println("4. Request a New Item for the Store Manager to Order");
            System.out.println("5. Exit the Program");
            System.out.print("\rPlease Enter Your Choice (1, 2, 3, 4 or 5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            // Select a number so that one can move into the switch statement to get into the next function for the store staff

            switch (choice) {
                case 1:
                    viewInventory();  // Displays opening day inventory in stock
                    break;
                case 2:
                    makeSale(scanner); // Execute a sale 
                    break;
                case 3:
                    viewInventory(); // Displays the inventory post-sales
                    break;
                case 4:
                    requestItemForOrder(scanner); // Request Item for Store Manager to Order
                    break;
                case 5:
                    System.out.println("Exiting the program...thank you!"); // exiting the program and stopping the program
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again."); 
                    // lets the member know that the selected number is invalid for the program to function.
            }
        }
    }
    
    //  when a user has chosen to exit the program

    private static void storeExitMenu(Scanner scanner) {
        while (true) {
            System.out.println("You are now exiting the store program. Have a great day!");
            break;
        }
        	
        }
    

    // Establishing the Store Admin menu and access post-selection //
    
    private static void storeAdminMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nStore Administrator Menu");
            System.out.println("\r" + "1. Create A New Store");
            System.out.println("2. Updating Store Information");
            System.out.println("3. Deleting An Existing Store's Information");
            System.out.println("4. List All Of Our Current Stores");
            System.out.println("5. Search For Stores");
            System.out.println("6. Manage Store Management System Users");
            System.out.println("7. Enter In The Amount Of Items To Order [Store Admin Approval Only]");
            System.out.println("8. Exit");
            System.out.print("\r" + "Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            // Select a number so that one can move into the switch statement to get into the next function for the store admin

            ArrayList<Store> stores = new ArrayList<>(); 
            
            switch (choice) {
            case 1:
            	//  creating a new store
            	
                System.out.println("Create A New Store");
                System.out.print("\r" + "Enter New Store Name: ");
                String name = scanner.nextLine();
                
                System.out.print("Enter State [state abbreviation only please]: ");
                String state = scanner.nextLine();
                
                System.out.print("Enter City: ");     
                String city = scanner.nextLine();
                System.out.print("Enter Phone Number [XXX-XXX-XXXX format]: ");
                
                String phoneNumber = scanner.nextLine();
                System.out.print("Enter Store Type (retail or warehouse): ");
                String type = scanner.nextLine();
                
                System.out.print("Enter Opening Date by month, date and year format [ex. 01/02/1989]: ");
                String openingDate = scanner.nextLine();

                Store newStore = new Store(name, state, city, phoneNumber, type, openingDate);
                stores.add(newStore);
                System.out.println("Store created successfully!");
                break;

            case 2:
            	
            	// updating a store's information
            	
                System.out.println("Updating Store Information");
                System.out.print("\r"+ "Enter Store Name to Update: ");
                // first have to enter in the store's original name to update the respective information
                
                String storeNameToUpdate = scanner.nextLine();

                boolean storeFound = false;
                for (Store store : stores) {
                    if (store.getName().equalsIgnoreCase(storeNameToUpdate)) {
                        System.out.print("Enter New Store Name: ");
                        store.setName(scanner.nextLine());
                        
                        System.out.print("Enter New City: ");
                        store.setCity(scanner.nextLine());
                        
                        System.out.print("Enter New State [state abbreviation only please]: ");
                        store.setState(scanner.nextLine());
                    
                        System.out.print("Enter New Phone Number [XXX-XXX-XXXX format]: ");
                        store.setPhoneNumber(scanner.nextLine());
                        
                        System.out.print("Enter New Store Type (retail or warehouse): ");
                        store.setType(scanner.nextLine());
                        
                        System.out.print("Enter New Opening Date by month, date and year format [ex. 01/02/1989]: ");
                        store.setOpeningDate(scanner.nextLine());

                        System.out.println("Store updated successfully!");
                        storeFound = true;
                        break;
                    }
                }

                if (!storeFound) {
                	// if the store is not found, an error message will appear
                	
                    System.out.println("I'm sorry, we could not find that store's information.");
                }
                break;

            case 3:
            	
            	// deleting a store's information
            	
            	System.out.println("Deleting An Existing Store's Information");
                System.out.print("\r" + "Please enter in the Store Name to Delete: ");
                String storeNameToDelete = scanner.nextLine();
                deleteStore(storeNameToDelete);
                break;
               
            case 4:
            	// listing all of the current stores
            	
            	 listAllStores();
                 break;

            case 5:
            	// to search for stores
            	
                System.out.println("Search for Stores");
                
                System.out.print("\r" + "Enter Store Name: ");
                String searchName = scanner.nextLine();
                
                System.out.print("Enter Location (State and City): ");
                String searchLocation = scanner.nextLine();
                
                System.out.print("Enter Store Type (retail or warehouse): ");
                String searchType = scanner.nextLine();
                
                System.out.print("Enter Opening Date: ");
                String searchDate = scanner.nextLine();
                
            
                System.out.println("Matching Stores:");
                for (Store store : stores) {
                    if (store.matchesSearchCriteria(searchLocation, searchType, searchDate, searchName)) {
                        System.out.println(store);
                        System.out.println("------------------------------");
                    }
                }
                break;

            case 6:
            	// menu to enaage in user management, now have to basically nest a swich statement within a switch statement
            	
                System.out.println("User Management");
                System.out.println("\r" + "1. Create A New User");
                System.out.println("2. Update A Current User's Role");
                System.out.println("3. Delete A Current User");
                System.out.println("4. List All Of The Management System's Current Users");
                System.out.print("\r" + "Select an option: ");

                int userChoice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                
                ArrayList<User> users = new ArrayList<>();

                switch (userChoice) {
                    case 1:
                        System.out.println("\r" + "Creating A New User");
                        System.out.print("\r" + "Enter User Name (First & Last Name): ");
                        String username = scanner.nextLine();
                        
                        System.out.print("Select the User's Role (admin, manager or staff): ");
                        String role = scanner.nextLine();

                        User newUser = new User(username, role);
                        users.add(newUser);
                        userRoles.put(username, role); 
                        // Stores the entered in new user's name & role information into the Hashmap
                        
                        System.out.println("Thank you! The new user has been created successfully!");
                        break;

                    case 2:
                        System.out.println("Updating A User's Role");
                        System.out.print("\r" + "Enter User Name to Update (First and Last Name): ");
                        String usernameToUpdate = scanner.nextLine();

                        boolean userFound = false;
                        for (User user : users) {
                            if (user.getUsername().equalsIgnoreCase(usernameToUpdate)) {
                                System.out.print("Enter In The New Role for the User (admin, manager or staff): ");
                                String newRole = scanner.nextLine();
                                user.setRole(newRole);
                                userRoles.put(user.getUsername(), newRole); // Update user's role in the map
                                System.out.println("Thanks! The User's Role has been Updated Successfully!");
                                userFound = true;
                                break;
                            }
                        }

                        if (!userFound) {
                            System.out.println("Sorry, that user was not found in our system.");
                        }
                        break;

                    case 3:
                        System.out.println("Deleting A User");
                        System.out.print("\r" + "Enter User's Name [First and Last Name] to delete them from our system: ");
                        String usernameToDelete = scanner.nextLine();

                        for (User user : users) {
                            if (user.getUsername().equalsIgnoreCase(usernameToDelete)) {
                                users.remove(user);
                                userRoles.remove(user.getUsername()); 
                                // Remove user's name and role from the hashmap
                                System.out.println("Thank you! The user's information has been deleted successfully!");
                                break;
                            }
                        }
                        break;

                    case 4:
                       // prints out a listing of all of the system's current users
                   	 listAllUsers();
                        break;

                    default:
                        System.out.println("Invalid User Management Option - please try again!");
                        break;
                }
                break;

            case 7:
                generatePurchaseOrder(scanner);
                break;
                
            case 8:
                System.out.println("Exiting Store Management System");
                scanner.close();
                System.exit(0);
                break;
                
            default:
                System.out.println("Invalid option. Please select a valid option.");
        }
    }
}


    // For the manager and store staff to be able to view the current inventory in stock
    
    private static void viewInventory() {
        System.out.println("\nCurrent Store Inventory:" + "\r");
        for (InventoryItem item : inventory) {
            System.out.println("Name: " + item.getName() + ", Quantity: " + item.getQuantity() + ", Price: $" + item.getPrice());
        }
    }

    // For the store manager to be able to request new items to add into the inventory
    // Once the item is requested by the manager, both the store staff and the store manager will be able to see the latest inventory
    
    private static void itemAdditionToStore(Scanner scanner) {
        System.out.println("\rAdd new items to the store inventory:");
        System.out.print("\r" + "1. Enter in the requested item name: ");
        String name = scanner.nextLine();
        
        System.out.print("2. Enter number of the requested item to add: ");
        int quantity = scanner.nextInt();
        
        System.out.print("3. Enter item price (no Dollar [$] sign please): ");
        double price = scanner.nextDouble();
        
        System.out.print("3. Enter the supplier name (if you do not know it, enter 'N/A'; our staff will research and put in that information post-order in our database for later discovery): ");
        String suppliername = scanner.nextLine();
		inventory.add(new InventoryItem(name, quantity, price, suppliername));
		
        System.out.println("Your item request has been submitted and processed to add into the inventory. They will be delivered to your location via express delivery from the supplier to the store before COB today and the order will reflect in our updated store inventory list (which you can see by choosing '1'. Thank you!!");
    }

    //  To show the updated amount of items in the inventory post store staff sales
    
    private static void updateItemQuantities(Scanner scanner) {
        System.out.println("\nUpdating Item Quantities After Sales");
        System.out.print("\r" + "Please enter item name of the item available (sales over 50+ must be executed by a manager): ");
        String itemName = scanner.nextLine();
        InventoryItem item = findItemByName(itemName);

        if (item != null) {
            System.out.print("Please enter number of the items sold: ");
            int soldQuantity = scanner.nextInt();
            item.updateQuantity(soldQuantity);
            System.out.println("Thank you for that information - the post-sale inventory has been updated. Please go back to choice #1 for the updated inventory listing.");
        } else {
            System.out.println("Sorry - the entered item has not been found in our inventory.");
        }
    }

    // To execute the sales of the item by a store staff member
    
    private static void makeSale(Scanner scanner) {
        System.out.println("\nMake A Sale");
        System.out.print("\r" + "Please Enter In The Name of the Item Being Sold Today: ");
        String itemName = scanner.nextLine();
        InventoryItem item = findItemByName(itemName);

        if (item != null) {
            System.out.print("Thank you! \rNext, please Enter In The Number Of The Item(s) Being Sold [maximum 10 by store staff]: ");
            int soldQuantity = scanner.nextInt();

            if (soldQuantity > 0 && soldQuantity <= item.getQuantity()) {
                item.updateQuantity(soldQuantity);
                double totalAmount = soldQuantity * item.getPrice();
                System.out.println("\r" + "Great and Thank You! The sale has been completed and the reciept is being printed for the customer." + "\r" + "Total Amount: $" + totalAmount + "\r" + "You will now return to the main store staff menu.");
            } else {
                System.out.println("Either There Is An Invalid Quantity Of The Item or the Item Is Not Available. Please enter a valid number of the item(s) to sell for the customer.");
            }
        } else {
            System.out.println("Unfortunately, that particular item is currently not available in our inventory at the moment.");
        }
    }
    
    // For a store manager to create a new Purchase Order

    private static void generatePurchaseOrder(Scanner scanner) { 
        System.out.println("\rCreate a Purchase Order [manager: mass orders over 200+ of an individual item only for special mega sale events; store admin has to approve orders above that number]");
        System.out.print("\r" + "Enter the item name you want to order: ");
        // print out a list of the items that are currently available
        String itemName = scanner.nextLine();
        InventoryItem item = findItemByName(itemName);

        if (item != null) {
            System.out.print("Enter the quantity to order: ");
            int quantityToOrder = scanner.nextInt();

            if (quantityToOrder > 0) {
                System.out.println("\rPurchase Order #" + purchaseOrderCounter++);
                System.out.println("Item: " + item.getName());
                System.out.println("Quantity to Order: " + quantityToOrder);
                System.out.println("Total Cost: $" + (quantityToOrder * item.getPrice()));
                System.out.println("\r" + "Thank you - your purchase order has been submitted!" + "\r" + "Today's Transaction:" + "$" + (quantityToOrder * item.getPrice()));

            } else {
                System.out.println("Invalid quantity to order. Please enter a valid quantity.");
            }
        } else {
            System.out.println("Item not found in inventory. Please check the item name.");
        }

    }
    
	// for a Store Staff member to request an order from the Store Manager
    
    private static void requestItemForOrder(Scanner scanner) {
        System.out.println("\nRequest/Suggest A New Item For The Store Manager To Order");
        System.out.print("\r" + "1. Enter the name of the item you want to request: ");
        String itemName = scanner.nextLine();

        // Checks to see if the requested item already exists in the inventory
        InventoryItem existingItem = findItemByName(itemName);

        if (existingItem != null) {
            System.out.println("We do have the current item as a part of our regular inventory to order on a regular basis. Thank you for the suggestion and please let us know whenever the items are running low or we need to get extra stock for special events!");
        } else {
            System.out.print("Thank you for suggesting this tiem for us to order! \rPlease enter the approximate amount we should start out with to have in stock: ");
            int quantityToOrder = scanner.nextInt();
            
            System.out.print("Please enter an approximate item price for the suggested item (no Dollar [$] sign please): ");
            double price = scanner.nextDouble();
            
            System.out.print("Please enter the supplier name, if you know it [if you do not, enter N/A]: ");
            String suppliername = scanner.nextLine();
            
			inventory.add(new InventoryItem(itemName, quantityToOrder, price, suppliername));
            System.out.println("Your item request has been submitted for ordering consideration. \rThe store manager will review and process your request as they come in and will be in touch if/when it will be ordered and delivered through an available supplier. \rThank you very much and you are returning back to the Store Staff menu!");
        }
    }


    private static InventoryItem findItemByName(String name) {
        for (InventoryItem item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
