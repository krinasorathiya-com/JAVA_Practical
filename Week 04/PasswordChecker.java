public class PasswordChecker {

    public boolean hasLength(String pw) {
        return pw.matches(".{8,}");
    }

    public boolean hasUppercase(String pw) {
        return pw.matches(".*[A-Z].*");
    }

    public boolean hasDigit(String pw) {
        return pw.matches(".*\\d.*");
    }

    public boolean hasSpecial(String pw) {
        return pw.matches(".*[^a-zA-Z0-9].*");
    }

    
    public String strength(String pw) {
        int count = 0;

        if (hasLength(pw))
            count++;
        if (hasUppercase(pw))
            count++;
        if (hasDigit(pw))
            count++;
        if (hasSpecial(pw))
            count++;

        if (count <= 1)
            return "Weak";
        else if (count <= 3)
            return "Medium";
        else
            return "Strong";
    }
}