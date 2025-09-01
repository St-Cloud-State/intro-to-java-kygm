package Hw1Q3;

public class Person {
    public Person(String firstName, String lastname, String id) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.id = id;
    }

    private String firstName;
    private String lastname;
    private String id;

    // Need to override since toString is defined for all types
    @Override
    public String toString() {
        return firstName + " " + lastname + " " + id + "\n";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
