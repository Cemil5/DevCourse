package dataStructure.Canvas_Q_A;

public class Array_Monotonic {
    public static void main(String[] args) {
//An array is monotonic if it is either monotone increasing or monotone decreasing.
        System.out.println("true : " + isMonotonic( new int[]{1, 2, 2, 3}));
        System.out.println("true : " + isMonotonic( new int[]{6,5,4,4}));
        System.out.println("false : " + isMonotonic( new int[]{1,3,2}));
        System.out.println("true : " + isMonotonic( new int[]{1,2,4,5}));
        System.out.println("true : " + isMonotonic( new int[]{1,1,1}));
    }

    public static boolean isMonotonic(int[] arr){
        for (int i=0; i<arr.length -1; i++){
            if (arr[i] <= arr[i+1]){
                if (i == arr.length - 2) return true;
            } else break;
        }
        for (int i=0; i<arr.length -1; i++){
            if (arr[i] >= arr[i+1]){
                if (i == arr.length - 2) return true;
            } else break;
        }
        return false;
    }

    public static boolean isMonotonic2(int[] array) {
        boolean flag1=true;boolean flag2=true;
        for (int i = 0; i < array.length - 1; ++i){
            if (array[i] > array[i+1]) flag1=false;
            if (array[i] < array[i+1]) flag2=false;
        }
        return flag1||flag2;
    }

}
