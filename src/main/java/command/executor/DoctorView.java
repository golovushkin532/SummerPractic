package command.executor;

import command.CommandType;
import main.Doctor;

public class DoctorView extends AbstractExecutor {
    @Override
    public int execute(String command) {
        return viewDoctor(command);
    }

    private int viewDoctor(String command) {
        for (Doctor doctor : doctorRepository.getAllDoctor()) {
            System.out.printf("ID: \"%s\". First name: \"%s\". Last name: \"%s\". Specialization: %s %n ",
                    doctor.getId(),
                    doctor.getFirstName(),
                    doctor.getLastName(),
                    doctor.getSpecialization());
        }
        return 1;
    }

    @Override
    public CommandType getCommandType() {
        return null;
    }
}
