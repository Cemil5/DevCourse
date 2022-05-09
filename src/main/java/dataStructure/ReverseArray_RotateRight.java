package dataStructure;

public class ReverseArray_RotateRight {

    public static void main(String[] args) throws Exception {

        int n = 5;
        int [][] matrix = new int[n][n];
        int matValue=1;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                matrix[i][j] = matValue;
                matValue++;
            }
        }
        printMatrix(rotateRight(matrix));

        /*
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {6,7,8,9,10};
        int[] arr3 = {11,12,13,14,15};
        int[] arr4 = {16,17,18,19,20};
        int[] arr5 = {21,22,23,24,25};

        int[][] a2 = {arr1,arr2,arr3,arr4,arr5};

        for (int i=0; i<a2.length;i++){
            System.out.println(Arrays.toString(a2[i]));
        }

        int[][] result = rotateRight(a2);
        for (int i=0; i<result.length;i++){
            System.out.println(Arrays.toString(result[i]));
        }
        */
    }

    // Rotate an (n x n) matrix 90 degrees right in place.
    public static int[][] rotateRight(int[][] matrix) throws Exception {

        if (matrix.length == 0){
            throw new Exception("length matrix is 0");
        } else {
            for (int i = 0; i<matrix.length;i++){
                if (matrix[0].length != matrix.length){
                    throw new Exception("matrix is not n x n");
                }
            }
        }

        int n = matrix.length;
        System.out.println("Initial matrix : ");
        printMatrix(matrix);
        System.out.println();

        for (int layer = 0; layer < n/2; layer++){
            int first = layer;
            int last = n-1 - layer;

            for (int i = first; i<last; i++){
                int offset = i - first;
                int temp = matrix[first][i]; // top to temp
                matrix[first][i] = matrix[last - offset][first];  // left to top
                matrix[last - offset][first] = matrix[last][last - offset]; // right bottom to left
                matrix[last][last - offset] = matrix[i][last];    // right top to bottom
                matrix[i][last] = temp;
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix){
        for (int[] ints : matrix) {
            for (int i : ints) {
                System.out.printf("%-1s%02d", "", i);
            }
            System.out.println();
        }
    }

    // Rotate an (n x n) matrix 90 degrees right in place.
    public static int[][] myRotateRight(int[][] a){

        int l = a.length-1;
        for (int k=0; k<a.length/2; k++) {
            for (int i = k; i < l-k; i++) {
                int temp = a[k][i];
                a[k][i] = a[l-i-k][k];
                a[l-i-k][k] = a[l-k][l-i-k];
                a[l-k][l-i-k] = a[i][l-k];
                a[i][l-k] = temp;
            }
        }
/*

     for (int i = 0; i < l; i++) {
                t = a[0][i];
                a[0][i] = a[l - i][0];
                a[l - i][0] = a[l][l - i];
                a[l][l - i] = a[i][l];
                a[i][l] = t;





        t= a[0][0];
        a[0][0] = a[l][0];
        a[l][0] = a[l][l];
        a[l][l] = a[0][l];
        a[0][l] = t;

*/

        /*
     //   for (int i=0; i<a.length-1;i++){
            t= a[0][0];
            a[0][0] = a[1][0];
            a[1][0] = a[1][1];
            a[1][1] = a[0][1];
            a[0][1]=t;
     //   }
        */

        return a;
    }



    // Reverse order of an array of unordered integers.
    public static int[] reverseOrder(int[] arr){
       int[] result = new int[arr.length];
       for (int i=arr.length-1, j=0; i>=0; i--, j++){
           result[j] = arr[i];
       }
       return result;
    }




}
