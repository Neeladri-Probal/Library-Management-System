
import java.util.Scanner;
import java.util.Stack;
public class Main{
    Stack<Integer> stack = new Stack<>();
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