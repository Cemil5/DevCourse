package DataStructure.SortingAlgo;

import java.util.Arrays;

public class SortingMainApp {
    public static void main(String[] args) {
        var myarray=new int[]{8, 2, 4, 1, 3,0,-1};
        BubbleSort.bubbleSort(myarray);
        System.out.println(Arrays.toString(myarray));

        var quickSort= new QuickSort();
        quickSort.sort(myarray);
        System.out.println(Arrays.toString(myarray));
        //var myMergeSort=new MyMergeSort();
        // myMergeSort.mergeSort(myarray);
        //System.out.println(Arrays.toString(myarray));

    }

}
