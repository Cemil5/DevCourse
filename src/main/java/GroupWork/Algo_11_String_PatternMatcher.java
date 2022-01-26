package GroupWork;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Question # 11
Description: Pattern Matcher
Difficulty: Medium Category: String
You're given two non-empty strings. The first one is a pattern consisting of only "x" s and / or
"y" s; the other one is a normal string of alphanumeric characters. Write a function that
checks whether the normal string matches the pattern.

A string S0 is said to match a pattern if replacing all "x" s in the pattern with some non-empty substring S1 of S0
and replacing all "y" s in the pattern with some non-empty substring S2 of S0 yields the same string S0 .

If the input string doesn't match the input pattern, the function should return an empty array;
otherwise, it should return an array holding the strings S1 and S2 that represent "x" and "y"
in the normal string, in that order. If the pattern doesn't contain any "x" s or "y" s, the
respective letter should be represented by an empty string in the final array that you return.
You can assume that there will never be more than one pair of strings S1 and S2 that
appropriately represent "x" and "y" in the normal string.
Sample Input
pattern = "xxyxxy" string = "gogopowerrangergogopowerranger"
Sample Output
["go", "powerranger"]
 */
public class Algo_11_String_PatternMatcher {
    public static void main(String[] args) {

        String pattern="xxyxxy";
        String str="gogopowerrangersgogopowerrangers";
        System.out.println(str.length());
        System.out.println(Arrays.deepToString(myPatternMatcher(pattern,str)));
        System.out.println(Arrays.deepToString(patternMatcher(pattern,str)));
    }

    // my solution
    // precondition : if there are x and y in pattern, x must come first
    public static String [] myPatternMatcher(String pattern, String str) {
        Map<Character, Integer> patternCount = new HashMap<>();
        int xRep = 0;   // x represents xRep number of characters
        int yRep = 0;
        int yStartIndex = 0;
        String possibleMatch;
        String x, y;

        char[] patternChar = pattern.toCharArray();
        for (Character ch : patternChar) {
            patternCount.put(ch, patternCount.getOrDefault(ch, 0) + 1);
        }
        int xCount = patternCount.get('x');
        int yCount = patternCount.get('y');
        System.out.println("patternCount : " + patternCount);

        do {
            if (xCount > 0 && yCount > 0) {
                do {
                    xRep++;
                    double temp = (str.length() - (xRep * xCount)) / (double) yCount;
                    yRep = (int) temp;
                } while (xRep * xCount + yRep * yCount != str.length() && xRep < str.length() && yRep >0);
                System.out.println("xRep : " + xRep + " yRep : " + yRep);
                yStartIndex = xRep * pattern.indexOf('y');
            } else {
                if (xCount == 0) {
                    yRep = str.length() / yCount;
                } else xRep = str.length() / xCount;
            }

            x = str.substring(0, xRep);
            y = str.substring(yStartIndex, yStartIndex + yRep);
            possibleMatch = "";
            for (char ch : patternChar) {
                switch (ch) {
                    case 'x':
                        possibleMatch += x;
                        break;
                    case 'y':
                        possibleMatch += y;
                        break;
                }
            }
        } while (!possibleMatch.equals(str) && xRep < str.length() && yRep > 0);
        return str.equals(possibleMatch) ? new String[]{x, y} : new String[]{};
    }


    // O(n^2 + m) time | O(n + m) space
    public static String[] patternMatcher(String pattern, String str) { // best solution for me
        if (pattern.length() > str.length()) {
            return new String[]{};
        }
        char[] newPattern = getNewPattern(pattern);
        boolean didSwitch = newPattern[0] != pattern.charAt(0);
        Map<Character, Integer> counts = new HashMap<>();
        counts.put('x', 0);
        counts.put('y', 0);
        int firstYPos = getCountsAndFirstYPos(newPattern, counts);
        if (counts.get('y') != 0) {
            for (int lenOfX = 1; lenOfX < str.length(); lenOfX++) {
                double lenOfY =
                        ((double) str.length() - (double) lenOfX * (double) counts.get('x'))
                                / (double) counts.get('y');
                if (lenOfY <= 0 || lenOfY % 1 != 0) {
                    continue;
                }
                int yIdx = firstYPos * lenOfX;
                String x = str.substring(0, lenOfX);
                String y = str.substring(yIdx, yIdx + (int) lenOfY);
                String potentialMatch = buildPotentialMatch(newPattern, x, y);
                if (str.equals(potentialMatch)) {
                    return didSwitch ? new String[] {y, x} : new String[] {x, y};
                }
            }
        } else {
            double lenOfX = str.length() / counts.get('x');
            if (lenOfX % 1 == 0) {
                String x = str.substring(0, (int) lenOfX);
                String potentialMatch = buildPotentialMatch(newPattern, x, "");
                if (str.equals(potentialMatch)) {
                    return didSwitch ? new String[] {"", x} : new String[] {x, ""};
                }
            }
        }
        return new String[] {};
    }
    public static char[] getNewPattern(String pattern) {
        char[] patternLetters = pattern.toCharArray();
        if (pattern.charAt(0) == 'x') {
            return patternLetters;
        }
        for (int i = 0; i < patternLetters.length; i++) {
            if (patternLetters[i] == 'x') {
                patternLetters[i] = 'y';
            } else {
                patternLetters[i] = 'x';
            }
        }
        return patternLetters;
    }
    public static int getCountsAndFirstYPos(char[] pattern, Map<Character, Integer> counts) {
        int firstYPos = -1;
        for (int i = 0; i < pattern.length; i++) {
            char c = pattern[i];
            counts.put(c, counts.get(c) + 1);
            if (c == 'y' && firstYPos == -1) {
                firstYPos = i;
            }
        }
        return firstYPos;
    }
    public static String buildPotentialMatch(char[] pattern, String x, String y) {
        StringBuilder potentialMatch = new StringBuilder();
        for (char c : pattern) {
            if (c == 'x') {
                potentialMatch.append(x);
            } else {
                potentialMatch.append(y);
            }
        }
        return potentialMatch.toString();
    }

    // ***********************************************************

    public static boolean wordPatternMatch(String pattern, String str) {
        if (str == null || str.length() == 0) {
            return pattern == null || pattern.length() == 0;
        }

        if (pattern == null || pattern.length() == 0) {
            return str == null || str.length() == 0;
        }

        int len = pattern.length();

        Map<String, Character> map = new HashMap<>();
        Map<Character, String> invertedMap = new HashMap<>();

        return wordPatternMatchHelper(0, 0, pattern, str, map, invertedMap);
    }

    private static boolean wordPatternMatchHelper(int start, int seg, String pattern,
                                                  String str,
                                                  Map<String, Character> map,
                                                  Map<Character, String> invertedMap) {
        if (start == str.length() && seg == pattern.length()) {
            return true;
        }

        if (start >= str.length() || seg >= pattern.length()) {
            return false;
        }

        char c = pattern.charAt(seg);
        for (int i = start; i < str.length(); i++) {
            String substr = str.substring(start, i + 1);

            if (map.containsKey(substr) &&
                    invertedMap.containsKey(c) &&
                    map.get(substr) == c &&
                    invertedMap.get(c).equals(substr)) {
                if (wordPatternMatchHelper(i + 1, seg + 1, pattern,
                        str, map, invertedMap)) {
                    return true;
                }
            }

            if (!map.containsKey(substr) && !invertedMap.containsKey(c)) {
                map.put(substr, c);
                invertedMap.put(c, substr);

                if (wordPatternMatchHelper(i + 1, seg + 1, pattern,
                        str, map, invertedMap)) {
                    return true;
                }

                map.remove(substr);
                invertedMap.remove(c);
            }
        }

        return false;
    }


}
