import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Runner.askOptions(sc);
        sc.close();
    }
}

class Runner {

    private static String title, genre;
    private static int pageNum; 

    public static void showOptions(Scanner sc) {
        System.out.println("Type 's' to search, 'a' to add; otherwise, simply [ENTER] to end the program");
        try {
            String userInput = sc.nextLine().toLowerCase();
            if (userInput.equals("s")) {
                getBook(sc);
            } else if  (userInput.equals("a")) {
                addBook(sc);  
            } else {
                System.exit(0);
                return;  
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getBook(Scanner sc) {
        System.out.print("Title: ");
        Library.getBook(sc.nextLine());
    }

    public static void addBook(Scanner sc) {

        String input;
        String[][] bookDescriptions = {
            {"title", "Book Title: "},
            {"genre","Book Genre: "},
            {"pageNum", "Number of Pages: "}};
        
        for(String[] description: bookDescriptions){
            System.out.print(description[1]);
            input = sc.nextLine();

            // if user ENTERS, quit the program
            if(input.equals("")){
                return;
            }

            if (description[0] == "title") {
                title = input;
            } else if (description[0] == "genre") {
                genre = input;
            } else if (description[0] == "pageNum") {
                pageNum = Integer.parseInt(input);
            }
        }

        Book book = new Book(title, genre, pageNum); // instantiate new Book object based on user input
        Library.addBook(book);
        
    }
    
    public static void askOptions(Scanner sc) {
        while(true){
            showOptions(sc);
        }
    }
}

class Library {

    static Map<String, Book> books = new HashMap<String, Book>();

    public static void addBook(Book book){

        if(books.containsKey(book.title)){
            System.out.println("Book Already Exists");
            return;
        }
  
        books.put(book.title,book);
        System.out.println("Added Book: " + book);
        System.out.println("Repository: " + books);
       
    }

    public static void getBook(String title) {
        try{
            System.out.println("Book you are searching for is found: " + books.get(title));
        } catch (Exception e){
            System.err.println("Book you are looking for does not exist");
        }
    }
}

class Book {

    public String title, genre;
    private int numPages;

    public Book(String title, String genre, int numPages){
        this.title = title;
        this.genre = genre;
        this.numPages = numPages;
    }

    @Override
    public String toString(){
        return "[Title: " + this.title + " | Genre: " + this.genre + " | Pages: " + this.numPages + "]";
    }
}