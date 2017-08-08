
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


/* @author marbi */
public class PhoneSearch implements PersonalInformation {

    private Map<String, Person> people;

    public PhoneSearch() {
        this.people = new HashMap<String, Person>();
    }

    private List<Person> personObjects() {
        List<Person> temp = new ArrayList<Person>();
        for (Person value : this.people.values()) {
            temp.add(value);
        }

        Collections.sort(temp);

        return temp;
    }

    @Override
    public void addPhone(Scanner reader) {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        System.out.print("number: ");
        String number = reader.nextLine();

        if (!this.people.containsKey(name)) {
            Person person = new Person();
            person.setName(name);
            this.people.put(name, person);
        }

        this.people.get(name).addNumber(number);
        System.out.println();
    }

    @Override
    public void searchByName(Scanner reader) {
        System.out.print("whose number: ");
        String name = reader.nextLine();

        if (this.people.containsKey(name)) {
            //System.out.println(this.people.get(name).printNumbers());
            for (String number : this.people.get(name).getNumbers()) {
                System.out.println(" " + number);
            }
            System.out.println();
        } else {
            System.out.println("  not found\n");
        }
    }

    @Override
    public void searchByNumber(Scanner reader) {

        System.out.print("number: ");
        String number = reader.nextLine();
        boolean foundName = false;

        for (Person person : this.personObjects()) {
            if (person.getNumbers().contains(number)) {
                System.out.println(" " + person.getName());
                foundName = true;
                System.out.println();
            }
        }

        if (!foundName) {
            System.out.println(" not found\n");
        }
    }

    @Override
    public void addAddress(Scanner reader) {

        System.out.print("whose address: ");
        String name = reader.nextLine();
        System.out.print("street: ");
        String street = reader.nextLine();
        System.out.print("city: ");
        String city = reader.nextLine();

        if (!this.people.containsKey(name)) {
            Person person = new Person();
            person.setName(name);
            this.people.put(name, person);
        }

        this.people.get(name).setAddress(street + " " + city);
        System.out.println();
    }

    @Override
    public void searchInformation(Scanner reader) {
        System.out.print("whose information: ");
        String name = reader.nextLine();

        if (this.people.containsKey(name)) {
            System.out.println(this.people.get(name).getAddress());
            System.out.println(this.people.get(name).printNumbers());
            System.out.println();
        } else {
            System.out.println("not found\n");
        }
    }

    @Override
    public void deletePerson(Scanner reader) {
        System.out.print("whose information: ");
        String name = reader.nextLine();

        if (this.people.containsKey(name)) {
            this.people.remove(name);
        }

        System.out.println();
    }

    @Override
    public void searchFiltered(Scanner reader) {
        System.out.print("keyword (if empty, all listed): ");
        String keyword = reader.nextLine();
        boolean foundAddress = false;
        boolean foundNumber = false;
        boolean foundName = false;

        for (Person person : this.personObjects()) {
            if (person.getName().contains(keyword)) {
                System.out.println();
                System.out.println(person);
                foundName = true;
            }
        }

        if (!foundName) {
            for (Person person : this.personObjects()) {
                if (person.getAddress().contains(keyword)) {
                    System.out.println();
                    System.out.println(person);
                    foundAddress = true;
                }
            }
        }

        if (!foundAddress) {
            for (Person person : this.personObjects()) {
                if (person.getNumbers().contains(keyword)) {
                    System.out.println();
                    System.out.println(person);
                    foundNumber = true;
                }
            }
        }

        if (!foundName && !foundNumber && !foundAddress) {
            System.out.println(" keyword not found");
        }

        System.out.println();
    }

}
