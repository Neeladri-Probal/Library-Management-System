
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(
                "===================================\n     Welcome to Library System\n===================================");
        System.out.println("\n1. Log in as user");
        System.out.println("2. Log in as librarian");
        System.out.println("3. Exit\n");
        System.out.print("Enter your choice : ");
        Scanner usr = new Scanner(System.in);
        int chs = usr.nextInt();
        if (chs == 1) {
            System.out.println("\n1.View books");
            System.out.println("2.Search book");
            System.out.println("3.Take membership");
            System.out.println("4.Borrow book");
            System.out.println("5.Return book");
            System.out.println("6.View Borrowed book");
            System.out.println("7.Exit\n");
            while (true) {
                System.out.print("\nEnter your choice : ");
                Scanner ch = new Scanner(System.in);
                int choic = ch.nextInt();
                if(choic == 1){
                    Management.showBooks();
                }
                else if(choic == 2){
                        System.out.println("\n1.Search by Title");
                        System.out.println("2.Search by Author");
                        System.out.println("3.Search by Genre");
                        System.out.print("4.Search by BookId\n\nChoose Option: ");

                        Scanner scn = new Scanner(System.in);
                        int ch1 = scn.nextInt();

                        if (ch1 == 1) {
                            System.out.print("\nEnter Title: ");
                            Scanner sc1 = new Scanner(System.in);
                            String s = sc1.nextLine();
                            Management.searchbookbytitle(s);
                        } else if (ch1 == 2) {
                            System.out.print("\nEnter Author's Name: ");
                            Scanner sc1 = new Scanner(System.in);
                            String s = sc1.nextLine();
                            Management.searchbookbyauthor(s);
                        } else if (ch1 == 3) {
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
                        } else if (ch1 == 4) {
                            System.out.print("\nEnter BookId: ");
                            Scanner scn1 = new Scanner(System.in);
                            int id = scn1.nextInt();
                            System.out.println();
                            Management.searchbookbyid(id);
                        }
                }
                else if(choic == 6){
                    System.out.println("\nPlease contact librarian to take membership.\n");
                }
            }
        } else if (chs == 3) {
            System.out.println("\nThanks for visiting...");
            System.exit(0);
        } else if (chs == 2) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n1.Add book");
            System.out.println("2.View books");
            System.out.println("3.Search book");
            System.out.println("4.Add member");
            System.out.println("5.View Member");
            System.out.println("6.Borrow book");
            System.out.println("7.Return book");
            System.out.println("8.View Borrowed book");
            System.out.println("9.Delete Book");
            System.out.println("10.Delete Member");
            System.out.println("11.Exit\n");
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
                        } else if (ch == 2) {
                            System.out.print("\nEnter Author's Name: ");
                            Scanner sc1 = new Scanner(System.in);
                            String s = sc1.nextLine();
                            Management.searchbookbyauthor(s);
                        } else if (ch == 3) {
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
                        } else if (ch == 4) {
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
                        System.out.println("\nDeleting Book\n");
                        System.out.print("Enter Book Id : ");
                        Scanner scann = new Scanner(System.in);
                        int bookid = scann.nextInt();
                        Management.deleteBook(bookid);
                        break;
                    }
                    case 10: {
                        System.out.println("\nDeleting Member");
                        System.out.print("\nEnter Member Id : ");
                        Scanner scann = new Scanner(System.in);
                        int memid = scann.nextInt();
                        Management.deleteMem(memid);
                        break;
                    }
                    case 11: {
                        System.out.println("Thanks for visiting...");
                        return;
                    }
                }
            }
        }
    }
}