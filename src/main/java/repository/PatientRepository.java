package repository;

import main.Patient;

import java.util.Set;

public interface PatientRepository {
    void savePatient(Patient patient);

    Set<Patient> getAllPatient();

    void remove(Patient patient);

    void updateName(Patient patient, String name);
}
