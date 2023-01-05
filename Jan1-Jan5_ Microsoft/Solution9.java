/*Q9. Number of Pairs satisfying Inequality.*/
/* https://leetcode.com/problems/number-of-pairs-satisfying-inequality/ */

class Solution{
     public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) nums[i] = nums1[i] - nums2[i];
        long[] tmp = Arrays.copyOf(nums, n);
        return sort(nums, tmp, 0, n-1, diff);
    }
    // sort O(NlogN)
    private long sort(long[] nums, long[] tmp, int lo, int hi, int diff) {
        if (lo == hi) return 0L;
        int mid = lo + (hi - lo) / 2;
        long res = 0L;
        res += sort(nums, tmp, lo, mid, diff);
        res += sort(nums, tmp, mid+1, hi, diff);
        res += merge(nums, tmp, lo, mid, hi, diff);
        return res;
    }
    // merge 2*N = O(N)
    private long merge(long[] nums, long[] tmp, int lo, int mid, int hi, int diff) {
        long res = 0L;
        // find the count of pairs x <= y + diff in 2 sorted halves
        for (int i = lo, j = mid+1; i <= mid && j <= hi; i++) {
            while (j <= hi && nums[i] > nums[j] + diff) j++;
            res += hi-j+1;
        }
        // merge 2 sorted halves
        for (int i = lo, j = mid+1, k = lo; i <= mid || j <= hi; k++) {
            if (j > hi || (i <= mid && nums[i] < nums[j])) {
                tmp[k] = nums[i++];
            } else {
                tmp[k] = nums[j++];
            }
        }
        System.arraycopy(tmp, lo, nums, lo, hi-lo+1); // tmp -> nums
        return res;
    }
}
