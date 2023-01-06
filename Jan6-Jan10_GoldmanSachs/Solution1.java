/*Q1. Max Points on a Line*/
/* https://leetcode.com/problems/max-points-on-a-line/description/ */

class Solution {
    public int maxPoints(int[][] points) {
        if (points == null) return 0;
        int length = points.length;
        if (length <= 2) return length;
        int result = 0;
        for (int i = 0;i<points.length;i++){
            Map<Double, Integer> map = new HashMap<>();
            int count = 1;
            int same = 0;
            for (int j = 0;j<points.length;j++){
                //pick non matching points
                if(j != i){
                    //first point
                    int firstX = points[i][0];
                    int firstY = points[i][1];
                    
                    //second point
                    int secondX = points[j][0];
                    int secondY = points[j][1];
                    
                    //if both points are same, increment same points
                    if (firstX == secondX && firstY == secondY){ 
                        same++;
                        continue;
                    }
                    //if only x is different increment count
                    if (firstX == secondX) {
                        count++;                    
                        continue;
                    }
                    //for different points put in map the y/x
                    double k = (double)(secondY - firstY) / (double)(secondX - firstX);
                    map.put(k, map.getOrDefault(k, 1)+1);
                    //compute max with map value with number of same points
                    result = Math.max(result, map.get(k) + same);
                }
            }
            //update the result
            result = Math.max(result, count);
        }
        return result;
    }
}
