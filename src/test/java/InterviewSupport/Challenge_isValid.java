package InterviewSupport;

import java.util.HashMap;
import java.util.Map;

public class Challenge_isValid {

    public static void main(String[] args) {

        System.out.println("caacb " + isValid("caacbbeeed"));
        System.out.println("accenture " + isValid("accenture"));
        System.out.println("abcdd " + isValid("aabcc"));

        String str = "aabbcc";
        System.out.println(str.replaceFirst("b",""));
      //  System.out.println(str.rep("b",""));

    }

    public static boolean isValid(String str){

        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<str.length(); i++){
            if (!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), 1);
            } else {
                map.replace(str.charAt(i), map.get(str.charAt(i))+1);
            }
        }
        System.out.println(map);
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (Map.Entry<Character , Integer> entry: map.entrySet()){
            if (entry.getValue() == 1){
                count1++;
            } else if (entry.getValue() == 2){
                count2++;
            } else if (entry.getValue() == 3){
                count3++;
            }
        }
      /*  for (Integer el : map.values()){
            if (el == 1){
                count1++;
            } else if (el == 2){
                count2++;
            } else if (el == 3){
                count3++;
            }
        }
*/
        System.out.println(count1 + " " + count2 + " " + count3);
        if (count1 == str.length() || count2*2 == str.length() || count3*3 == str.length()) return true;


        if (count1 == 1 && (count2*2+1 == str.length()) && count3 == 0) {
           return true;
        } else //map.entrySet().removeIf( o -> o.getValue() == 1);
            if (count2 == 1 && (count1 + 2) == str.length()&& count3 == 0){
           // map.entrySet().removeIf( o -> o.getValue() == 2);                 if (check(str, map)) return true;
            return true;
        }else return count3 == 1 && count1 == 0 && count2 * 2 + 3 == str.length();
    }
}
 /*
    public static boolean check (String str, Map<Character, Integer> map){
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (Map.Entry<Character , Integer> entry: map.entrySet()){
            if (entry.getValue() == 1){
                count1++;
            } else if (entry.getValue() == 2){
                count2++;
            } else if (entry.getValue() == 3){
                count3++;
            }
        }

        if (count1 == str.length()) return true;
        if (count2/2 == str.length() && count2 % 2 == 0) return true;
        if (count3/3 == str.length() && count3 % 3 == 0) return true;
        return false;
    }

     */