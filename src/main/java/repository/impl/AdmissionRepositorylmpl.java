package repository.impl;

import main.Admission;
import repository.AdmissionRepository;

import java.util.HashSet;
import java.util.Set;

public class AdmissionRepositorylmpl implements AdmissionRepository {
    private static final Set<Admission> ADMISSIONS = new HashSet<>();
    private static final AdmissionRepositorylmpl SINGELTON = new AdmissionRepositorylmpl();

    private AdmissionRepositorylmpl() {

    }

    public static AdmissionRepository getSingelton() {
        return SINGELTON;
    }

    @Override
    public Set<Admission> getAllAdmission() {
        return ADMISSIONS;
    }

    @Override
    public void saveAdmission(Admission newAdmission) {
        ADMISSIONS.add(newAdmission);
    }

    @Override
    public void updateStatus(Admission admission, String status) {
        ADMISSIONS.remove(admission);
        admission.setStatus(status);
        ADMISSIONS.add(admission);
    }

}
