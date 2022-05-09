package dataStructure.SearchingAlgo;

public class ExponentialSearch {
    public static int exponentialSearch(int[] array, int data) {
        int bound = 1;
        while (bound < array.length && array[bound] < data) bound *= 2;
        int left = bound / 2;
        int right = Math.min(bound, array.length - 1);
        return BinarySearch.binarySearchRec(array, data, left, right);

    }

    public static void main(String[] args) {
        int[] myarray = new int[]{1, 2, 3, 4, 5, 6, 89, 100, 110, 111, 112};
        System.out.println(exponentialSearch(myarray, 112));

    }
}
