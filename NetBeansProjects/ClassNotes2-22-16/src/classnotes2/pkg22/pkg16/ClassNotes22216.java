package classnotes2.pkg22.pkg16;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.util.Scanner;
public class ClassNotes22216 {
    private static final DateTimeFormatter dateFormatter =
            DateTimeFormatter.ofPattern("MM-DD-YYYY");
    private static final Scanner kIn =
            new Scanner(System.in);
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
    LocalDate anniversary = LocalDate.of(2000,9,24);
    
    Period period = Period.between(anniversary,
            today);
    
    System.out.print("Todays' date: " + today + "\n\n");
    
    System.out.print("Enter a date (mm-dd-yyyy) : ");
    String dateEntered = kIn.next();
    String date[] = dateEntered.split("-");
    LocalDate myEnteredDate = LocalDate.of(
            Integer.parseInt(date[2]),
            Integer.parseInt(date[0]),
            Integer.parseInt(date[1]));
    
    LocalDate date2 = LocalDate.parse(dateEntered,
            dateFormatter);
    date2.format(dateFormatter);
    }
}
