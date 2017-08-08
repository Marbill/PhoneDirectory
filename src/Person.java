
import java.util.HashSet;
import java.util.Set;


/* @author marbi */
public class Person implements Comparable<Person> {

    private String name;
    private Set<String> numbers;
    private String address;

    public Person() {
        this.name = "";
        this.numbers = new HashSet<String>();
        this.address = "";
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        if (this.address.isEmpty()) {
            return "  address unknown";
        }
        return "  address: " + this.address;
    }

    public String getName() {
        return name;
    }

    public Set<String> getNumbers() {
        return numbers;
    }

    public void addNumber(String number) {
        numbers.add(number);
    }

    public String printNumbers() {
        String phoneNumbers = "";
        if (this.numbers.isEmpty()) {
            return "  phone number not found";
        }

        //System.out.println("  phone numbers:");
        for (String number : numbers) {
            phoneNumbers += "   " + number + "\n";
        }

        phoneNumbers = "  phone numbers:\n" + phoneNumbers.substring(0, phoneNumbers.length() - 1);

        return phoneNumbers;

    }

    @Override
    public String toString() {
        return this.name + "\n" + this.getAddress() + "\n" + this.printNumbers();
    }

    @Override
    public int compareTo(Person o) {
        return this.getName().compareTo(o.getName());
    }

}
