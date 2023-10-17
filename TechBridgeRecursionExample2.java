public class LetterCountRapFeelsRecursion {
    public static void main(String[] args) {
        // inputting in the string/sentence you want to count the number of letters of
        String inputString = "I knew I was getting older when a segment of rappers in their twenties started spitting like Roc Marciano.";
        int letterCount = countLetters(inputString);
        // sets up a method to count the letters of the string (in this case a sentence)
        System.out.println("The number of letters in this string/sentence is: " + letterCount);
        // prints out the number of letters within the string/sentence
    }

    public static int countLetters(String str) {
        if (str.isEmpty()) {
            return 0;  // This sets a baseline of if the string is empty, there are no letters.
        } else {
            // This starts to get the first character of the string.
            char firstChar = str.charAt(0);

            // checks to see if the first character is a letter (a-z or A-Z).
            if ((firstChar >= 'a' && firstChar <= 'z') || (firstChar >= 'A' && firstChar <= 'Z')) {
                // If it's a letter, we're adding 1 to the count and then recursively counting out the remaining characters.
                // A substring is a part of a String or can be said subset of the String (more information here: https://www.geeksforgeeks.org/substring-in-java/)
                return 1 + countLetters(str.substring(1));
            } else {
                // If the character is NOT a letter, we're going to recursively counting the remaining characters without adding to the overall count.
                return countLetters(str.substring(1));
            }
        }
    }
}
