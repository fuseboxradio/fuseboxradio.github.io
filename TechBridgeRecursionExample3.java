public class BackwardsCountRecursionExample {

  public static void main(String[] args) {
    countingDown(9);
  }
  // using recursion to count down from 9 down to zero & printing out said countdown in order
  // via the if part of the statement using recursion, the countdown will end when i is less than zero
  public static void countingDown(int i) {
    if (i < 0) {
      return;
    }
    System.out.print(i + ", ");
    i = i - 1;
    countingDown(i);
  }
}
