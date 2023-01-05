/*Q14. Deletions to make an array divisible.*/
/* https://leetcode.com/problems/minimum-deletions-to-make-array-divisible/ */

class Solution {
    public static int gcd(int a,int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
    public int minOperations(int[] nums, int[] numsDivide) {
        int g=numsDivide[0];
		Arrays.sort(numsDivide);
		for(int i=0;i<numsDivide.length-1;i++) {
			if(numsDivide[i]==numsDivide[i+1]) continue;
			else g=gcd(g,numsDivide[i]);
		}
		g=gcd(g,numsDivide[numsDivide.length-1]);
		int count=0;
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++) {
			if(g%nums[i]==0) return count;
			else count++;
		}
		return -1;
    }
}
