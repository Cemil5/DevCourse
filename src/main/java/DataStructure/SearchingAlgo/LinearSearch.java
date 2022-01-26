package DataStructure.SearchingAlgo;

public class LinearSearch {

    public static int linearSearch(int[] array, int data){
        for (int i = 0; i < array.length; i++)
            if (array[i] == data)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        int[] myarray = new int[]{1, 2, 3, 4, 5, 6, 89, 100, 110, 111, 112};
        System.out.println(linearSearch(myarray, 112));

    }


}
