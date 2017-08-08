
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author marbi
 */
public interface PersonalInformation {

    void addPhone(Scanner reader);

    void searchByName(Scanner reader);

    void searchByNumber(Scanner reader);

    void addAddress(Scanner reader);

    void searchInformation(Scanner reader);

    void deletePerson(Scanner reader);

    void searchFiltered(Scanner reader);
}
