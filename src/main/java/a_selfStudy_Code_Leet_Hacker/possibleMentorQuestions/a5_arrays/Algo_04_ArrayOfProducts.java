package a_selfStudy_Code_Leet_Hacker.possibleMentorQuestions.a5_arrays;

import java.util.Arrays;

/*  Question # 4
Difficulty: Medium
Write a function that takes in a non-empty array of integers and returns an array of the same
length, where each element in the output array is equal to the product of every other number
in the input array. In other words, the value at output[i] is equal to the product of every
number in the input array other than input[i] . Note : you're expected to solve this problem
without using division.
Sample Input array = [5, 1, 4, 2]
Sample Output [8, 40, 10, 20]
// 8 is equal to 1 x 4 x 2
// 40 is equal to 5 x 4 x 2
// 10 is equal to 5 x 1 x 2
// 20 is equal to 5 x 1 x 4
 */
public class Algo_04_ArrayOfProducts {
    public static void main(String[] args) {
        int[] array1 = {5,1,4,2};
        System.out.println(Arrays.toString(productArray(array1)));
        System.out.println(Arrays.toString(arrayOfProducts(array1)));
    }

    // my solution
    public static int[] productArray(int[] input){
        int[] output = new int[input.length];
        Arrays.fill(output, 1);
        for (int i = 0; i<output.length; i++){
            for (int j = 0; j<input.length; j++){
                if (i!=j) output[i]  *= input[j];
            }
        }
        return output;
    }

    public static int[] arrayOfProducts(int[] array) {      // ???
        int[] products = new int[array.length];
        int leftRunningProduct = 1;
        for (int i = 0; i < array.length; i++) {
            products[i] = leftRunningProduct;
            leftRunningProduct *= array[i];
        }
        int rightRunningProduct = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            products[i] *= rightRunningProduct;
            rightRunningProduct *= array[i];
        }
        return products;
    }
}
