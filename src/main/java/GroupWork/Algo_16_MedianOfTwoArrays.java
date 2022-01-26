package GroupWork;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Algo_16_MedianOfTwoArrays {

    @DataProvider(name = "inputArrays")
    public Object[][] getInputArrays(){
        return new Object[][]{
                {new int[]{1,3},new int[]{2}, 2},
                {new int[]{1,2}, new int[]{3, 4}, 2.5},
                {new int[]{0,0}, new int[]{0,0}, 0},
                {new int[]{}, new int[]{1}, 1},
                {new int[]{2}, new int[]{}, 2},
                {new int[]{1, 7}, new int[]{2, 4}, 3},
                {new int[]{3,6}, new int[]{18, 19, 28, 29, 38, 39, 100}, 28},
                {new int[]{0, 7}, new int[]{1, 18, 19, 28, 29, 38, 39, 100}, (double)(19+28)/(double) 2}
        };
    }

    @Test(dataProvider = "inputArrays")
    public void testAlgo16MySol1(int[] nums1, int[] nums2, double expectedResult){
       // Assert.assertEquals(Algo16_medianOfSortedArrays.getMedianMySol2(nums1, nums2), expectedResult);
    }



    public static double findMedianOfTwoSortedArrays(int[] arr1, int[] arr2) {
        if(arr1.length>arr2.length){
            return findMedianOfTwoSortedArrays(arr2,arr1);
        }
        int low=0;
        int high= arr1.length;
        int lengthArr1=arr1.length;
        int lengthArr2=arr2.length;

        while (low<=high){
            int partArr1=(low+high)/2;
            int partArr2=(lengthArr1+lengthArr2+1)/2- partArr1;
            int maxOfleftArr1;
            int minOfRightArr1;
            int maxOfleftArr2;
            int minOfRightArr2;
            if (partArr1==0)  maxOfleftArr1 = Integer.MIN_VALUE;
            else  maxOfleftArr1=arr1[partArr1-1];

            if (partArr1==arr1.length) minOfRightArr1=Integer.MAX_VALUE;
            else minOfRightArr1=arr1[partArr1];

            if (partArr2==0)  maxOfleftArr2 = Integer.MIN_VALUE;
            else  maxOfleftArr2=arr2[partArr2-1];

            if (partArr2==arr2.length) minOfRightArr2=Integer.MAX_VALUE;
            else minOfRightArr2=arr2[partArr2];

            if (maxOfleftArr1<=minOfRightArr2 && maxOfleftArr2<=minOfRightArr1) {
                if((lengthArr1+lengthArr2) % 2==0){
                    return((double) (Math.max(maxOfleftArr1,maxOfleftArr2)+Math.min(minOfRightArr1,minOfRightArr2))/2);
                } else
                    return ((double) Math.max(maxOfleftArr1,maxOfleftArr2));
            } else if (maxOfleftArr1>minOfRightArr2) {high=partArr1-1;}
            else {
                low=partArr1+1;
            }

        }
        return -1;
    }


}
