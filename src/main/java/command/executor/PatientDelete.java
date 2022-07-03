package command.executor;

import command.CommandType;
import main.Patient;

import java.util.Optional;

public class PatientDelete extends AbstractExecutor {
    @Override
    public int execute(String command) {
        return patientDelete(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.DELETE_PATIENT;
    }

    private int patientDelete(String command) {
        var idArray = command.split(" ");

        var patientIdToDelete = idArray[2];

        Optional<Patient> patientToDelete = findPatient(Integer.parseInt((patientIdToDelete)));

        if (patientToDelete.isPresent()) {
            patientRepository.remove(patientToDelete.get());

            System.out.println("Patient deleted");
        } else {
            System.out.println("Patient not founded");
        }
        return 1;
    }
}
