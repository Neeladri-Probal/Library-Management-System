import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.time.LocalDate;

public class Management {
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Member> member = new ArrayList<>();
    static Vector<Integer> isAvailableBook = new Vector<>();
    static Vector<Integer> isAvailableMember = new Vector<>();
    static ArrayList<Borrow> whoBorrows = new ArrayList<>();

    // some default books
    static {
        Book d = new Book(101, "Opekha", "Humayun Ahmed", "Novel");
        books.add(d);
        isAvailableBook.add(d.bookId);

        d = new Book(102, "Deyal", "Humayun Ahmed", "Novel");
        books.add(d);
        isAvailableBook.add(d.bookId);

        d = new Book(103, "Science Fiction Shomogro", "Jafar Iqbal", "Science Fiction");
        books.add(d);
        isAvailableBook.add(d.bookId);

        d = new Book(104, "Istition", "Jafar Iqbal", "Novel");
        books.add(d);
        isAvailableBook.add(d.bookId);

        d = new Book(105, "Hemloker Nimontron", "Shomoresh Mojumder", "Essay");
        books.add(d);
        isAvailableBook.add(d.bookId);

        d = new Book(106, "Byomkesh Shomogro", "Sharadindu Bandyopadhyay", "Detective Fiction");
        books.add(d);
        isAvailableBook.add(d.bookId);

        d = new Book(107, "Sherlock Holmes", "Arthur Conan Doyle", "Detective Fiction");
        books.add(d);
        isAvailableBook.add(d.bookId);

        d = new Book(108, "Lord of the Rings", "J. R. R. Tolkien", "Fantasy");
        books.add(d);
        isAvailableBook.add(d.bookId);

        d = new Book(109, "Harry Potter and the Philosopher's Stone", "J. K. Rowling", "Fantasy");
        books.add(d);
        isAvailableBook.add(d.bookId);

        d = new Book(110, "Chander Pahar", "Bibhutibhushan Bandopadhyay", "Fantasy");
        books.add(d);
        isAvailableBook.add(d.bookId);

        d = new Book(111, "Poth o Patheo", "Kazi Nazrul Islam", "Essay");
        books.add(d);
        isAvailableBook.add(d.bookId);

        d = new Book(112, "A Room of One’s Own", "Virginia Woolf", "Essay");
        books.add(d);
        isAvailableBook.add(d.bookId);

        d = new Book(113, "Shonkhonil Karagar", "Humayun Ahmed", "Novel");
        books.add(d);
        isAvailableBook.add(d.bookId);

        d = new Book(114, "Parineeta", "Sarat Chandra Chattopadhyay", "Novel");
        books.add(d);
        isAvailableBook.add(d.bookId);

        d = new Book(115, "Pride and Prejudice", "Jane Austen", "Novel");
        books.add(d);
        isAvailableBook.add(d.bookId);

        d = new Book(116, "Robo Shomogro", "Satyajit Ray", "Science Fiction");
        books.add(d);
        isAvailableBook.add(d.bookId);

        d = new Book(117, "I, Robot", "Isaac Asimov", "Science Fiction");
        books.add(d);
        isAvailableBook.add(d.bookId);
    }
    // some default member
    static {
        Member b = new Member("Alice", 201);
        member.add(b);
        isAvailableMember.add(b.id);

        b = new Member("Bob", 202);
        member.add(b);
        isAvailableMember.add(b.id);

        b = new Member("Charlie", 203);
        member.add(b);
        isAvailableMember.add(b.id);

        b = new Member("Diana", 204);
        member.add(b);
        isAvailableMember.add(b.id);

        b = new Member("Emily", 205);
        member.add(b);
        isAvailableMember.add(b.id);
    }

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
                System.out.print(book.title);
                System.out.println(" - " + book.author);
            }
            System.out.println();
        }
        return true;
    }

    // by title
    static void searchbookbytitle(String s) {
        StringBuilder lower = new StringBuilder(s);
        for (int i = 0; i < lower.length(); i++) {
            lower.setCharAt(i, Character.toLowerCase(lower.charAt(i)));
        }
        boolean flag = false;
        for (Book book : books) {
            String Btitle = book.title.toLowerCase();
            if (Btitle.equals(lower.toString())) {
                System.out.println("\nAvailable...");
                System.out.println("Book Title: " + book.title);
                System.out.println("Book Id: " + book.bookId);
                System.out.println("Author: " + book.author);
                System.out.println("Genre: " + book.genre);
                System.out.println();
                flag = true;
            }
        }
        if (!flag)
            System.out.println("Not Available...\n");
    }

    // by author
    static void searchbookbyauthor(String s) {
        StringBuilder lower = new StringBuilder(s);
        for (int i = 0; i < lower.length(); i++) {
            lower.setCharAt(i, Character.toLowerCase(lower.charAt(i)));
        }
        boolean flag = false;
        for (Book book : books) {
            String author = book.author.toLowerCase();
            if (author.equals(lower.toString())) {
                System.out.println("Book Title: " + book.title);
                System.out.println("Book Id: " + book.bookId);
                System.out.println("Author: " + book.author);
                System.out.println("Genre: " + book.genre);
                System.out.println();
                flag = true;
            }
        }
        if (!flag)
            System.out.println("No book Available...\n");
    }

    // by genre
    static void searchbookbygenre(String s) {
        StringBuilder lower = new StringBuilder(s);
        for (int i = 0; i < lower.length(); i++) {
            lower.setCharAt(i, Character.toLowerCase(lower.charAt(i)));
        }
        boolean flag = false;
        for (Book book : books) {
            String genre = book.genre.toLowerCase();
            if (genre.equals(lower.toString())) {
                System.out.println("Book Title: " + book.title);
                System.out.println("Book Id: " + book.bookId);
                System.out.println("Author: " + book.author);
                System.out.println("Genre: " + book.genre);
                System.out.println();
                flag = true;
            }
        }
        if (!flag)
            System.out.println("No book Available...\n");
    }

    // by id
    static void searchbookbyid(int s) {
        boolean flag = false;
        for (Book book : books) {
            if (book.bookId == s) {
                System.out.println("Book Title: " + book.title);
                System.out.println("Book Id: " + book.bookId);
                System.out.println("Author: " + book.author);
                System.out.println("Genre: " + book.genre);
                System.out.println();
                flag = true;
            }
        }
        if (!flag)
            System.out.println("Book is not available...\n");
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
            System.out.println("\nSuccessfully borrowed book.");
            LocalDate today = LocalDate.now();
            LocalDate returndate = today.plusDays(7);
            System.out.println("Borrow Date: " + today);
            System.out.println("Return Date: " + returndate + "\n");
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

    static void deleteBook(int bookid) {

        boolean found = false;

        for (Book book : books) {
            if (book.bookId == bookid) {
                found = true;
                System.out.println("\nAre you sure to remove the book "+book.title+"?");
                System.out.println("1.Yes\n2.No\n");
                System.out.print("Enter your choice : ");
                Scanner scann = new Scanner(System.in);
                int ch = scann.nextInt();
                if (ch == 1) {
                    books.remove(book);
                    System.out.println("\nSuccessfully removed the book.\n");
                    break;
                } else if (ch == 2) {
                    System.out.println("\nCanceled Deleting Book.\n");
                }
            }
        }
        if (!found) {
            System.out.println("The book is not available.");
        }
    }
}
