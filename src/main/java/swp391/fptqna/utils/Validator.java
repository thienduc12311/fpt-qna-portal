package swp391.fptqna.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean checkEmailFPT(String email) {

        final Pattern pattern = Pattern.compile("^[\\w-\\.]+@fpt.edu.vn", Pattern.CASE_INSENSITIVE);
        final Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }



    public static boolean checkFullName(String fullName) {
        if (fullName.length() > 50) {
            return false;
        }
        return true;
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        final Pattern pattern = Pattern.compile("(84|0[3|5|7|8|9])+([0-9]{8})\\b", Pattern.CASE_INSENSITIVE);
        final Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}