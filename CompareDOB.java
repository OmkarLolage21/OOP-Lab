package FinalOOPLab;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CompareDOB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first date of birth (yyyy-mm-dd): ");
        String dob1 = scanner.nextLine();
        System.out.print("Enter the second date of birth (yyyy-mm-dd): ");
        String dob2 = scanner.nextLine();
        scanner.close();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = dateFormat.parse(dob1);
            Date date2 = dateFormat.parse(dob2);

            if (date1.before(date2)) {
                System.out.println("The first person is elder.");
            } else if (date1.after(date2)) {
                System.out.println("The first person is younger.");
            } else {
                System.out.println("Both persons are of the same age.");
            }
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-mm-dd format.");
        }
    }
}

