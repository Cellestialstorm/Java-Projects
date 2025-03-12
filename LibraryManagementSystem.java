import java.util.*;
import java.io.Console;

class Book {
	private int ID;
	private String Title;
	private String Author;
	private boolean isBorrowed;
	
	public Book(int ID, String Title, String Author) {
		this.ID = ID;
		this.Title = Title;
		this.Author = Author;
		this.isBorrowed = false; //default not borrowed
	}
	
	public int getID() {
		return ID;
	}
	
	public String getTitle() {
		return Title;
	}
	
	public String getAuthor() {
		return Author;
	}
	
	public void isBorrowed() {
		if (!isBorrowed) {
			isBorrowed = true;
			System.out.println("Book borrowed successfully!");
		} else {
			System.out.println("Sorry, this book is already borrowed.");
		}
	}
	
	public void returnBook() {
		if (isBorrowed) {
			isBorrowed = false;
			System.out.println("Book returned successfully!");
		} else {
			System.out.println("This book was not borrowed.");
		}
	}

	public String getBook() {
		return "ID: " + ID + ", Title: " + Title + ", Author: " + Author + ", Status: " + (isBorrowed ? "Borrowed":"Available");
	}
}

public class LibraryManagementSystem {
	private static List<Book> bookList = new ArrayList<>();
	
	public static void addBook(int ID, String Title, String Author) {
		for (Book book : bookList) {
			if (book.getID() == ID) {
				System.out.println("Book Already Exist");
				return;
			}
		}
		bookList.add(new Book(ID, Title, Author));
		System.out.println("Book Added Successfully");
	}
	
	public static void removeBook(int ID) {
		Iterator<Book> iterator = bookList.iterator();
		while (iterator.hasNext()) {
			Book book = iterator.next();
			if (book.getID() == ID) {
				iterator.remove();
				System.out.println("Book removed Successfully");
				return;
			}
		}
		System.out.println("Error: Book ID not found!");
	}
	
	public static void searchBook(int ID) {
		for (Book book : bookList) {
			if (book.getID() == ID) {
				System.out.println("Book Found: " + book.getBook());
				return;
			}
		}
		System.out.println("Error: Book not found!");
	}
	
	public static void displayBooks() {
		if (bookList.isEmpty()) {
			System.out.println("No books available in the library!");
		} else {
			System.out.println("\nLibrary Books: ");
			for (Book book : bookList) {
				System.out.println(book.getBook());
			}
		}
	}
	
	public static void borrowBook(int ID) {
		for (Book book : bookList) {
			if (book.getID() == ID) {
				book.isBorrowed();
				return;
			}
		}
		System.out.println("Error: Book not found!");
	}
	
	public static void returnBook(int ID) {
		for (Book book : bookList) {
			if (book.getID() == ID) {
				book.returnBook();
				return;
			}
		}
		System.out.println("Error: Book not found!");
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice;
		
		do {
			System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
			
			switch(choice) {
				case 1:
					System.out.print("Enter Book ID: ");
                    int id = scan.nextInt();
                    scan.nextLine(); // Consume newline
                    System.out.print("Enter Book Title: ");
                    String title = scan.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = scan.nextLine();
                    addBook(id, title, author);
                    break;
					
				case 2:
					System.out.print("Enter Book ID to Remove: ");
                    int removeId = scan.nextInt();
                    removeBook(removeId);
                    break;
					
				case 3:
					System.out.print("Enter Book ID to Search: ");
                    int searchId = scan.nextInt();
                    searchBook(searchId);
                    break;
					
				case 4:
					displayBooks();
                    break;
					
				case 5:
					System.out.print("Enter Book ID to Borrow: ");
                    int borrowId = scan.nextInt();
                    borrowBook(borrowId);
                    break;
					
				case 6:
					System.out.print("Enter Book ID to Return: ");
                    int returnId = scan.nextInt();
                    returnBook(returnId);
                    break;
					
				case 7:
					System.out.println("Exiting Library Management System. Thank you!");
                    break;
					
				default:
					System.out.println("Invalid choice! Please enter a valid option.");
			}
		} while (choice != 7);
			
		scan.close();
	}
}