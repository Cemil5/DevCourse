package a_selfStudy_Code_Leet_Hacker.possibleMentorQuestions.a1_string_if;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class EmailValidation_HR_onlineInterview {
    /*
Your team has created a new bank website that requires email address to be validated.
The email string must contain an '@' character.
The email string must contain an '.' character.
The '@' must contain at least one character in front of it.
e.g. "a@example.com" is valid while "@example.com" is invalid.
The '.' and '@' must be in the appropriate places.
e.g. "mike.smith@com" is invalid while "mike.smith@example.com" is valid.
For a given string, find a solution that writes true on the console if an email is valid and false if it is invalid.
Examples:
str = "test@cydeo.com" --> true
str = "test@cydeo.co.in --> true
str = "@cydeo.com" --> false
 */

    @ParameterizedTest
    @CsvSource({
            "a@cydeo.com, true",
            "mike.smith@example.com, true",
            "test@cydeo.co.in, true",
            ".test@cydeo.co.in, false",
            "test@cydeo.co.in., false",
            "test@@cydeo.co.in, false",
            "mike.smith@.com, false",
            "mike.smith@com, false",
            "mike.smith@gmail..com, false",
            "@cydeo.com, false",
    })
    public void test(String email, Boolean isTrue) {
        Assertions.assertEquals(isTrue, isEmailValid(email));
    }

    public static boolean isEmailValid33(String emailAddress){    // khashayar
        if (emailAddress.contains("@") && emailAddress.contains(".") && emailAddress.indexOf("@") > 0 &&
                emailAddress.lastIndexOf('.') > emailAddress.indexOf("@")+1 && emailAddress.indexOf(".") <
                emailAddress.length() - 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEmailValid11(String email){   // dilara
        if(Character.isLetter(email.charAt(0))&& email.contains("@")&&email.contains(".")&&
                (email.indexOf('@') < email.lastIndexOf('.')&&(email.indexOf('@')==(email.lastIndexOf('@'))))){
            return true;
        }
        return false;
    }

    public boolean isEmailValid(String str){    // gadir
        boolean validEmailAddress = false;

        if (  str.contains("@") && ( (str.substring(str.indexOf('@')+1)).contains(".") &&
                !((str.substring(str.indexOf('@')+1)).contains("@")) &&
                !(str.substring( str.indexOf('@')+1, str.indexOf('@')+2  )).contains(".") )
                && !(str.substring(0,str.indexOf("@")).isBlank()) && !(str.charAt(str.length()-1)+"").equals(".") ){
            validEmailAddress = true;
        }
        return validEmailAddress;
    }

    public static boolean isEmailValid55(String email){
        return email.indexOf("@") > 0 && email.lastIndexOf('.') > email.indexOf("@") + 1
                && email.indexOf(".") < email.length() - 1;
    }

    public static boolean isEmailValid44(String str) {    // my solution
        int sign = str.indexOf("@");
        int dot = str.lastIndexOf(".");

        if (sign < 1 || sign >= str.length() - 3 || sign != str.lastIndexOf("@")) {
            return false;
        }

        return dot != str.length() - 1 && sign <= dot && sign + 1 != dot;
    }

    public boolean isEmailValid77(String email){

        // Simplest regex to validate email
       // System.out.println("email check: " + email.matches("^(.+)@(.+)$"));

        //  Java email validation permitted by RFC 5322
        String regexRFC5322 = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@(?!-)[a-zA-Z0-9.-]+$";
       // System.out.println("email check: " + email.matches(regexRFC5322));

        // https://howtodoinjava.com/java/regex/java-regex-validate-email-address/
        String regex1 = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        return email.matches(regex1);
    }
}

