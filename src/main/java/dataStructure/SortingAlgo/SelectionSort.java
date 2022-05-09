package dataStructure.SortingAlgo;

import java.util.Arrays;

public class SelectionSort {
    public static int[] selectionSort(int[] array){
        for(int i=0;i<array.length;i++) {
            int minIndex=i;
            for(int j=i+1;j<array.length;j++)
                if(array[j]<array[minIndex]) minIndex=j;
            swap(array,minIndex,i);
        }
        return array;
    }
    private static void swap(int[] array, int index1, int index2) {
        int temp=array[index1];
        array[index1]=array[index2];
        array[index2]=temp;
    }

    public static void main(String[] args) {
        var myarray=new int[]{8, 2, 4, 1, 3,0,-1};
        System.out.println(Arrays.toString(selectionSort(myarray)));
    }
}