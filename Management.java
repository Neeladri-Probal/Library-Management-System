import java.util.ArrayList;
public class Management {
    static ArrayList<Book> books = new ArrayList<>();
    static void addBook(Book b)
    {
        books.add(b);
    }
    static boolean showBooks()
    {
        if(books.isEmpty())
            return false;
        else
        {
            for(Book book:books)
            {
                System.out.println(book.title);
            }
        }
        return true;
    }
}
