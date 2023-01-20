/*Q11. New 21 Game*/
/* https://leetcode.com/problems/new-21-game/ */

class Solution {
    public double new21Game(int N, int K, int W) {
        if (K == 0) return 1.0;
        
        Deque<Double> queue = new LinkedList<>();
        double sum = 0.0;
        for (int i = K; i < K + W; i++) {
            double prob = (i <= N) ? 1.0 : 0.0;
            queue.offerLast(prob);
            sum += prob;
        }
        
        
        for (int i = K - 1; i >= 0; i--) {
            double prob = sum / W;
            sum = sum - queue.pollLast() + prob;
            queue.offerFirst(prob);
        }
        
        return queue.peekFirst();
    }
}
