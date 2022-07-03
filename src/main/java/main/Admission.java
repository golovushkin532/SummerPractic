package main;

import java.util.Objects;

public class Admission {
    private int doctorId;
    private int patientId;
    private String status;
    private String date;
    private static int idCounter = 0;
    private int id = generateID();


    public static synchronized Integer generateID() {
        return (idCounter++);
    }

    public Admission(int patientId, int doctorId, String status, String date) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.status = status;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admission admission = (Admission) o;
        return id == admission.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getData() {
        return date;
    }
}
