package main;

import command.CommandReader;

public class Main {
    public static void main(String[] args) {

        int code = Authentication.authenticate();
        if (code == 0) {
            System.out.println("Successfully: \n Command List: \n create Patient (Name) \n create Doctor (First_name Last_name specialization) \n create Admission (Patient_id Doctor_id Date(**-**-** **:**)) \n" +
                    " delete Patient (Patient_id) \n update Patient (Patient_id New_name) \n update Admission (Admission_id New_status) \n View All Patients\n View All Doctors \n View All Admission (Patient_id) \n exit ");
        } else {
            System.out.println("Failed");
        }

        CommandReader.startReadCommand();
    }
}
