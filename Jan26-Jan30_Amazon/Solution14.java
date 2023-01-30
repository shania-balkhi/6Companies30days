/*Q14. Last Moment Before All Ants Fall Out of a Plank*/
/* https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/ */

class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int max_time = 0;
        
        for(int i: left)
            max_time = Math.max(max_time, i);
        
        for(int i: right)
            max_time = Math.max(max_time, n-i);
        
        return max_time;
    }
}
