package a_selfStudy_Code_Leet_Hacker.fatih_27mayis.sentToPossibleMentorQuestions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Locale;

/*
Problem : Count the number of Duplicated Letters
Level-3
Write a function that will return the count of distinct case-insensitive alphabetic characters and
numeric digits that occur more than once in the input string. The input string can be assumed to
contain only alphabets (both uppercase and lowercase) and numeric digits.
Example:
"abcde" -> 0 # no characters repeats more than once
"aabbcde" -> 2 # 'a' and 'b'
"aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
"indivisibility" -> 1 # 'i' occurs six times
"Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
"aA11" -> 2 # 'a' and '1'
"ABBA" -> 2 # 'A' and 'B' each occur twice
 */
public class NumberOfDuplicatedLetters_Fatih_27may {
    int getNumber(String str){
        str = str.toLowerCase(Locale.ROOT);
        String temp = "";
        String output = "";
        for (char ch:str.toCharArray()){
            if (!temp.contains(ch+"")){
                temp+=ch;
            } else if (!output.contains(ch+"")){
                output +=ch;
            }
        }
        return output.length();
    }

    @ParameterizedTest
    @CsvSource({
            "abcde, 0",
            "aabbcde, 2",
            "aabBcde, 2",
            "indivisibility, 1",
            "Indivisibilities, 2",
            "aA11, 2",
            "ABBA, 2",
    })
    void test(String str, int i){
        Assertions.assertEquals(i, getNumber(str));
    }


}
