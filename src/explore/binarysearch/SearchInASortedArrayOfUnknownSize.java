package explore.binarysearch;

/**
 * @author Sumit Deo
 * @Date 6/27/21
 * @Project Leetcode
 * @Comments https://leetcode.com/explore/learn/card/binary-search/136/template-analysis/1061/
 */
public class SearchInASortedArrayOfUnknownSize {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayReader arrayReader = null;
        int target = 10;
        System.out.println(solution.search(arrayReader, target));
    }

    private static class Solution {
        public int search(ArrayReader arrayReader, int target) {
            if (arrayReader.get(0) == target) {
                return 0;
            }

            int left = 0;
            int right = 1;

            while (arrayReader.get(right) <= target) {
                left = right;
                right *= 2;
            }

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (arrayReader.get(mid) < target) {
                    left = mid + 1;
                }
                else if (arrayReader.get(mid) > target) {
                    right = mid - 1;
                }
                else {
                    return mid;
                }
            }
            return -1;
        }
    }
}
