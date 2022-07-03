package repository.impl;

import main.Doctor;
import repository.DoctorRepository;

import java.util.HashSet;
import java.util.Set;


public class DoctorRepositoryImpl implements DoctorRepository {
    private static final Set<Doctor> DOCTORS = new HashSet<>();
    private static final DoctorRepositoryImpl SINGLETON = new DoctorRepositoryImpl();

    private DoctorRepositoryImpl() {

    }

    public static DoctorRepository getSingelton() {
        return SINGLETON;
    }


    @Override
    public Set<Doctor> getAllDoctor() {
        return DOCTORS;
    }

    @Override
    public void saveDoctor(Doctor newDoctor) {
        DOCTORS.add(newDoctor);
    }
}
