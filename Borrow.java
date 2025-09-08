import java.time.LocalDate;

public class Borrow {
    int stdID;
    int bookID;
    LocalDate borrowDate;
    LocalDate dueDate;

    public Borrow(int stdID, int bookID) {
        this.stdID = stdID;
        this.bookID = bookID;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(7); 
    }

    public int calculateFine() {
        LocalDate today = LocalDate.now();
        if (today.isAfter(dueDate)) {
            long overdueDays = java.time.temporal.ChronoUnit.DAYS.between(dueDate, today);
            return (int) overdueDays * 10; 
        }
        return 0;
    }
}
