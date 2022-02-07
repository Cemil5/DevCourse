package InterviewSupport;

import java.util.Arrays;

public class CyclicRotationCode {
    public static void main(String[] args) {
        int [] A = {1,4,5,7,9,4,6};
        System.out.println(Arrays.toString(solution(A, 3)));
    }
    public static int [] solution(int [] A, int K){
        int [] result = new int [A.length];
        for (int i =0 ; i< result.length; i++){
            result [(i +K)% (A.length)] = A[i];
        }
        return result;
    }
}
