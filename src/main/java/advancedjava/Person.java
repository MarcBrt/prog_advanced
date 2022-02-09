package advancedjava;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a advancedjava.Person.
 *
 * @author Marco Jakob
 */
public class Person {

    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty street;
    private final IntegerProperty postalCode;
    private final StringProperty city;
    private final ObjectProperty<LocalDate> birthday;

    /**
     * Default constructor.
     */
    public Person() {
        this(null, null);
    }

    /**
     * Constructor with some initial data.
     *
     * @param firstName
     * @param lastName
     */
    public Person(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

        // Some initial dummy data, just for convenient testing.
        this.street = new SimpleStringProperty("some street");
        this.postalCode = new SimpleIntegerProperty(1234);
        this.city = new SimpleStringProperty("some city");
        this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getStreet() {
        return street.get();
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public StringProperty streetProperty() {
        return street;
    }

    public int getPostalCode() {
        return postalCode.get();
    }

    public void setPostalCode(int postalCode) {
        this.postalCode.set(postalCode);
    }

    public IntegerProperty postalCodeProperty() {
        return postalCode;
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public StringProperty cityProperty() {
        return city;
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    public static ArrayList<Person> getPersonsExamples()
    {
        ArrayList<Person> list=new ArrayList<>();
        Person p=new Person("firstName1", "lastName1");
        p.setBirthday(LocalDate.of(1972, 3, 21));
        list.add(p);
        p=new Person("firstName3", "lastName3");
        p.setBirthday(LocalDate.of(1983, 5, 2));
        list.add(p);
        p=new Person("firstName2", "lastName2");
        p.setBirthday(LocalDate.of(1980, 4, 3));
        list.add(p);
        p=new Person("firstName8", "lastName8");
        p.setBirthday(LocalDate.of(2015, 3, 16));
        list.add(p);
        p=new Person("firstName5", "lastName5");
        p.setBirthday(LocalDate.of(1989, 6, 4));
        list.add(p);
        p=new Person("firstName6", "lastName6");
        p.setBirthday(LocalDate.of(1995, 9, 30));
        list.add(p);
        p=new Person("firstName4", "lastName4");
        p.setBirthday(LocalDate.of(1986, 1, 2));
        list.add(p);
        p=new Person("firstName7", "lastName7");
        p.setBirthday(LocalDate.of(2006, 12, 8));
        list.add(p);
        return list;
    }
}