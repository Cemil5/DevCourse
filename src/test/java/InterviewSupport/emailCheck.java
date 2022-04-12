package InterviewSupport;
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
str = "test@example.com" --> true
str = "test@example.co.in --> true
str = "@example.com" --> false
 */
public class emailCheck {

    public static void main(String[] args) {

        String str = "a@maa.a";
        boolean result = true;
        int sign = str.indexOf("@");
        int dot = str.lastIndexOf(".");

        if (sign < 1 || sign>= str.length()-3 || sign != str.lastIndexOf("@")){
            result = false;
        }

        if (dot < 1 || dot == str.length()-1 || sign > dot || sign + 1 == dot){
            result = false;
        }
        System.out.println("result : " + result);
    }
}
