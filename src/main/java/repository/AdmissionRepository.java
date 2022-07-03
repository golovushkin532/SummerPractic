package repository;

import main.Admission;

import java.util.Set;

public interface AdmissionRepository {
    Set<Admission> getAllAdmission();

    void saveAdmission(Admission newAdmission);

    void updateStatus(Admission admission, String status);
}
