
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Central Library");
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Add book");
        System.out.println("2.View books");
        System.out.println("3.Search book");
        System.out.println("4.Add member");
        System.out.println("5.View Member");
        System.out.println("6.Borrow book");
        System.out.println("7.Return book");
        System.out.println("8.View Borrowed book");
        System.out.println("9.Exit\n");
        while (true) {

            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    Management.addBook();
                    break;
                }
                case 2: {
                    if (!Management.showBooks()) {
                        System.out.println("No book available.\n");
                    }
                    break;
                }
                case 3: {
                    System.out.println("\n1.Search by Title");
                    System.out.println("2.Search by Author");
                    System.out.println("3.Search by Genre");
                    System.out.print("4.Search by BookId\n\nChoose Option: ");

                    Scanner scn = new Scanner(System.in);
                    int ch = scn.nextInt();

                    if (ch == 1) {
                        System.out.print("\nEnter Title: ");
                        Scanner sc1 = new Scanner(System.in);
                        String s = sc1.nextLine();
                        Management.searchbookbytitle(s);
                    }
                    else if (ch == 2) {
                        System.out.print("\nEnter Author's Name: ");
                        Scanner sc1 = new Scanner(System.in);
                        String s = sc1.nextLine();
                        Management.searchbookbyauthor(s);
                    }
                    else if (ch == 3)
                    {
                        System.out.println("\n1.Novel");
                        System.out.println("2.Science Fiction");
                        System.out.println("3.Detective");
                        System.out.println("4.Essay");
                        System.out.println("5.Fantasy");
                        System.out.print("\nEnter Genre: ");
                        Scanner scn1 = new Scanner(System.in);
                        String genre = scn1.nextLine();
                        System.out.println();
                        Management.searchbookbygenre(genre);
                    }
                    else if (ch == 4)
                    {
                        System.out.print("\nEnter BookId: ");
                        Scanner scn1 = new Scanner(System.in);
                        int id = scn1.nextInt();
                        System.out.println();
                        Management.searchbookbyid(id);
                    }
                    break;
                }
                case 4: {
                    Management.addMember();
                    break;
                }
                case 5: {
                    Management.viewMember();
                    break;
                }
                case 6: {
                    System.out.print("Enter Book Id: ");
                    Scanner sc1 = new Scanner(System.in);
                    int bid = sc1.nextInt();
                    System.out.print("Enter Member Id: ");
                    int mid = sc1.nextInt();
                    Management.borrowbook(bid, mid);
                    break;
                }
                case 7: {
                    System.out.print("Enter Member Id: ");
                    Scanner sc1 = new Scanner(System.in);
                    int mid = sc1.nextInt();
                    Management.returnBook(mid);
                    break;
                }
                case 8: {
                    System.out.print("Enter Member Id: ");
                    Scanner sc1 = new Scanner(System.in);
                    int mid = sc1.nextInt();
                    Management.viewBorrowedBook(mid);
                    break;
                }
                case 9: {
                    System.out.println("Thanks for visiting...");
                    return;
                }
            }
        }
    }
}