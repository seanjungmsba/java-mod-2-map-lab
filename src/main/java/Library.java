import java.util.HashMap;
import java.util.Map;

class Library {

    // Map<String ==> book title, Book ==> book object>
    static Map<String, Book> books = new HashMap<String, Book>();

    public static void addBook(Book book) {
        try {
            if (books.containsKey(book.title)) { // checking if the book already exists
                System.out.println("Based on the title you entered, book already exists");
                return;
            } else {
                books.put(book.title, book);
            }
            System.out.println("Added Book ===> " + book);
            System.out.println("Repository ===> " + books);
            System.out.println("====================================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getTitle(String title) {
        try {
            System.out.println( "Book you are searching for is found: " + books.get(title) );
        } catch (Exception e) {
            System.err.println( "Book you are looking for does not exist" );
        }
    }

    @Override
    public String toString() {
        return books.toString();
    }

}