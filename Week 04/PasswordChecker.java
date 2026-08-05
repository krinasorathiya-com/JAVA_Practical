class Main {
    public static void main(String[] args) {

        // 1. Minimum 8 characters
        String pat1 = ".{8,}";
        String str1 = "Abcd1234";
        System.out.println("1. Min 8 characters : " + str1.matches(pat1));

        // 2. Contains uppercase letter
        String pat2 = ".*[A-Z].*";
        String str2 = "Abcd1234";
        System.out.println("2. Contains Uppercase : " + str2.matches(pat2));

        // 3. Contains digit
        String pat3 = ".*[0-9].*";
        String str3 = "Abcd1234";
        System.out.println("3. Contains Digit : " + str3.matches(pat3));

        // 4. Contains special character
        String pat4 = ".*[^a-zA-Z0-9].*";
        String str4 = "Abcd1234!";
        System.out.println("4. Contains Special Character : " + str4.matches(pat4));

        // 5. Strong password (all conditions)
        String pat5 = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{8,}$";
        String str5 = "Abcd1234!";
        System.out.println("5. Strong Password : " + str5.matches(pat5));

        // 6. Only alphabets
        String pat6 = "[A-Za-z]+";
        String str6 = "Krina";
        System.out.println("6. Only Alphabets : " + str6.matches(pat6));

        // 7. Only digits
        String pat7 = "[0-9]+";
        String str7 = "123456";
        System.out.println("7. Only Digits : " + str7.matches(pat7));

        // 8. Starts with uppercase
        String pat8 = "[A-Z].*";
        String str8 = "Krina123";
        System.out.println("8. Starts with Uppercase : " + str8.matches(pat8));

        // 9. Ends with two digits
        String pat9 = ".*[0-9]{2}";
        String str9 = "Krina88";
        System.out.println("9. Ends with Two Digits : " + str9.matches(pat9));

        // 10. Starts with letter and ends with digit
        String pat10 = "[A-Za-z].*[0-9]";
        String str10 = "Krina8";
        System.out.println("10. Starts with Letter & Ends with Digit : " + str10.matches(pat10));

    }
}