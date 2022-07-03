package command.executor;

import command.CommandType;
import main.Patient;

public class PatientView extends AbstractExecutor {
    @Override
    public int execute(String command) {
        return viewPatient(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.WRITE_ALL_PATIENTS;
    }


    private int viewPatient(String command) {
        for (Patient patient : patientRepository.getAllPatient()) {
            System.out.printf("ID: \"%s\". Name: \"%s\". Date registration: %s %n ",
                    patient.getIdCounter(),
                    patient.getName(),
                    patient.getCreationDate());
        }
        return 1;
    }
}
