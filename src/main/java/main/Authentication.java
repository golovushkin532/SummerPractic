package main;

import java.util.Scanner;

public class Authentication {
    private static final String LOGIN = "Admin";
    public static final String PASSWORD = "123";


    public static int authenticate() {

        boolean isLoginSuccess = false;

        Scanner s = new Scanner(System.in);
        for (int count = 3; count > 0 && !isLoginSuccess; count--) {

            System.out.println("Login:");
            var login = s.nextLine();

            System.out.println("Password:");
            var password = s.nextLine();

            if (login.equals(LOGIN) && password.equals(PASSWORD)) {
                isLoginSuccess = true;
            }
            count--;
        }
        return isLoginSuccess ? 0 : -1;
    }
}
