public class AddingOddNumbers {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i <= 99; i += 2) {
            sum += i;
            // sum = sum + i;

        }

        System.out.println("The sum of adding all odd numbers up to 99 equals " + sum);
    }
}
