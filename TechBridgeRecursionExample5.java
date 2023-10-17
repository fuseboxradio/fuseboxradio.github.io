public class RocketShipRecursionExample {
    // Doing a countdown via recursion before the rocket blastoff
    // Declaring the method launchCountdown and the if...else loop parameters
    public static void launchCountdown(int n) {
        if (n == 0) {
            System.out.println("Blastoff!");
        } else {
            System.out.println(n + "...");
            launchCountdown(n - 1);
        }
    }

    public static void main(String[] args) {
        launchCountdown(20); // where you can choose number for the countdown
    }
}
