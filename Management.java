import java.util.ArrayList;

public class Management {
    static ArrayList<Book> books = new ArrayList<>();

    static void addBook(Book b) {
        books.add(b);
    }

    static boolean showBooks() {
        if (books.isEmpty())
            return false;
        else {
            for (Book book : books) {
                System.out.println(book.title);
            }
        }
        return true;
    }

    static void searchbook(String s) {
        boolean flag = false;
        for (Book book : books) {
            if(book.title.equals(s))
            {
                System.out.println("Available...");
                flag = true;
            }
        }
        if (!flag)
            System.out.println("Not Available...");
    }
}
