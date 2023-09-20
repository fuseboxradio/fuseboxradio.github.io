import java.util.Scanner; // importing the Scanner class to JAva

class Main {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    String userName;
    
    // Asking for a user to enter in a username to use a program and press Enter
    System.out.println("Enter In Your Chosen Username for Okta & Press Enter "); 
    userName = myObj.nextLine();   
    // Will print out the chosen username for the user to review to use the chosen program   
    System.out.println("Confirming That You Chose The Username Of: " + userName);        
  }
}
