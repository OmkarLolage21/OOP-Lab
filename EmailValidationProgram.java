package FinalOOPLab;

import java.util.Scanner;

class InvalidEmailException extends Exception {
    InvalidEmailException(String message) {
        super(message);
    }
}

class EmailValidator {
    static void validateEmail(String email) throws InvalidEmailException {
        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new InvalidEmailException("Invalid email address. Email must contain '@' and '.'");
        }

        int atIndex = email.indexOf("@");
        int dotIndex = email.lastIndexOf(".");

        if (atIndex >= dotIndex) {
            throw new InvalidEmailException("Invalid email address. '@' should come before '.'");
        }

        System.out.println("Valid email address: " + email);
    }
}

public class EmailValidationProgram {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String email = sc.nextLine();
        try {
                EmailValidator.validateEmail(email);
        } catch (InvalidEmailException e) {
                System.out.println("Invalid Email: " + e.getMessage());
        }
    }
}
