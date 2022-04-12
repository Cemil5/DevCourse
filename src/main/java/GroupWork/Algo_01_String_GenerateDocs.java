package GroupWork;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/*  question 1

You're given a string of available characters and a string representing a document
that you need to generate. Write a function that determines if you can generate the
document using the available characters. If you can generate the document, your function
should return true; otherwise, it should return false. You're only able to generate the
document if the frequency of unique characters in the characters string is greater than or
equal to the frequency of unique characters in the document string.
For example, if you're given characters = "abcabc" and document = "aabbccc" you
cannot generate the document because you're missing one c . The document that you need
to create may contain any characters, including special characters, capital letters, numbers,
and spaces.
Note: you can always generate the empty string ( "" ).
Sample Input :
characters = "!veDJaCyd vaeo perelo xw"
document = "Cydeo Java Developer!"
Sample Output :
true
 */
public class Algo_01_String_GenerateDocs {
    public static void main(String[] args) {
        String characters = "!veDJaCyd vaeo perelo xw";
        String document = "Cydeo Java Developer!";

//        System.out.println(generateDocs(characters, document) ? "PASS" : "FAIL");   // best solution for me
//        System.out.println(genDocs(characters, document) ? "PASS" : "FAIL");  // my first solution
//        System.out.println(generateDocumentBruteForce(characters, document));
//        System.out.println(generateDocumentOptimal(characters, document));
//
//        System.out.println("canGenerate3_stream(characters,document) = " + canGenerate3_stream(characters, document));
//        System.out.println("canGenerate4(characters, document) = " + canGenerate4(characters, document));
//        System.out.println("canGenerate5(characters, document) = " + canGenerate5(characters, document));
        System.out.println("generateDocument2(characters, document) = " + generateDocument2(characters, document));
    }

    public  static AtomicBoolean checkDocument(String given, String doc) {

        AtomicBoolean result = new AtomicBoolean(false);
        doc.chars().forEach(value -> {
            if ((given.chars().filter(ch -> ch == value).count())>=(doc.chars().filter(ch -> ch == value).count()))
                result.set(true);
            else result.set(false);
        });
        return result;
    }

    public static Boolean generateDocument2(String characters, String document) {

        int[] charArr = new int[127];
        for (char c : characters.toCharArray()) {
            charArr[c]++;
        }
        for (char c : document.toCharArray()) {
            if (charArr[c] < 1) {
                return false;
            }
            charArr[c]--;
        }
        return true;
    }



    // O(n + m) time | O(c) space - where n is the number of characters, m is
    // the length of the document, and c is the number of unique characters in the
    // characters string
    // best solution for me
    public static boolean generateDocs(String chars, String doc){
        if (doc.equals("")) return true;
        if (chars.length()<doc.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for (Character ch : chars.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) +1);
        }

        for (Character ch : doc.toCharArray()){
            if (!map.containsKey(ch) || map.get(ch) == 0) return false;
            map.put(ch, map.get(ch) - 1);
        }
        return true;
    }

    static boolean compareDocument(String characters, String document){

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : characters.toCharArray()){
            map.putIfAbsent(ch, 0);
            map.computeIfPresent(ch, (k , v) -> v + 1);
        }

        for (char ch : document.toCharArray()){
            if (!map.containsKey(ch) || map.computeIfPresent(ch, (k,v) -> v - 1) < 0) return false;
        }
        return true;
    }


    // my first solution
    public static boolean genDocs(String chars, String doc){
        Map<Character, Integer> input = convertToMap(chars);
        Map<Character, Integer> output = convertToMap(doc);

        for (Map.Entry<Character, Integer> map : output.entrySet()){
            if (!input.containsKey(map.getKey()) || input.get(map.getKey())<map.getValue()) return false;
        }

//        System.out.println("input.toString() = " + convertToMap(chars));
//        System.out.println("doc.toString() = " + convertToMap(doc));

        return true;
    }
    public static Map<Character , Integer> convertToMap(String str){
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : str.toCharArray()){
           // map.putIfAbsent(ch, 1);
           // if (map.containsKey(ch)) map.put(ch, map.get(ch) + 1);
            map.put(ch, map.getOrDefault(ch, 0) +1);
        }
        return map;
    }

    // **************************

// Fatih
    // O(n + m) time | O(c) space - where n is the number of characters, m is
    // the length of the document, and c is the number of unique characters in the
    // characters string
    public static boolean generateDocumentOptimal(String characters, String document) {
        Map<Character, Integer> characterCounts = new HashMap<Character, Integer>();
        for (int idx = 0; idx < characters.length(); idx++) {
            char character = characters.charAt(idx);
            characterCounts.put(character, characterCounts.getOrDefault(character, 0) + 1);
        }
        for (int idx = 0; idx < document.length(); idx++) {
            char character = document.charAt(idx);
            if (!characterCounts.containsKey(character) || characterCounts.get(character) ==0) {
                return false;
            }
            characterCounts.put(character, characterCounts.get(character) - 1);
        }
        return true;
    }

    public static boolean generateDocumentBruteForce(String ch, String doc) {
        for (int idx = 0; idx < doc.length(); idx++) {
            char character = doc.charAt(idx);
            int documentFrequency = countCharacterFrequency(character, doc);
            int charactersFrequency = countCharacterFrequency(character, ch);
            if (documentFrequency > charactersFrequency) {
                return false;
            }
        }
        return true;
    }
    public static int countCharacterFrequency(char character, String target) {
        int frequency = 0;
        for (int idx = 0; idx < target.length(); idx++) {
            char c = target.charAt(idx);
            if (c == character) {
                frequency += 1;
            }
        }
        return frequency;
    }


    // O(c * (n + m)) time | O(c) space - where n is the number of characters,
    // the length of the document, and c is the number of unique characters in
    // document
    public static boolean generateDocumentSolution2(String characters, String document) {
        Set<Character> alreadyCounted = new HashSet<Character>();
        for (int idx = 0; idx < document.length(); idx++) {
            char character = document.charAt(idx);
            if (alreadyCounted.contains(character)) {
                continue;
            }
            int documentFrequency = countCharacterFrequency(character, document);
            int charactersFrequency = countCharacterFrequency(character, characters);
            if (documentFrequency > charactersFrequency) {
                return false;
            }
            alreadyCounted.add(character);
        }
        return true;
    }

    public static boolean canGenerate3_stream(String characters, String document){

        if(document.equals("")) return true;
        if(characters.length()<document.length()) return false;

        String [] charArr = characters.split("");
        String [] docArr = document.split("");

        List<String> distinct = Arrays.stream(docArr).distinct().collect(Collectors.toList());

        for(String each:distinct){
            long charCount = Arrays.stream(charArr).filter(x->x.equals(each)).count();
            long docCount = Arrays.stream(docArr).filter(x->x.equals(each)).count();
            if(charCount<docCount) return false;
        }
        return true;
    }

    public static boolean canGenerate4(String characters, String document){

        if(document.equals("")) return true;
        if(characters.length()<document.length()) return false;

        int i=0,j=0;
        char[] charArr=characters.toCharArray();
        char[] docArr=document.toCharArray();
        Arrays.sort(charArr);
        Arrays.sort(docArr);

        while(i<charArr.length && j< docArr.length){
            if(charArr[i++] == docArr[j]) j++;
        }
        return j == docArr.length;
    }

    //-------------------------------------

    public static boolean canGenerate(String characters, String document){
        if(document.equals("")) return true;
        if(characters.length()<document.length()) return false;

        int charLength, docLength;

        while(document.length()>0){
            charLength=characters.length();
            docLength=document.length();

            characters = characters.replace(document.charAt(0)+"","");
            document = document.replace(document.charAt(0)+"","");

            if(charLength-characters.length()<docLength-document.length()) return false;
        }
        return true;
    }

    public static boolean canGenerate2(String characters, String document){
        if(document.equals("")) return true;
        if(characters.length()<document.length()) return false;

        Map<Character,Integer> indices = new HashMap<>();

        for(char each:document.toCharArray()){
            indices.putIfAbsent(each,0);
            if(indices.get(each)>=characters.length()) return false;
            // abcabdcaanb -> characters
            //abacbc -> document

            for(int i = indices.get(each);i<characters.length();i++){
                if(characters.charAt(i) == each){
                    indices.put(each,i+1);
                    break;
                }
            }
            return false;
        }
        return true;
    }

    public static boolean canGenerate5(String characters, String document) {

        if (document.equals("")) return true;
        if (characters.length() < document.length()) return false;

        Map<String,Integer> charMap = new HashMap<>();
        Map<String,Integer> docMap = new HashMap<>();


        Arrays.stream(characters.split("")).forEach(x -> {
            charMap.putIfAbsent(x, 0);
            charMap.put(x, charMap.get(x) + 1);
        });
        Arrays.stream(document.split("")).forEach(x -> {
            docMap.putIfAbsent(x, 0);
            docMap.put(x, docMap.get(x) + 1);
        });

        for (String each: docMap.keySet()){
            if(!charMap.containsKey(each) || charMap.get(each)< docMap.get(each)) return false;
        }
        return true;
    }

}
