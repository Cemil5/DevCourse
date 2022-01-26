package DataStructure.Canvas_Q_A;

import java.util.HashSet;
import java.util.Set;

public class Array_FirstDuplicate {
    public static void main(String[] args) {
// return the one whose first duplicate value has the minimum index.
        System.out.println(firstDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(firstDuplicate(new int[]{3,1,3,1,4,2}));
        System.out.println(firstDuplicate(new int[]{1,1}));
        System.out.println(firstDuplicate(new int[]{1,3,2}));
    }

    public static int firstDuplicate(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int j : arr) {
            if (!set.contains(j)) {
                set.add(j);
            } else return j;
        }
        return -1;
    }
}
