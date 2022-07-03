package command.executor;

import command.CommandType;
import main.Patient;

import java.util.Optional;

public class PatientUpdate extends AbstractExecutor {
    @Override
    public int execute(String command) {
        return updatePatient(command);
    }

    private int updatePatient(String command) {
        var wordsArray = command.split(" ");

        var patientId = wordsArray[2];

        Optional<Patient> patientToUpdate = findPatient(Integer.parseInt((patientId)));

        if (patientToUpdate.isPresent()) {
            patientRepository.updateName(patientToUpdate.get(), wordsArray[3]);

            System.out.println("Patient update");
        } else {
            System.out.println("Patient not founded");
        }


        return 1;
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.UPDATE_PATIENT;
    }
}
