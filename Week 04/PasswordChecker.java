public class PasswordChecker {

    public String strength(String password) {

        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,}$";

        if (password.matches(regex)) {
            return "Strong";
        } else {
            return "Weak/Medium";
        }
    }
}
