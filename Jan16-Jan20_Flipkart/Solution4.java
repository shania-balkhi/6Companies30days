/*Q4. Find the Winner of the Circular Game*/
/* https://leetcode.com/problems/find-the-winner-of-the-circular-game/ */

class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            q.offer(i);
        }
        while(q.size()!=1){
            for(int i=1;i<k;i++)
                q.offer(q.poll());
            q.poll();
        }
     return q.poll();   
    }
}
