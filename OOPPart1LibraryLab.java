import java.util.Date;
import java.util.Scanner;

public class LibraryOnlineCheckout {
        // Declaring the private instance variables to store different information about the books on hand for the special library program
    private String bookTitle;
    private boolean goodReads;
    private char bookFormat;
    private String genre;
    private double sale;
    private int amountOfBooksCheckedOut;
    private boolean borrowFromAnotherLocation;
    private boolean bookSigningEvent;
    private boolean bookClubSelection;
    private boolean allAges;
    private Date checkoutDate;

    // Putting together the constructor to initialize the above defined variables
    public LibraryOnlineCheckout(String bookTitle, boolean goodReads, char bookFormat, String genre, double sale, int amountOfBooksCheckedOut,
                       boolean borrowFromAnotherLocation, boolean bookSigningEvent, boolean bookClubSelection, boolean allAges) {
        this.bookTitle = bookTitle;
        this.goodReads = goodReads;
        this.bookFormat = bookFormat;
        this.genre = genre;
        this.sale = sale;
        this.amountOfBooksCheckedOut = amountOfBooksCheckedOut;
        this.borrowFromAnotherLocation = borrowFromAnotherLocation;
        this.bookSigningEvent = bookSigningEvent;
        this.bookClubSelection = bookClubSelection;
        this.allAges = allAges;
        this.checkoutDate = new Date(); // puts in the current date at the end of the program printout/reciept
    }

    // Putting together the method to display needed information about the book(s) being checked out after the requested information input is complete
    
    public void displayLibraryOnlineCheckoutInfo() {
        System.out.println("Book Title: " + bookTitle);
        System.out.println("Reviews Available on Goodreads: " + (goodReads ? "Yes" : "No"));
        System.out.println("Book Format (A - physical copy, B - electronic copy, C - audiobook): " + bookFormat);
        System.out.println("Genre: " + genre);
        System.out.println("On Sale at Amazon: " + (sale > 0 ? "Yes" : "No"));
        System.out.println("Amount of Books Checked Out: " + amountOfBooksCheckedOut);
        System.out.println("Borrowing from Another Location: " + (borrowFromAnotherLocation ? "Yes" : "No"));
        System.out.println("Will there be a Book Signing Event? " + (bookSigningEvent ? "Yes" : "No"));
        System.out.println("Is this a monthly Book Club Selection? " + (bookClubSelection ? "Yes" : "No"));
        System.out.println("Is This Book Suitable For All Ages? " + (allAges ? "Yes" : "No"));
        System.out.println("\rCheckout Request Date: " + checkoutDate);
    }

    // Creation of the method to check out the maximum amount of books of a title (in thise case, 4 )

    public void checkOutItem(int numberOfBooks) {
        if (numberOfBooks <= 4) {
            amountOfBooksCheckedOut += numberOfBooks;
            System.out.println(numberOfBooks + " book(s) checked out.");
            // Update the checkout date
            checkoutDate = new Date();
        } else {
            System.out.println("Sorry! Remember, you can only check out 4 books of this title at a time maxiumum.");
        }
    }
    // Below is the main method where the program begins to get executed + scanner function so that the user can enter in the requested information 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ABC Library Online Checkout! \rThank you for logging in with your library card information and participating in our special 'Check Out & Talk About A Famous Book With Friends' program today!" + "\r");
       
        System.out.println("\rWith this program, you will get to use your library card to check out a maximum of four copies of our top 5 rated books to share with others to read, discuss and more over the next 2 weeks in the following categories: Horror, Science Fiction (Sci-Fi), Business, Comic Book and Autobiography");
       
        System.out.println("\rHere Are The Books Available To Check Out During the Program: \rHorror Titles: \n0. Pet Sematary \n1. Interview with a Vampire \n2. Red Dragon, \n3. The Shining, \n4. The Haunting of Hill House, \rScience Fiction (Sci-Fi) Titles: \n0. Kindred \n1. Fahrenheit 451 \n2. Dune \n3. Ender's Game \n4. 1984 \rBusiness, \n0. Who Moved My Cheese? , \n1. The 7 Habits of Highly Effective People \n2. Think and Grow Rich \n3. Rich Dad, Poor Dad \n4. The 4-Hour Workweek \rComic Book Titles: \n0. Saga \n1. The Dark Knight Rises \n2. Akira \n3. X-Men: Days of Future Past \n4. Maus \rAutobiography Titles: \n0. The Autobiography of Malcolm X \n1. Becoming \n2. Kitchen Confidential \n3. Long Walk To Freedom \n4. Just As I Am");
        
        System.out.println("\rLet's start out the process of choosing a book today! \rFirst, please enter the genre of available book selections you would like to check out (Horror, Sci-Fi, Business, Comic Book, Autobiography) and press 'Enter':");
        
        String genre = scanner.nextLine();

        // Creation of arrays of the Top 5 book selections broken down by different genres
        
        String[] horrorBooks = {
            "Pet Sematary", "Interview with a Vampire", "Red Dragon", "The Shining", "The Haunting of Hill House"
        };

        String[] scifiBooks = {
            "Kindred", "Fahrenheit 451", "Dune", "Ender's Game", "1984"
        };

        String[] bizBooks = {
            "Who Moved My Cheese?", "The 7 Habits of Highly Effective People", "Think and Grow Rich", "Rich Dad, Poor Dad", "The 4-Hour Workweek"
        };

        String[] comicBooks = {
            "Saga", "The Dark Knight Rises", "Akira", "X-Men: Days of Future Past", "Maus"
        };

        String[] autoBiographyBooks = {
            "The Autobiography of Malcolm X", "Becoming", "Kitchen Confidential", "Long Walk to Freedom", "Just as I Am"
        };

        String[] selectedGenreBooks = null;
        
        // If the member chooses the listed genres, the program via the switch will break and move onto the next step (selecting the book title to check out); if they choose a genre not available, then the program stops with the default statement

        switch (genre.toLowerCase()) {
            case "horror":
                selectedGenreBooks = horrorBooks;
                break;
            case "sci-fi":
                selectedGenreBooks = scifiBooks;
                break;
            case "business":
                selectedGenreBooks = bizBooks;
                break;
            case "comic book":
                selectedGenreBooks = comicBooks;
                break;
            case "autobiography":
                selectedGenreBooks = autoBiographyBooks;
                break;
            default:
                System.out.println("Sorry, that particular genre is not available to check out with this program at this time. Please keep checking our website for our next round of available genres for our ongoing program!");
                scanner.close();
                return;
        }

// Next, the program is going to ask which book ou want to check out based on the list presented per genre (which corresponds directly to the array selections).

        System.out.println("Thanks a lot! \rNext, type the number next to the book title that you want to check out based off of the corresponding genre list above and press 'Enter': ");
        int bookIndex = scanner.nextInt();

        if (bookIndex >= 0 && bookIndex < selectedGenreBooks.length) {
            String bookTitle = selectedGenreBooks[bookIndex];
            System.out.println("You selected the following book title today: " + bookTitle + "\r" + "Great Choice!" + "\r");

// Next, the program is going to ask how many books the user wants to check out. If they go above 4 books, the program will stop.

            System.out.println("Thanks! Please enter in the number of books you would like to check out today: ");
            int numberOfBooks = scanner.nextInt();
            
            // Lastly, the program will enter in a receipt for the user listing the book they are checking out, how many copies, today's date and more.


            LibraryOnlineCheckout libraryOnlineCheckout = new LibraryOnlineCheckout(bookTitle, true, 'A', genre, 0, 0,
                    false, false, false, false);

            libraryOnlineCheckout.checkOutItem(numberOfBooks);

            System.out.println("\rLibrary Item(s) Being Checked Out Today:");
            libraryOnlineCheckout.displayLibraryOnlineCheckoutInfo();
        } else {
            System.out.println("Invalid book index.");
        }

        scanner.close();
    }
}
