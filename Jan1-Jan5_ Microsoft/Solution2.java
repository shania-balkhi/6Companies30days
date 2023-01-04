/*Q2. Combination Sum with a twist.*/

import java.util.*;
import java.io.*;

class Solution{
  public List<List<Integer>> combinationSum3(int k, int n) {
      //create resultNestedList
      List<List<Integer>> result = new ArrayList<>();

      //call helper function
      combination(1 /*startNumber*/ , k, n,  new ArrayList<Integer>(), result);

      //return the resultNestedArrayList
      return result;
  }

  private void combination(int start, int k, int n, List<Integer> comb, List<List<Integer>> result) {
	  //base case
      if (comb.size() == k && n == 0) {
		  List<Integer> li = new ArrayList<Integer>(comb);
		  result.add(li);
		  return;
	  }
    
	  for (int i = start; i <= 9; i++) {
		  comb.add(i);
		  combination(i+1, k, n-i, comb, result);
		  comb.remove(comb.size() - 1); //to remove the last number that makes the combination invalid (backtrack)
	  }
  }
  
}
