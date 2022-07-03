package command;

import command.executor.*;

import java.util.Map;
import java.util.Scanner;

public class CommandReader {
    private static final Map<CommandType, Executor> COMMAND_EXECUTORS_GROUP_BY_COMMAND = Map.of(
            CommandType.CREATE_PATIENT, new PatientCreator(),
            CommandType.DELETE_PATIENT, new PatientDelete(),
            CommandType.WRITE_ALL_PATIENTS, new PatientView(),
            CommandType.UPDATE_PATIENT, new PatientUpdate(),
            CommandType.CREATE_DOCTOR, new DoctorCreator(),
            CommandType.WRITE_ALL_DOCTORS, new DoctorView(),
            CommandType.CREATE_ADMISSION, new AdmissionCreator(),
            CommandType.WRITE_ALL_ADMISSION, new AdmissionView(),
            CommandType.UPDATE_ADMISSION, new AdmissionUpdate()
    );


    public static void startReadCommand() {
        System.out.println("Program started. Write you command here:");
        Scanner s = new Scanner(System.in);

        int i = 1;
        while (i != 0) {
            i = readCommand(s);
        }
        s.close();
    }

    /**
     * create Patient (Name)
     * create Doctor (First_name Last_name specialization)
     * create Admission (Patient_id Doctor_id Date(**-**-** **:**))
     * delete Patient (Patient_id)
     * update Patient (Patient_id New_name)
     * update Admission (Admission_id New_status)
     * View All Patients
     * View All Doctors
     * View All Admission (Patient_id)
     * exit
     */
    private static int readCommand(Scanner s) {
        var commandString = s.nextLine();

        CommandType commandType = getCommandType(commandString);

        if (COMMAND_EXECUTORS_GROUP_BY_COMMAND.containsKey(commandType)) {
            var commandExecuter = COMMAND_EXECUTORS_GROUP_BY_COMMAND.get(commandType);
            return commandExecuter.execute(commandString);
        }
        if (commandType == commandType.EXIT) {
            return 0;
        }
        System.out.println("Incorrect command");
        return -1;
    }

    private static CommandType getCommandType(String commandString) {

        if (commandString.contains("create Patient")) {
            return CommandType.CREATE_PATIENT;
        }
        if (commandString.contains("create Doctor")) {
            return CommandType.CREATE_DOCTOR;
        }
        if (commandString.contains("create Admission")) {
            return CommandType.CREATE_ADMISSION;
        }

        if (commandString.contains("delete Patient")) {
            return CommandType.DELETE_PATIENT;
        }

        if (commandString.contains("update Patient")) {
            return CommandType.UPDATE_PATIENT;
        }
        if (commandString.contains("update Admission")) {
            return CommandType.UPDATE_ADMISSION;
        }
        if (commandString.contains("View All Patients")) {
            return CommandType.WRITE_ALL_PATIENTS;
        }
        if (commandString.contains("View All Doctors")) {
            return CommandType.WRITE_ALL_DOCTORS;
        }
        if (commandString.contains("View All Admission")) {
            return CommandType.WRITE_ALL_ADMISSION;
        }
        if (commandString.contains("exit")) {
            return CommandType.EXIT;
        }
        return CommandType.UNDEFINED;
    }
}
