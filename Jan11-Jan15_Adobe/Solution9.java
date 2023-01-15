/*2265. Count Nodes Equal to Average of Subtree*/
/* https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/ */

class Solution {
    
    public class NodeInfo{
        int sum;
        int size;
        public NodeInfo(int sum , int size){
            this.sum = sum;
            this.size = size;
        }
    }
    
    int ans = 0;
    
    public int averageOfSubtree(TreeNode root) 
    {
        dfs(root);
        return ans;
    }
    
    public NodeInfo dfs(TreeNode node){
        if(node == null)
            return new NodeInfo(0,0);
        
        NodeInfo left = dfs(node.left);
        NodeInfo right = dfs(node.right);
        
        int currentSum = node.val + left.sum + right.sum;
        int currentSize = 1 + left.size + right.size;
        
        if(currentSum / currentSize == node.val)
            ans++;
        
        return new NodeInfo(currentSum , currentSize);
    }
}
