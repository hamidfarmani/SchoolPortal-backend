package schoolPortal.util;

/**
 * Created by Hamid on 10/26/2018.
 */
public class UsersUtil {
    public static Status checkPasswordRules(String password){
        Status result = Status.UNKNOWN_ERROR;
        if(password.length()>8){
            if(checkString(password)){
                result = Status.OK;
            }else{
                result = Status.PASS_UPPER_LOWER_SIGN_NUMBER;
            }
        }else{
            result = Status.PASS_LENGTH;
        }
        return result;
    }

    private static boolean checkString(String str) {
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        String specialChar = " !#$%&'()*+,-./:;<=>?@[]^_`{|}~";
        boolean specialCharFlag = false;
        for(int i=0;i < str.length();i++) {
            ch = str.charAt(i);
            if( Character.isDigit(ch)) {
                numberFlag = true;
            }
            else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }else if(specialChar.contains(String.valueOf(ch))){
                specialCharFlag = true;
            }
            if(numberFlag && capitalFlag && lowerCaseFlag && specialCharFlag)
                return true;
        }
        return false;
    }
}
