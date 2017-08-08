
import java.util.Scanner;

public class Main {

    public static void menu(Scanner in, PersonalInformation pi) {
        while (true) {            
            System.out.print("command: ");
            String command = in.nextLine();
                        
            if (command.equals("1")) {
                pi.addPhone(in);
            } else if (command.equals("2")) {
                pi.searchByName(in);
            } else if (command.equals("3")) {
                pi.searchByNumber(in);
            } else if (command.equals("4")) {
                pi.addAddress(in);
            } else if (command.equals("5")) {
                pi.searchInformation(in);
            } else if (command.equals("6")) {
                pi.deletePerson(in);
            } else if (command.equals("7")) {
                pi.searchFiltered(in);
            } else {
                break;
            }            
        }
    }

    public static void main(String[] args) {
        // Start your program here
        // ATTENTION: In your program, you can create only one instance of class Scanner!

        PersonalInformation phoneBook = new PhoneSearch();
        Scanner in = new Scanner(System.in);

        System.out.println("phone search");
        System.out.println("available operations:");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit");
        System.out.println();

        menu(in, phoneBook);

    }
}
