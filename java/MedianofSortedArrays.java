// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length + nums2.length];
        int temp;
        boolean inc2;
        for (int i = 0, j = 0, k = 0; i < nums3.length; i++){
            temp = -1;
            inc2 = false;
            if (j < nums1.length)
                if (temp > nums1[j] || temp == -1)
                    temp = nums1[j];                                   
                       
            if (k < nums2.length)
                if (temp > nums2[k] || temp == -1){
                    temp = nums2[k];
                    inc2 = true;
                }
                    
            if (inc2)
                k++;
            else
                j++;
            
            nums3[i] = temp; 
        }  
        
        double median = nums3[nums3.length / 2];
    
        if (nums3.length % 2 == 0)
            median -= Math.abs((median - nums3[nums3.length/2 - 1]) / 2);
        return median;
    }
}