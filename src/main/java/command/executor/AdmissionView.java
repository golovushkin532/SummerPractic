package command.executor;

import command.CommandType;
import main.Admission;
import main.Patient;

import java.util.Optional;

public class AdmissionView extends AbstractExecutor {
    @Override
    public int execute(String command) {
        return viewAdmission(command);
    }

    private int viewAdmission(String command) {
        String[] wordsArray = command.split(" ");
        Optional<Patient> patient = findPatient(Integer.parseInt(wordsArray[3]));
        if (patient.isPresent()) {
            for (Admission admission : admissionRepository.getAllAdmission()) {
                if (admission.getPatientId() == patient.get().getIdCounter()) {
                    System.out.printf("ID Admission: %d. ID Patient: %s. ID Doctor: %s. Status Admission: %s. Date Admission: %s \n",
                            admission.getId(),
                            admission.getPatientId(),
                            admission.getDoctorId(),
                            admission.getStatus(),
                            admission.getData());
                }
            }
        } else {
            System.out.println("Incorrect patientID");
        }
        return 1;
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.WRITE_ALL_ADMISSION;
    }
}
