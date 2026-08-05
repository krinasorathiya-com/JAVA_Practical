import your.package.PasswordChecker;
public static void main(String[] args) {

        PasswordChecker pc = new PasswordChecker();

        String[] password = {
                "abc",
                "Password",
                "Pass123",
                "Abcd1234!",
                "HELLO@12"
        };

        for (String pw : password) {

            System.out.println("Password : " + pw);

            System.out.println("Length >= 8        : " + pc.hasLength(pw));
            System.out.println("Uppercase Letter   : " + pc.hasUpperCase(pw));
            System.out.println("Contains Digit     : " + pc.hasDigit(pw));
            System.out.println("Special Character  : " + pc.hasSpecialChar(pw));

            System.out.println("Strength : " + pc.strength(pw));

            System.out.println("-------------------------------");
        }
    }
