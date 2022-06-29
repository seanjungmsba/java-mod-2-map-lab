import java.util.Scanner;

class Runner {

    private static String title, genre;
    private static int pageNum; 

    public static void selectOptions(Scanner sc) {
        System.out.println("Type 'a' to add a book, 's' to search the book by title, or simply press [ENTER] to end the program");
        try {
            String userInput = sc.nextLine().trim().toLowerCase();
            if (userInput.equals("a")) {
                addBook(sc);  
            } else if (userInput.equals("s")) {
                getTitle(sc);
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
            int counter = 0; // tracks the number of books in a library
            boolean processing = true;

            while (processing) {
                for (String[] description: bookDescriptions) {
                    System.out.print(description[1]); // sequentially prints out Book Title, Book Genre, and Number of Pages
                    try {
                        input = sc.nextLine().trim();
                        if (input.equals("")) { // if user ENTERS, quit the program
                            return;
                        }
                        // assign title, genre, and pageNum based on user inputs
                        if (description[0].equals("title")) {
                            title = input;
                        } else if (description[0].equals("genre")) {
                            genre = input;
                        } else if (description[0].equals("pageNum")) {
                            pageNum = Integer.parseInt(input);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } // end of for-loop
                counter++;
                Book book = new Book(title, genre, pageNum); // instantiating new Book object based on user input
                
                if (counter == 1) {
                    System.out.println("(Currently, library only has " + counter + " book)");
                } else {
                    System.out.println("(Library now has " + counter + " books)");
                }
                Library.addBook(book); // adding instantiated Book object into Library
            } // end of while-loop
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}