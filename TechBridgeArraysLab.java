import java.util.Random;
// Java DOES have a a random function that can be used in your code by importing the java.util.Random package. Decided to use this for creating the 20 food orders from our array information

//More information about that package is at Tutorials Point here: https://www.tutorialspoint.com/java/util/java_util_random.htm

public class FoodSpotSoftOpening {
    //I chose that public class name basically due to there only being 15 food items & 20 orders we're working with at the moment - feels like a soft launch. :) 
    
    public static void main(String[] args) {
       
        //Creating the first array for the food spot's menu prices for our 15 offerings; using a double for the monetary values which would be dollars and cents
        
        double[] cafePrice = {
            8.00, 3.00, 2.00, 4.00, 12.00, 50.00, 35.00, 25.00, 15.00, 20.00, 7.50, 15.75, 6.00, 10.00, 8.25
        };
      
        //Creating the second array for the food spot's 15 culinary offerings; these are strings since we're listing the description of the offerings

        String[] foodItems = {
            "Wings", "Brussel Sprouts", "French Fries", "Nachos", "Charcuterie", "Prime Rib",
            "Swordfish", "Baked Chicken", "Roasted Portabello Mushrooms", "Pork Roast",
            "Cherry Cheesecake", "German Chocolate Cake", "Mixed Berries", "Madagascar Vanilla Ice Cream",
            "Rainier Cherry Pie"
        };

//Next, we have to get 20 random orders together from the arrays. We have to define how to process & describe the number of orders (int since there aren't partial orders, so whole numbers will do), randomize the orders (via the Random function) and a way to definte the total amount of money made (double).

        int numOrders = 20;
        Random rand = new Random();
        double totalRevenue = 0.0;

//A for loop can be used with the random function to create 20 different food orders to be printed. Since we're using an array, the int i = 0 is the beginning order and goes up to 19 to create the full 20 orders.

// Quite frankly, I wanted to see if a) there was a random function in Java and really didn't feel like making something up with trying to put together 20 orders by hand via the array before getting into calculating the math of the percentages via code (it has been a VERY long week and I got a bit stuck on that end of the process for a while mentally).

//rand.nextInt = moves on to the next random item and grouping (more information here: https://www.geeksforgeeks.org/java-util-random-nextint-java/#)

        System.out.println("The Day's 20 Drive Thru Orders:");
        for (int i = 0; i < numOrders; i++) {
            int randomIndex = rand.nextInt(foodItems.length);
            // setting up getting the randomized the combinations between the 2 arrays by how big they are (the int of 20 orders total between 15 food items)
            String foodItem = foodItems[randomIndex];
            // foodItem = one of the random foodItems selected from the menu
            double price = cafePrice[randomIndex];
            // price = the random cafePrice is pulled in conjunction with the corresponding food item
            totalRevenue += price;
            //totalRevenue adds up the price of each random item selected until the loop ends when the 20 orders are complete from the beginning of the array (remember, that's 0) to 19 (less than 20)

            System.out.println("Order #" + (i + 1) + ": " + foodItem + " - $" + price);
          //printing out the order number, food item ordered and the price in a line by line list
        }

// The "\n: i front of a string in quotation marks is basically like hitting an enter button and then creating a new line. Was pretty nice to find this out regarding print outputs with this particular assignment that likes a lot of listing.

// More information about \n is at CodeNinjas: https://www.codingninjas.com/studio/library/methods-to-print-new-line-in-java

// We're using another for loop to proess then print the list the day's orders and the percentage ordered (this time in the original array orders of string) and the percentage of orders types. 

//NOTE: As of this first round of putting together and executing this code, I'm a bit stuck to be honest since while the order total revenue pricing consistently changes when running the program due to the order randomization, the percentages seem stuck at an even 5% for each item with my current code, which it shouldn't be since some items are going to inevitably be ordered more than once in between 20 orders. I need to figure out how/if the random function can be used with calculating the percentage as well or if there is a way to do a seperate order count and then discover a way to break down the perentages.


        System.out.println("\nBreakdown of the First Day's Orders By Percentage:");
        for (int i = 0; i < foodItems.length; i++) {
            int itemCount = countItem(foodItems, i);
            double itemPercentage = (double) itemCount / numOrders * 100;
            System.out.println(foodItems[i] + ": " + itemPercentage + "%");
        }


        System.out.println("\nTotal Revenue: $" + totalRevenue);
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
