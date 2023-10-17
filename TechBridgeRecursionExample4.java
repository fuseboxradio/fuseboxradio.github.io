public class MadMultipleGreetingsRecursionYo {  
    // using recursion to print a message multiple times until the loop ends
static int count = 0;  
    // declaring a static variable to count the number of greetings.
static void printGreeting(){  
    //creating the recursion method to count the variable multiple times up to the current declared count
count++;  
if(count <= 5){  
System.out.println(count + ". Yo Yo Yooooo ");  
printGreeting();  
}  
}  
public static void main(String[] args) {  
printGreeting();  
}  
} 
