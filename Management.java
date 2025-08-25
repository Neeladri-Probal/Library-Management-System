import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Management {
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Member> member = new ArrayList<>();
    static Vector<Integer> isAvailableBook = new Vector<>();
    static Vector<Integer> isAvailableMember = new Vector<>();
    static ArrayList<Borrow> whoBorrows = new ArrayList<>();

    static void addBook() {
        System.out.print("Book ID: ");
        Scanner sc1 = new Scanner(System.in);
        int bookId = sc1.nextInt();
        for (int i : isAvailableBook) {
            if (i == bookId) {
                System.out.println("\nThe book is already added.\n");
                return;
            }
        }
        System.out.print("Book title: ");
        sc1 = new Scanner(System.in);
        String title = sc1.nextLine();
        System.out.print("Author: ");
        sc1 = new Scanner(System.in);
        String author = sc1.nextLine();
        System.out.print("Genre: ");
        sc1 = new Scanner(System.in);
        String genre = sc1.nextLine();
        Book b = new Book(bookId, title, author, genre);
        books.add(b);
        isAvailableBook.add(b.bookId);
        System.out.println("Book added successfully.\n");
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

    static void addMember() {
        System.out.print("Member id: ");

        Scanner sc2 = new Scanner(System.in);
        int id = sc2.nextInt();

        for (int i : isAvailableMember) {
            if (i == id) {
                System.out.println("\nThe member is already exist.\n");
                return;
            }
        }

        System.out.print("Member name: ");
        Scanner sc1 = new Scanner(System.in);
        String name = sc1.nextLine();

        System.out.println("Member added successfully.\n");
        Member m = new Member(name, id);
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
        for (int available : isAvailableMember) {
            if (available == memberId) {
                membership = true;
                break;
            }
        }
        if (membership) {
            for (int i = 0; i < isAvailableBook.size(); i++) {
                if (bookId == isAvailableBook.get(i)) {
                    isAvailableBook.remove(i);
                    canBorrow = true;
                    break;
                }
            }
        }
        if (canBorrow && membership) {
            Borrow whoBorrow = new Borrow(memberId, bookId);
            whoBorrows.add(whoBorrow);
            System.out.println("\nSuccessfully borrowed book.\n");
        } else if (!membership) {
            System.out.println("\nPlease take membership first.\n");
        } else if (!canBorrow) {
            System.out.println("\nSorry this book is not available right now.\n");
        }
    }

    static void returnBook(int mid) {
        boolean membership = false;
        for (int available : isAvailableMember) {
            if (available == mid) {
                membership = true;
                break;
            }
        }
        if (!membership) {
            System.out.println("\nTake membership first.\n");
            return;
        }
        boolean returned = false;
        for (Borrow id : whoBorrows) {
            if (mid == id.stdID) {
                isAvailableBook.add(id.bookID);
                System.out.println("\nReturned book successfully.");
                returned = true;
            }
        }
        if (!returned) {
            System.out.println("\nYou have no book borrowed.\n");
        }
    }

    static void viewBorrowedBook(int mid) {
        boolean membership = false;
        for (int available : isAvailableMember) {
            if (available == mid) {
                membership = true;
                break;
            }
        }
        if (!membership) {
            System.out.println("\nTake membership first.\n");
            return;
        }
        boolean returned = false;
        for (Borrow id : whoBorrows) {
            if (mid == id.stdID) {
                for (Book b : books) {
                    if (id.bookID == b.bookId) {
                        System.out.println(b.title);
                    }
                }
                returned = true;
            }
        }
        if (!returned) {
            System.out.println("\nYou have no book borrowed.\n");
        }
    }
}
