/*Q3. Factorial with Trailing Zeroes*/
/* https://leetcode.com/problems/factorial-trailing-zeroes/ */

class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        int power = 5;
        while(n/power > 0){
            ans = ans + (n/power);
            power = power * 5;
        }
        return ans;
    }
}
