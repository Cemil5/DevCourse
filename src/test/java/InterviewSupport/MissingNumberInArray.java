package InterviewSupport;

import java.util.Arrays;

public class MissingNumberInArray {
    public static void main(String[] args) {
        System.out.println(findMissing(new int[]{1, 3, 5, 9, 11, 13}));

        System.out.println(findDifference("AAABB"));

    }
    public static int findMissing(int[] nums){
        int j=1;
        Arrays.sort(nums);
        for (int num : nums) {
            if (num != j) {
                return j;
            }
            j += 2;
        }
        return -1;
    }

    private static int findDifference(String str){
        int a=0;
        int b=0;
        for (int i=0; i<str.length(); i++){
            if(str.charAt(i) == 'A') a++;
            if(str.charAt(i) == 'B') b++;
        }
        return Math.abs(a-b);
    }

}
