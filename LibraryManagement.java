import java.util.*; // Importing utility classes like Map, HashMap, Set, HashSet, Scanner

public class LibraryManagement
{
    private Map<Integer,String> books = new HashMap<>(); // Stores bookId -> bookName
    private Set<Integer> issuedBooks = new HashSet<>(); // Stores IDs of books that are currently issued

    public void addBook(int bookId,String bookName)
    {
        books.put(bookId,bookName); // Adds a book to the library collection
        System.out.println("Book Added Successfully!");
    }

    public void issueBook(int bookId)
    {
        if(!books.containsKey(bookId)) // Check if the book exists in the library
        {
            System.out.println("Book does not exist");
            return; // Stop execution if book not found
        }

        if(issuedBooks.contains(bookId)) // Check if the book is already issued
        {
            System.out.println("Book already issued.");
        }
        else
        {
            issuedBooks.add(bookId); // Mark book as issued by adding its ID to issuedBooks set
            System.out.println("Book issued Successfully!");
        }
    }

    public void returnBook(int bookId)
    {
        if(issuedBooks.contains(bookId)) // Check if the book was issued
        {
            issuedBooks.remove(bookId); // Remove book from issued list to mark it returned
            System.out.println("Book returned Successfully");
        }
        else
        {
            System.out.println("This book was not issued."); // Message if book was never issued
        }
    }

    public void displayAvailableBooks()
    {
        System.out.println("Available Books:");
        for (Map.Entry<Integer,String> entry : books.entrySet()) // Iterate through all books in library
        {
            if(!issuedBooks.contains(entry.getKey())) // Display only books that are not issued
            {
                System.out.println(entry.getKey() + " - " + entry.getValue()); // Print book ID and name
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in); // Scanner object to read user input
        LibraryManagement library = new LibraryManagement(); // Creating library object to access methods

        while(true) // Infinite loop to keep the program running until user exits
        {
            System.out.println("\n----Library Menu----");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Display Available Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt(); // Read user's menu choice
            sc.nextLine(); // Consume leftover newline character

            switch(choice) // Switch case to perform action based on user choice
            {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt(); // Read book ID
                    sc.nextLine();

                    System.out.print("Enter Book Name: ");
                    String name = sc.nextLine(); // Read book name

                    library.addBook(id,name); // Call method to add book
                    break;

                case 2:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt(); // Read book ID to issue
                    library.issueBook(issueId); // Call issueBook method
                    break;

                case 3:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt(); // Read book ID to return
                    library.returnBook(returnId); // Call returnBook method
                    break;

                case 4:
                    library.displayAvailableBooks(); // Display all available books
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    sc.close(); // Close scanner to release resources
                    return; // Exit the program

                default:
                    System.out.println("Invalid choice."); // Message for invalid menu option
            }
        }
    }
}