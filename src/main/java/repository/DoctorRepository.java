package repository;

import main.Doctor;

import java.util.Set;

public interface DoctorRepository {
    Set<Doctor> getAllDoctor();

    void saveDoctor(Doctor newDoctor);
}
