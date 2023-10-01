import java.util.Random;

// Java DOES have a a random function that can be used in your code by importing the java.util.Random package. Decided to use this for creating the 20 food orders from our array information

//More information about that package is at Tutorials Point here: https://www.tutorialspoint.com/java/util/java_util_random.htm

// Class Assignment: I always dreamed of having a restaurant with 15 options on the menu, but don’t know what I want to put on it. I have decided to ask you to create the items and decide how much they will cost because I'm not very creative. 
// I need 5 appetizers, 5 entrees, and 5 desserts. And then the restaurant will begin taking orders. We are only willing to take 20 orders from the drive through. Customers are only able to order 1 item. Every time a car pulls up the drive through worker will have a script to read and the menu must appear.
//After all 20 orders happen, a summary must appear with this information:
// 1. Total money made
// 2. Percentage of sales for each item.
// 3. A list of items ordered with the number of times they are ordered.

public class MMFoodRestaurantSoftOpening {
// With the edit for the program to include the script of what the staff would day for the restaurant soft open + showing the menu display pre-order (along with my current playlist), I have decided to change up the public class name... 

    public static void main(String[] args) {
        
          //Creating the first array for the food spot's menu prices for our 15 offerings; using a double for the monetary values which would be dollars and cents

        double[] cafePrice = {
            8.00, 3.00, 2.00, 4.00, 12.00, 50.00, 35.00, 25.00, 15.00, 20.00, 7.50, 5.75, 6.00, 10.00, 8.25
        };

 // Creating the second array for the food spot's 15 culinary offerings; these are strings since we're listing the name/description of the items

        String[] foodItems = {
            "Khili Kon Karne", "Benzi Box Brussel Sprouts", "Frenz French Fries", "Iron Rose Nachos", "2 Strings Charcuterie", "Old School Prime Rib",
            "KMD Swordfish", "Baked Chicken Gumbo", "The Original Roasted Portabello Mushrooms", "Orange Blossoms Pork Roast",
            "Red & Gold Cherry Cheesecake", "Chocolate Chip Kookies", "Benzi Box Berries", "Money Folder Madagascar Vanilla Ice Cream",
            "Rainier Rapp Snitch Knishes"
        };
        
         // The staff needs to read a script and then the menu will appear for those who are coming in through the drive-thru. (a part I did not have in the first time around). We will print that script and then display the menu via a print command.

        System.out.println("Welcome to MM...FOOD, our MF DOOM influenced eating experience!" + "\n" + "We're very glad to have you here today during our exclusive soft launch opening and hope that you enjoy our limited selection food offerings during this exclusive drive-thru experience." + "\n" + "Please choose 1 of the food items from today's menu on the display in front of you to order today and enjoy!" + "\n");
        
         // The next bit of code is to display the menu's items & pricing on the drive-thru screen via printing out each item & corresponding price from both of the arrays with a for loop:
        
        System.out.println("MM...FOOD MENU: " + "\n");

        for (int i = 0; i < foodItems.length; i++) {
            System.out.println((i + 1) + ". " + foodItems[i] + " - $" + cafePrice[i] + "\n");
        }

// Next, we have to process 20 individual orders from the drive-thru customers. We will do this by putting together 20 random orders based off of the information we set up earlier from the arrays. 

// We have to define how to process & describe the number of orders ('int' since there aren't partial orders, so whole numbers will do), randomize the orders (via the 'Random' function) and a way to definte the total amount of money made (using 'double').

        int numOrders = 20; // numOrders = number of orders
        Random rand = new Random(); // to generate random number combinations by first establishing a random class
        double totalRevenue = 0.0; // totalRevenue = total money made

// Beyond the percentage, we have to create something within the code to count the number of times a food item is ordered (which I neglected to put include in the first round of coding which gave me all even percentages no matter what was ordered).

// On that end, we'll create an array that will store the count for each food item ordered, which will also be as long as the foodItems array.

        int[] itemCounts = new int[foodItems.length];
        
// A for loop can be used in conjunction with the random function to create 20 seperate food orders to be printed for the day's 20 drive thru orders. Because we're using an array, the int i = 0 is the beginning order and goes up to 19 to create the full 20 orders.

//  I wanted to see if there was a random/randomization function in Java since during the original coding, it felt a bit more labor intensive than necessary to create 20 orders by hand betwen the arrays before getting into calculating the math of the percentages.

// rand.nextInt = moves on to the next random item and grouping (more information here: https://www.geeksforgeeks.org/java-util-random-nextint-java/#)

        System.out.println("\rThe Day's 20 Drive Thru Orders:" + "\n");
        for (int i = 0; i < numOrders; i++) {
            int randomIndex = rand.nextInt(foodItems.length); // sets up the randomIndex number to pull up the food item and price and then to move onto the next random selection until the loop ends based off of the length of the arrays
            String foodItem = foodItems[randomIndex]; //selects random food item from array
            double price = cafePrice[randomIndex]; // selects the corresponding price for the previous food item selected since the arrays are paired
            totalRevenue += price; // adds price of each item until loop ends

            // Increases the count for the individual item that's ordered during the loop (since someting is inevitably going to be ordered twice)
            itemCounts[randomIndex]++;

            // Prints out the order number, the food item ordered and the price line by line
            System.out.println("Order #" + (i + 1) + ": " + foodItem + " - $" + price + "\n");
        }
// Now we have to process a list with the number of each food item ordered and a percentage. We would use another for loop to go through the array to list each food item (pulled via foodItems[i]), the number of times the item was ordered (via itemCounts[i] which pulls up information from that array which stored the amount of times an item was ordered, and calculate the percentage of each food item ordered (which since I previously did not have function to add the orders before, is what made it difficult to get the percentages correct).

        System.out.println("\rBreakdown of the First Day's Orders By Percentage:");
        for (int i = 0; i < foodItems.length; i++) {
            double itemPercentage = (double) itemCounts[i] / numOrders * 100;
            System.out.println(foodItems[i] + ": " + itemPercentage + "%" + "         - Ordered " + itemCounts[i] + " times" + "\n");
        }

        System.out.println("\rTotal Revenue: $" + totalRevenue);
    }

// The private class functions within the loop for listing the food items in the order of the 2nd array in the percentage breakdown list.

    private static int countItem(String[] foodItems, int index) {
        int count = 0;
        for (String item : foodItems) {
            if (foodItems[index].equals(item)) {
                count++;
            }
        }
        return count;
    }
}
