import java.util.ArrayList;
import java.util.Vector;

public class Management {
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Member> member = new ArrayList<>();
    static Vector<Integer> isAvailableBook = new Vector<>();
    static Vector<Integer> isAvailableMember = new Vector<>();
    static ArrayList<Borrow> whoBorrows = new ArrayList<>();

    static void addBook(Book b) {
        books.add(b);
        isAvailableBook.add(b.bookId);
    }

    static boolean showBooks() {
        if (books.isEmpty())
            return false;
        else {
            for (Book book : books) {
                System.out.println(book.title);
            }
            System.out.println();
        }
        return true;
    }

    static void searchbook(String s) {
        boolean flag = false;
        for (Book book : books) {
            if (book.title.equals(s)) {
                System.out.println("Available...\n");
                flag = true;
            }
        }
        if (!flag)
            System.out.println("Not Available...\n");
    }

    static void addMember(String s, int id) {
        Member m = new Member(s, id);
        member.add(m);
        isAvailableMember.add(m.id);
    }

    static void viewMember() {
        if (member.isEmpty())
            System.out.println("No member available.\n");
        else {
            for (Member members : member) {
                System.out.println(members.name);
            }
            System.out.println();
        }
    }

    static void borrowbook(int bookId, int memberId) {
        boolean canBorrow = false;
        boolean membership = false;
        for (int available : isAvailableBook) {
            if (available == bookId) {
                canBorrow = true;
                break;
            }
        }
        if (canBorrow) {
            for (int available : isAvailableMember) {
                if (available == memberId) {
                    membership = true;
                    break;
                }
            }
        }
        if (canBorrow && membership) {
            Borrow whoBorrow = new Borrow(memberId, bookId);
            whoBorrows.add(whoBorrow);
            System.out.println("\nSuccessfully borrowed book.\n");
        }
        else if(!membership)
        {
            System.out.println("\nPlease take membership first.\n");
        }
        else if(!canBorrow)
        {
            System.out.println("\nSorry this book is not available right now.\n");
        }
    }
}
