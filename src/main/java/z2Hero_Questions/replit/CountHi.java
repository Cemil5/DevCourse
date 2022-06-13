package z2Hero_Questions.replit;

public class CountHi {
    public static void main(String[] args) {
        String str = "hihiih";

        int counter = 0;

        while(str.contains("hi")){
            str = str.replaceFirst("hi", "");
            counter++;
        }
            System.out.println(counter);

        String word = "abc";

        for (int i =word.length()-1; i >=0 ; i--) {
            System.out.print(word.charAt(i) + word.charAt(0));
        }

    }
}
