import java.util.Scanner;
// imports in the scanner so the user can enter in requested information
public class TechBridgeFlowControlProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
    System.out.println("Let's Add Up Some Numbers!");
        
        // Prompts use to enter in the two numbers, choosing integers
        System.out.print("Enter the first number: ");
        int a = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int b = scanner.nextInt();
        
        // Ensures the difference is at least 200 between the entered in numbers; will print out a message if the difference is not 200 or greater and stop the program; error will occur if user does not enter in an integer
        // the math.abs function = returns absolute value of a given mathematical argrument; basically even if "a" is less than "b" when originally entering the numbers with the below function, the number calculated will be positive and compared to the 200 for moving onto the next step (found the function via W3Schools on Google)
        
        if (Math.abs(a - b) < 200) {
            System.out.println("The difference between the numbers MUST be at least 200 to continue.");
            return;
            
            //the return statement will completely stop the function of the block if the math.abs function is not at least 200 and print out the above statement.
        }
        
        //if the difference between the numbers is more 200 or more, we continue onto moving into the next steps via using a while loop to establish the sum of numbers divisible by 4 or 8 along with the sum of #s that are NOT even & not divisible by 5
        
        //sets up integer vaules for the sums
        
        int evenDivisibleBy4Sum = 0;
        int evenDivisibleBy8Sum = 0;
        int notEvenNotDivisibleBy5Sum = 0;
        
        // Next step using a "while" loop
        while (a <= b) {
            // while loop runs as long as as a is less than or equal to b
            switch (a % 2) {
                // switch = another way of having an if...else statement
                case 0: 
                    // first case for dividing by even numbers
                    // Even numbers; a divided by 4 with a remainder of 0
                    if (a % 4 == 0) {
                        evenDivisibleBy4Sum += a;
                        //evenDivisibleBySum = evenDivisibilyBySum + a

                    }
                    // Even numbers; a divided by 8 with a remainder of 0
                    if (a % 8 == 0) {
                        evenDivisibleBy8Sum += a;
                        //evenDivisibleBy8Sum = evenDivisibileBy8Sum + a
                    }
                    break;
                case 1: // next case for summing up the numbers that are not divisible by 5 if case 0 does not work for the previous numbers 
                    if (a % 5 != 0) {
                        // if the remainder of a divided by 5 is not equal to zero
                        notEvenNotDivisibleBy5Sum += a;
                    }
                    break;
                    //if case isn't met, breaks out of this part of the loop
            }
            a++;
            //increases a by variable of 1, restarts loop with that new number until a = b
        }
        
        // Calculations using a "for" loop, this time starting with b as the main variable 
        for (int i = b; i >= a; i--) {
            //i = b, i is greater than or less than a, decreases i by 1 number each round of the loop 
            switch (i % 2) {
                case 0: // Even numbers calculations (divisible by 4 and 8)
                    if (i % 4 == 0) {
                        evenDivisibleBy4Sum += i;
                    }
                    if (i % 8 == 0) {
                        evenDivisibleBy8Sum += i;
                    }
                    break;
                case 1: // calculations for other numbers if case 0 does not work for b post-break
                    if (i % 5 != 0) {
                        notEvenNotDivisibleBy5Sum += i;
                    }
                    break;
                    //if case isn't meant, breaks out of this part of the loop
                 
            }
        }
        
        // Using a "do...while" loop to find the results
        int DoNum = a;
        do {
            switch (DoNum) {
                case 0: // Even numbers
                    if (DoNum % 4 == 0) {
                        evenDivisibleBy4Sum += DoNum;
                    }
                    if (DoNum % 8 == 0) {
                        evenDivisibleBy8Sum += DoNum;
                    }
                    break;
                case 1: // Odd numbers
                    if (DoNum % 5 != 0) {
                        notEvenNotDivisibleBy5Sum += DoNum;
                    }
                    break;
                    //if case isn't meant, breaks out of this part of the loop
            }
            DoNum++;
            //DoNum++ = increases DoNum by 1, restarts the loop
        } while (DoNum <= b);
        //repeats loop while the conditions are true within the do...while loop, once all of the actions with the main loop are done with adding the numbers, it will be time to print out the results
        
        // Displays/Prints Out Each Of The Sums Processed in the Loops
        System.out.println("The sum of all of the even numbers divisible by 4 between both numbers equals: " + evenDivisibleBy4Sum);
        System.out.println("The sum of all of the even numbers divisible by 8 between both numbers equals: " + evenDivisibleBy8Sum);
        System.out.println("The sum of all of the numbers that are NOT even and NOT divisible by 5 between both numbers equals: " + notEvenNotDivisibleBy5Sum);
    }
}
