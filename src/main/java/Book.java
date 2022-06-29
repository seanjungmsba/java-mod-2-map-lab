class Book {

    public String title, genre;
    private int numPages;

    public Book(String title, String genre, int numPages){
        this.title = title;
        this.genre = genre;
        this.numPages = numPages;
    }

    public String getTitle() {
        return this.title;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getPages() {
        return this.numPages;
    }

    @Override
    public String toString(){
        return "[Title: " + this.title + " | Genre: " + this.genre + " | Pages: " + this.numPages + "]";
    }

}