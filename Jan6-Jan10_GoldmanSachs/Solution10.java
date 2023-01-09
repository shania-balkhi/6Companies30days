/*Q10. People and Secret*/
/* https://leetcode.com/problems/number-of-people-aware-of-a-secret/ */

class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long dp[] = new long[n+1];
        dp[1] = 1;
        long people = 0;
        long mod = (long)1e9+7;
        long ans = 0;
        
        for(int day=1;day<=n;day++){
            if(day>1){
                dp[day] = (people+dp[Math.max(day-delay,0)]-dp[Math.max(day-forget,0)])%mod;
                people = dp[day];
            }
            
            if(day>=n-forget+1){
                ans = (ans + dp[day])%mod;
            }
        }
        
        int finalAns = (int)ans;
        if(finalAns<0) finalAns+=(int)mod;
        return finalAns;
    }
}
