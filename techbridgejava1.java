public class GetCreativeTwoPointOh {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    String userName;
    int myAge;
    
    // Asking for a user to select a username and then to press Enter
    System.out.println("Enter Your Chosen Username for our state's voter registration system & press Enter: "); 
    userName = myObj.nextLine();   
    
    // Next ask for the member's age to see if they are able to continue the voter registration process or not.
    System.out.println("Thank you! Next, please enter your age: ");
    String ageInput = myObj.next();
    
    // Parsing out the age input as an integer; found out that function via TutorialsPoint on Google to make sure the numeric information would come out properly
    myAge = Integer.parseInt(ageInput);
    
    // 1st round of output = username + age of user along with message if they are able to continue with the voter registration process
    System.out.println("Your Chosen Username Is: " + userName);
    System.out.println("The Age You Entered: " + myAge);

    if (myAge >= 18) {
      System.out.println("Congratulations, you're old enough to vote in our state! Let's move on to registering you for a voter registration card today!");
    } else {
      System.out.println("Sorry, you are currently not old enough to vote in our state at this time. Please go to LocalPoliticsLive.org for more information about how to actively participate with local politics in your area the meantime!");
    }
  }
}
