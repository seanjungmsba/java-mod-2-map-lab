import java.util.Scanner;

class Runner {

    private static String title, genre;
    private static int pageNum; 

    public static void showOptions(Scanner sc) {
        System.out.println("Type 's' to search, 'a' to add, or simply press [ENTER] to end the program");
        try {
            String userInput = sc.nextLine().trim().toLowerCase();
            if (userInput.equals("s")) {
                getTitle(sc);
            } else if (userInput.equals("a")) {
                addBook(sc);  
            } else {
                System.exit(0);
                return;  
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getTitle(Scanner sc) {
        System.out.print("Title: ");
        Library.getTitle(sc.nextLine());
    }

    public static void addBook(Scanner sc) {

        try {
            String input;
            String[][] bookDescriptions = {
                {"title", "Book Title: "},
                {"genre","Book Genre: "},
                {"pageNum", "Number of Pages: "}};
            for (String[] description: bookDescriptions) {
                System.out.print(description[1]);
                input = sc.nextLine().trim();
    
                // if user ENTERS, quit the program
                if(input.equals("")) {
                    return;
                }
                // assign title, genre, and pageNum based on user inputs
                if (description[0] == "title") {
                    title = input;
                } else if (description[0] == "genre") {
                    genre = input;
                } else if (description[0] == "pageNum") {
                    pageNum = Integer.parseInt(input);
                }
            }
            Book book = new Book(title, genre, pageNum); // instantiate new Book object based on user input
            Library.addBook(book); // add instantiated Book object into Library
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public static void askOptions(Scanner sc) {
        while(true){
            showOptions(sc);
        }
    }
    
}