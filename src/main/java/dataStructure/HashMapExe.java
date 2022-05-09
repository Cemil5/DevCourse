package dataStructure;

import java.util.*;

public class HashMapExe {

    public static void main(String[] args) {

        String str = "a green apple";

        System.out.println("first non-repeated char : " + findFirstNonRepeated(str));
        System.out.println("first non-repeated char with hashMap: " + findFirstNonRepeated_hashMap(str));
        System.out.println("first repeated char with map : " + findFirstRepeated_map(str));
        System.out.println("first repeated char with set : " + findFirstRepeated_set(str));
        System.out.println("first repeated char with altMap : " + findAltMap(str));

    }

    public static Map<Character, Integer> convertLinkedHashMap(String str){
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i<str.length();i++){
            Character c = str.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, 1);
            } else {
                map.replace(c, map.get(c)+1);
            }
        }
        return map;
    }

    public static Character findFirstNonRepeated(String str){

        Map<Character, Integer> map = convertLinkedHashMap(str);

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return '0';
    }

    public static Map<Character, Integer> convertToHashMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.replace(c, map.get(c) + 1);
            }
        }
        return map;
    }

    public static Character findFirstNonRepeated_hashMap(String str){

        Map<Character, Integer> map = convertToHashMap(str);

        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (map.get(c) == 1) return c;
        }
        return '0';
    }

    public static Character findFirstRepeated_map(String str){

        Map<Character, Integer> map = convertLinkedHashMap(str);

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1){
                return entry.getKey();
            }
        }
        return '0';
    }

    public static Character findAltMap(String str){
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i<str.length();i++){
            Character c = str.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, 1);
            } else {
                map.replace(c, map.get(c)+1);
            }
            if (map.get(c)>1) return c;
        }
        return '0';
    }

    public static Character findFirstRepeated_set(String str){
        Set<Character> set = new HashSet<>();

        for (int i = 0; i <str.length(); i++) {
            Character c = str.charAt(i);
            if (!set.contains(c)){
                set.add(c);
            } else return c;
        }
        return '0';
    }
}
