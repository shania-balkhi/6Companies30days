/*2343. Query Kth Smallest Trimmed Number*/
/* https://leetcode.com/problems/query-kth-smallest-trimmed-number/ */

class Solution{
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
    HashMap<Integer, Node[]> map = new HashMap<>();
    int[] res = new int[queries.length];
    int idx = 0, len = nums[0].length();
	
    for(int[] query : queries){
        if(!map.containsKey(query[1])){
            Node[] arr = new Node[nums.length];
            for(int i=0; i<nums.length; i++){
                String x = nums[i].substring(len-query[1], len);
                arr[i] = new Node(i, x);
            }
			Arrays.sort(arr, (a, b)-> a.val.compareTo(b.val));
            map.put(query[1], arr);
        }
        res[idx++] = map.get(query[1])[query[0]-1].index;
    }
	
    return res;
}

class Node{ int index; String val;
    Node(int i, String v){ this.index = i; this.val = v; } }
	
}
