public class Main {
  public static void main(String[] args) {
    int result = sum(15);
    // prints out the overall sum of each number from 15 to zero.
    System.out.println("The sum of each number counting down from 15 (15 + 14 + etc.) down to zero equals " + result + ".");
  }
// The recursion function starts at 15 and adds each integer in a countdown in a loop until the count down equals zero via recursion (adding 15 + 14 + 13, etc.) and an if-else function.
  public static int sum(int a) {
    if (a >= 0) {
      return a + sum(a - 1);
    } else {
      return 0;
    }
  }
}
