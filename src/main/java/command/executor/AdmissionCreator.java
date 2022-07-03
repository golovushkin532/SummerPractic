package command.executor;

import command.CommandType;
import main.Admission;
import main.Doctor;
import main.Patient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class AdmissionCreator extends AbstractExecutor {
    @Override
    public int execute(String command) {
        return createAdmission(command);
    }

    private int createAdmission(String command) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        var wordsArray = command.split(" ");
        Optional<Patient> patient = findPatient(Integer.parseInt(wordsArray[2]));
        Optional<Doctor> doctor = findDoctor(Integer.parseInt(wordsArray[3]));

        if (patient.isPresent() && doctor.isPresent()) {
            admissionRepository.saveAdmission(new Admission(patient.get().getIdCounter(), doctor.get().getId(), "NEW", LocalDateTime.parse(wordsArray[4] + " " + wordsArray[5], formatter).toString()));

            System.out.println("Admission created");
        } else {
            System.out.println("Incorrect data");
        }
        return 1;
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_ADMISSION;
    }
}
