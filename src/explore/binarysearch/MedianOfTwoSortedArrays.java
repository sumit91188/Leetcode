package explore.binarysearch;

/**
 * @author Sumit Deo
 * @Date 7/3/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1040/
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2};
        int[] nums2 = new int[] {3,4};

        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }

    private static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            /*int nums1Index = 0;
            int nums2Index = 0;

            if ((nums1.length + nums2.length) % 2 == 0) {
                double currentNum = 0.00;
                double prevNum = 0.00;
                while ((nums1Index + nums2Index) <= (nums1.length + nums2.length) / 2) {
                    prevNum = currentNum;
                    if (nums1Index < nums1.length && nums1[nums1Index] <= nums2[nums2Index]) {
                        currentNum = nums1[nums1Index++];
                    }
                    else if (nums2Index < nums2.length){
                        currentNum = nums2[nums2Index++];
                    }
                }
                return (prevNum + currentNum) / 2;
            }
            else {
                double currentNum = 0.00;
                while ((nums1Index + nums2Index) <= (nums1.length + nums2.length) / 2) {
                    if (nums1Index < nums1.length && nums1[nums1Index] <= nums2[nums2Index]) {
                        currentNum = nums1[nums1Index++];
                    }
                    else if (nums2Index < nums2.length){
                        currentNum = nums2[nums2Index++];
                    }
                }
                return currentNum;
            }*/

            int[] unionArray = new int[nums1.length + nums2.length];
            int num1Index = 0;
            int num2Index = 0;
            int index = 0;

            while (num1Index < nums1.length && num2Index < nums2.length) {
                if (nums1[num1Index] <= nums2[num2Index]) {
                    unionArray[index++] = nums1[num1Index++];
                }
                else {
                    unionArray[index++] = nums2[num2Index++];
                }
            }

            if (num1Index < nums1.length) {
                while (num1Index < nums1.length) {
                    unionArray[index++] = nums1[num1Index++];
                }
            }

            if (num2Index < nums2.length) {
                while (num2Index < nums2.length) {
                    unionArray[index++] = nums2[num2Index++];
                }
            }

            if (index % 2 == 0) {
                return ((double) (unionArray[(index / 2) - 1] + unionArray[index / 2]) / 2);
            }
            else {
                return unionArray[index/2];
            }
        }
    }
}
