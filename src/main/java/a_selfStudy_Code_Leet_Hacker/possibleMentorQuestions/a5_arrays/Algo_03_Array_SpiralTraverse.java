package a_selfStudy_Code_Leet_Hacker.possibleMentorQuestions.a5_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Question # 3
Description: Spiral Traverse
Difficulty: Medium Category: Array
Write a function that takes in an n x m two-dimensional array (that can be square-shaped
when n == m) and returns a one-dimensional array of all the array's elements in spiral order.
Spiral order starts in the top left corner of the two-dimensional array, goes to the right, and
proceeds in a spiral pattern all the way until every element has been visited. Both iterative and
recursive solutions are welcome.
Sample Input
array = [   [ 1,  2,  3, 4],
            [12, 13, 14, 5],
            [11, 16, 15, 6],
            [10,  9,  8, 7],]
Sample Output
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,13,14,15,16]
 */
public class Algo_03_Array_SpiralTraverse {
    public static void main(String[] args) {
        int [][] array = {  { 1,  2,  3, 4},
                            {12, 13, 14, 5},
                            {11, 16, 15, 6},
                            {10,  9,  8, 7}
        };
        int [][] array2 = { { 1, 2, 3, 4, 5},
                            {14,15,16,17, 6},
                            {13,20,19,18, 7},
                            {12,11,10, 9, 8}
        };
        int [][] array3 = { { 1, 2, 3, 4, 5, 6},
                            {16,17,18,19,20, 7},
                            {15,24,23,22,21, 8},
                            {14,13,12,11,10, 9}
        };
        int [][] array4 = { { 1, 2, 3, 4, 5, 6, 7},
                            {16,17,18,19,20,21, 8},
                            {15,14,13,12,11,10, 9}
        };
        int [][] array5 = { { 1, 2, 3, 4, 5, 6, 7, 8, 9},
                            {18,17,16,15,14,13,12,11,10}
        };
        System.out.println(Arrays.toString(spiralTravers(array5)));
        System.out.println("spiralTraverseIterative(array2) = " + spiralTraverseIterative(array5));
    }

    // my solution
    public static int[] spiralTravers(int[][] array){
        int[] result = new int[array.length * array[0].length];
        int rx = 0;     // used for result index
        int upperRow = 0, rightColumn = 0, belowRow = 0, leftColumn = 0;    // visited rows / columns

        while (rx < result.length) {
            // processing upper row
            for (int i = leftColumn; i <= array[0].length-1-rightColumn; i++) {
                result[rx++] = array[upperRow][i];
            }
            if(rx == result.length) return result;
            upperRow++;
            System.out.println(Arrays.toString(result));

            // processing right column
            for (int j = upperRow; j < array.length - belowRow; j++) {
                result[rx++] = array[j][array[0].length - 1 - rightColumn];
            }
            if(rx == result.length) return result;
            rightColumn++;
            System.out.println(Arrays.toString(result));

            // processing below row
            for (int i = array[0].length - 1 - rightColumn; i >= leftColumn; i--) {
                result[rx++] = array[array.length - 1 - belowRow][i];
            }
            if(rx == result.length) return result;
            belowRow++;
            System.out.println(Arrays.toString(result));

            // processing left column
            for (int j = array.length - 1 - belowRow; j >= upperRow; j--) {
                result[rx++] = array[j][leftColumn];
            }
            leftColumn++;
            System.out.println(Arrays.toString(result));
        }
        return result;
    }


    public static List<Integer> spiralTraverseIterative(int[][] array) {    // best solution for me
        if (array.length == 0) return new ArrayList<Integer>();
        var result = new ArrayList<Integer>();
        var startRow = 0;
        var endRow = array.length - 1;
        var startCol = 0;
        var endCol = array[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            for (int col = startCol; col <= endCol; col++) {
                result.add(array[startRow][col]);
            }
            for (int row = startRow + 1; row <= endRow; row++) {
                result.add(array[row][endCol]);
            }
            for (int col = endCol - 1; col >= startCol; col--) {
                if (startRow == endRow) break;
                result.add(array[endRow][col]);
            }
            for (int row = endRow - 1; row > startRow; row--) {
                if (startCol == endCol) break;
                result.add(array[row][startCol]);
            }
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return result;
    }

    // O(n) time | O(n) space - where n is the total number of elements in the array
    public static List<Integer> spiralTraverse(int[][] array) {
        if (array.length == 0) return new ArrayList<Integer>();
        var result = new ArrayList<Integer>();
        spiralFill(array, 0, array.length - 1, 0, array[0].length - 1, result);
        return result;
    }
    public static void spiralFill(
            int[][] array,
            int startRow,
            int endRow,
            int startCol,
            int endCol,
            ArrayList<Integer> result) {
        if (startRow > endRow || startCol > endCol) {
            return; // termination
        }
        for (int col = startCol; col <= endCol; col++) {
            result.add(array[startRow][col]);
        }
        for (int row = startRow + 1; row <= endRow; row++) {
            result.add(array[row][endCol]);
        }
        for (int col = endCol - 1; col >= startCol; col--) {
            if (startRow == endRow) break;
            result.add(array[endRow][col]);
        }
        for (int row = endRow - 1; row >= startRow + 1; row--) {
            if (startCol == endCol) break;
            result.add(array[row][startCol]);
        }
        //calling method recursively again
        spiralFill(array, startRow + 1, endRow - 1, startCol + 1, endCol - 1, result);
    }

    public static int[] transform(int[][] arr){     // ???
        int lastRow = arr.length-1;
        int lastCol = arr[0].length-1;
        int j=0,i=0,offset=0;

        int[] result = new int[ (lastCol+1) * (lastRow+1) ];

        for(int l=0;l< result.length;l++){

            result[l] = arr[i][j];

            if ( i==offset && j<lastCol-offset ) j++;
            else if(j==lastCol-offset && i<lastRow-offset) i++;
            else if(i==lastRow-offset && j>offset) j--;
            else if(j==offset && i>offset) i--;

            if(i==offset && j == offset){
                offset++;
                i++;
                j++;
            }
        }
        return result;
    }



}
