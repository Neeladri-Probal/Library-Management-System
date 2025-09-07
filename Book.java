import java.time.LocalDate;

public class Book {
    int bookId;
    String title;
    String author;
    String genre;
    boolean isBorrowed = false;

    LocalDate borrowDate;  
    LocalDate dueDate;    

    public Book(int bookId, String title, String author, String genre) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return bookId + " | " + title + " | " + author + " | " + genre +
               (isBorrowed ? " [Borrowed, Due: " + dueDate + "]" : " [Available]");
    }
}
