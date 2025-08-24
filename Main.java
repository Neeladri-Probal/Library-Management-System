
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        System.out.println("Central Library");
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("1.Add book");
            System.out.println("2.View books");
            System.out.println("3.Search book");
            System.out.println("4.Add member");
            System.out.println("5.View Member");
            System.out.println("6.Borrow book");
            System.out.println("7.Return book");
            System.out.println("8.View Borrowed book");
            System.out.println("9.Exit\n");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                {
                    System.out.print("Book ID: ");
                    Scanner sc1 = new Scanner(System.in);
                    int bookId = sc1.nextInt();
                    System.out.print("Book title: ");
                    sc1 = new Scanner(System.in);
                    String title = sc1.nextLine();
                    System.out.print("Author: ");
                    sc1 = new Scanner(System.in);
                    String author = sc1.nextLine();
                    Book book = new Book(bookId,title,author);
                    break;
                }
                case 9:
                {
                    System.out.println("Thanks for visiting...");
                    return;
                }
            }
        }
    }
}