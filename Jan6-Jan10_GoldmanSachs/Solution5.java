/*Q5. Split Array into Sequences*/
/* https://leetcode.com/problems/split-array-into-consecutive-subsequences/ */

// TC : O(n)
// SC : O(n)
class Solution {
	public boolean isPossible(int[] nums) {
		HashMap<Integer,Integer> avaibilityMap = new HashMap<>();
		HashMap<Integer,Integer> vacancyMap = new HashMap<>();

        //add frequency of all nums in availabilityMap
		for(int i : nums) {
			avaibilityMap.put(i, avaibilityMap.getOrDefault(i,0)+1);
		}

		for(int i=0;i<nums.length;i++){
            //if availability is zero or less, then continue
			if(avaibilityMap.get(nums[i])<=0){
				continue;
			}

            //make currrent num part of an existing group that is looking for it
			else if(vacancyMap.getOrDefault(nums[i],0)>0){

                //reduce frequency of current num from availabilityMap
				avaibilityMap.put(nums[i], avaibilityMap.getOrDefault(nums[i],0)-1);

                //reduce frquency of current num from vacancymap
				vacancyMap.put(nums[i], vacancyMap.getOrDefault(nums[i],0)-1);

                //create new vacancy for 'nums[i]+1th' item in vacancyMap
				vacancyMap.put(nums[i]+1, vacancyMap.getOrDefault(nums[i]+1,0)+1);
			}

            //make new group in case where an existing group wasn't looking for the current number
			else if(avaibilityMap.getOrDefault(nums[i],0)>0 && avaibilityMap.getOrDefault(nums[i]+1,0)>0 && avaibilityMap.getOrDefault(nums[i]+2,0)>0){

                //reduce the frequencies of these three nums
				avaibilityMap.put(nums[i], avaibilityMap.getOrDefault(nums[i],0)-1);
				avaibilityMap.put(nums[i]+1, avaibilityMap.getOrDefault(nums[i]+1,0)-1);
				avaibilityMap.put(nums[i]+2, avaibilityMap.getOrDefault(nums[i]+2,0)-1);

                //create vacancy for 'nums[i]+3th' element in the vacancyMap
				vacancyMap.put(nums[i]+3, vacancyMap.getOrDefault(nums[i]+3,0)+1);
			}

			else{
				return false;
			}
		}

		return true;
	}
}
