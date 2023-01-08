/*Q8. Maximum Points in Archery Competition*/
/* https://leetcode.com/problems/maximum-points-in-an-archery-competition/ */

class Solution {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[][] dp = new int[13][numArrows+1];
        
        for(int i=0; i<=12; i++){
            for(int j=0; j<=numArrows; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                } else if(j>=(aliceArrows[i-1]+1)){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-(aliceArrows[i-1]+1)]+(i-1));
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        int[] ans = new int[12];
        int result = dp[12][numArrows];
        int total = 0; // to count total arrows used by bob
        for (int i=12, j=numArrows; i > 0 && result > 0; i--) {
            if (result == dp[i-1][j])
                continue;
            else {
                // This item is included.
                ans[i-1] = aliceArrows[i-1]+1;
                result -=  (i-1);  // subtracting profit
                j -= (aliceArrows[i-1]+1); // subtracting weight
                total += aliceArrows[i-1]+1; 
            }
        }
        
		// as bob has to fire numArrows, remaining can be of 0 value
        if(total<numArrows){
            ans[0] = numArrows-total;
        }
        return ans;
    }
}
