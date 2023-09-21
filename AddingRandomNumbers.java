public class AddingRandomNumbers {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i <= 16; i += 1) {
            sum += i;
            // sum = sum + i;

        }

        System.out.println("The sum of adding up the numbers between 1 & 16 equals " + sum);
    }
}
