package command.executor;

import command.CommandType;
import main.Patient;

public class PatientCreator extends AbstractExecutor {
    @Override
    public int execute(String command) {
        return createPatient(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_PATIENT;
    }

    private int createPatient(String command) {
        var wordsArray = command.split(" ");

        var patientName = wordsArray[2];

        var newPatient = new Patient(patientName);
        patientRepository.savePatient(newPatient);

        System.out.println(newPatient.getIdCounter());
        System.out.println("Patient created");
        return 1;
    }
}