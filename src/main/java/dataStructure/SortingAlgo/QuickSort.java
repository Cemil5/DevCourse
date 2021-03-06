package dataStructure.SortingAlgo;

import java.util.Arrays;

public class QuickSort {
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int start, int end) {
        if (start >= end) // termination
            return;

        var boundary = partition(array, start, end);

        sort(array, start, boundary - 1);
        sort(array, boundary + 1, end);
    }
    private int partition(int[] myArr, int start, int end) {
        var pivot = myArr[end];
        var boundary = start;
        for (int i = start; i <= end; i++) {
            if (myArr[i] <= pivot)
                swap(myArr, i, boundary++);
        }
        return boundary-1;
    }

    private void swap(int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    //private int partition(int[] array, int start, int end) {
    //  var pivot = array[end];
    //  var boundary = start - 1;
    //  for (var i = start; i <= end; i++)
    //    if (array[i] <= pivot)

        //        swap(array, i, ++boundary);
    //return boundary;

 //   }

    public static void main(String[] args) {
        var myarray=new int[]{8, 2, 4, 1, 3,0,-1};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(myarray);
        System.out.println(Arrays.toString(myarray));
    }
}
