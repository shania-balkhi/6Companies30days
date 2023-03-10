/*Q15. Generate Random Point in a Circle*/
/* https://leetcode.com/problems/generate-random-point-in-a-circle/ */

class Solution {
    double r;
    double x;
    double y;
    public Solution(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
    }
    
    public double[] randPoint() {
        double[] ans = new double[2];
        double x_min = x - r;
        double x_max = x + r;
        double y_min = y - r;
        double y_max = y + r;
        
        ans[0] = x_min + Math.random() * (x_max - x_min);
        ans[1] = y_min + Math.random() * (y_max - y_min);
        
        
        while((ans[0] - x) * (ans[0] - x) + (ans[1] - y) * (ans[1] - y) > r * r){
            ans[0] = x_min + Math.random() * (x_max - x_min);
            ans[1] = y_min + Math.random() * (y_max - y_min);
        }
        return ans;
    }
}
