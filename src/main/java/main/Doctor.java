package main;

public class Doctor {
    private String firstName;
    private String lastName;
    private String specialization;
    private Integer id = generateID();
    private static int idCounter = 0;

    public static synchronized Integer generateID() {
        return (idCounter++);
    }


    public Doctor(String firstName, String lastName, String specialization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public String getSpecialization() {
        return specialization;
    }
}
