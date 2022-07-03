package command.executor;

import command.AdmissionStatus;
import command.CommandType;
import main.Admission;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class AdmissionUpdate extends AbstractExecutor {
    @Override
    public int execute(String command) {
        return updateStatus(command);
    }

    private static final Set<String> stringSet = new HashSet<>();

    private static final Map<AdmissionStatus, String> ADMISSION_STATUS_STRING_MAP = Map.of(
            AdmissionStatus.NEW, "New",
            AdmissionStatus.CANCELED, "Canceled",
            AdmissionStatus.AWAITING_PAYMENT, "Payment",
            AdmissionStatus.CLOSED, "Closed",
            AdmissionStatus.IN_PROCESS, "Process"
    );

    private int updateStatus(String command) {
        String[] wordArray = command.split(" ");

        var statusAdmission = wordArray[3];

        AdmissionStatus admissionStatus = getAdmissionStatus(statusAdmission);

        Optional<Admission> admissionToUpdate = findAdmission(Integer.parseInt(wordArray[2]));
        if (ADMISSION_STATUS_STRING_MAP.containsKey(admissionStatus)) {

            if (admissionToUpdate.isPresent()) {
                admissionRepository.updateStatus(admissionToUpdate.get(), wordArray[3]);
                System.out.println("Status is Updating");
            } else {
                System.out.println("Admission null");
            }
        } else {
            System.out.println("Incorrect status");
            return -1;
        }
        return 1;
    }

    private static AdmissionStatus getAdmissionStatus(String admissionStatus) {
        if (admissionStatus.contains("Canceled")) {
            return AdmissionStatus.CANCELED;
        }
        if (admissionStatus.contains("Payment")) {
            return AdmissionStatus.AWAITING_PAYMENT;
        }
        if (admissionStatus.contains("Closed")) {
            return AdmissionStatus.CLOSED;
        }
        if (admissionStatus.contains("Process")) {
            return AdmissionStatus.IN_PROCESS;
        }
        return AdmissionStatus.UNDEFINED;
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.UPDATE_ADMISSION;
    }
}
