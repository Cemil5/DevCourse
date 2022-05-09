package dataStructure.SearchingAlgo;

public class BinarySearch {
    public static int binarySearchRec(int[] array, int data) {
        return binarySearchRec(array, data, 0, array.length - 1);
    }

    public static int binarySearchRec(int[] array, int data, int left, int right) {
        if (right < left) return -1;
        int middle = (left + right) / 2;
        if (array[middle] == data)
            return middle;
        if (data < array[middle])
            return binarySearchRec(array, data, left, middle - 1);
        return binarySearchRec(array, data, middle + 1, right);
    }

    public static int binSearchIterative(int[] array, int data) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == data)
                return middle;
            if (data < array[middle])
                right = middle - 1;
            else left = middle + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] myarray = new int[]{1, 2, 3, 4, 5, 6, 89, 100, 110, 111, 112};
        System.out.println(binarySearchRec(myarray, 112));

        System.out.println(binSearchIterative(myarray, 112));
    }
}
