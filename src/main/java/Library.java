import java.util.HashMap;
import java.util.Map;

class Library {

    static Map<String, Book> books = new HashMap<String, Book>();

    public static void addBook(Book book) {

        try {
            if(books.containsKey(book.title)) {
                System.out.println("Based on the title you entered, book already exists");
                return;
            }
            books.put(book.title, book);
            System.out.println("Added Book: " + book);
            System.out.println("Repository: " + books);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void getTitle(String title) {
        try {
            System.out.println( "Book you are searching for is found: " + books.get(title) );
        } catch (Exception e){
            System.err.println( "Book you are looking for does not exist" );
        }
    }

}