/*Q8. Destroying Asteroids*/
/* https://leetcode.com/problems/destroying-asteroids/ */

class Solution {
   public  boolean asteroidsDestroyed(int mass, int[] arr) {
		Arrays.sort(arr);
        long sum = mass;
		for (int i = 0; i < arr.length; i++) {
			if (sum >=arr[i]) {
				sum += arr[i];
			} else {
				return false;
			}
		}
		return true;
	}
}
