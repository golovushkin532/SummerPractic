package command.executor;

import main.Admission;
import main.Doctor;
import main.Patient;
import repository.DoctorRepository;
import repository.PatientRepository;
import repository.impl.DoctorRepositoryImpl;
import repository.impl.PatientRepositoryImpl;
import repository.AdmissionRepository;
import repository.impl.AdmissionRepositorylmpl;

import java.util.Optional;

public abstract class AbstractExecutor implements Executor {
    protected final PatientRepository patientRepository = PatientRepositoryImpl.getSingleton();
    protected final DoctorRepository doctorRepository = DoctorRepositoryImpl.getSingelton();
    protected final AdmissionRepository admissionRepository = AdmissionRepositorylmpl.getSingelton();

    protected Optional<Patient> findPatient(int patientId) {
        for (Patient patient : patientRepository.getAllPatient()) {
            if (patient.getIdCounter() == patientId) {
                return Optional.of(patient);
            }
        }

        return Optional.empty();
    }

    protected Optional<Doctor> findDoctor(int doctorId) {
        for (Doctor doctor : doctorRepository.getAllDoctor()) {
            if (doctor.getId() == doctorId) {
                return Optional.of(doctor);
            }
        }

        return Optional.empty();
    }

    protected Optional<Admission> findAdmission(int admissionId) {
        for (Admission admission : admissionRepository.getAllAdmission()) {
            if (admission.getId() == admissionId) {
                return Optional.of(admission);
            }
        }

        return Optional.empty();
    }
}
