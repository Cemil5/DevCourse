package DataStructure.SortingAlgo;

import java.util.Arrays;

public class InsertionSort {
    public static int[] insertionSort(int[] array){
        for(int i=1; i<array.length; i++) {
            int current = array[i];
            int j = i-1;
            while(j>=0 && array[j]>current) {
                // shifting operation here
                array[j+1]=array[j];
                j--;
            }
            array[j+1] = current;
        }
        return array;
    }

    public static void main(String[] args) {
        var myarray=new int[]{8, 2, 4, 1, 3,0,-1};
        System.out.println(Arrays.toString(insertionSort(myarray)));
    }
}
