import java.util.ArrayList;

public class Management {
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Member> member = new ArrayList<>();

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
    static void addMember(String s, int id)
    {
        Member m = new Member(s, id);
        member.add(m);
    }
    static void viewMember()
    {
        if (member.isEmpty())
            System.out.println("No member available.");
        else {
            for (Member members : member) {
                System.out.println(members.name);
            }
        }
    }
}
