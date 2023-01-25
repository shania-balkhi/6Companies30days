/*Q14. Strictly Palindromic Number*/
/* https://leetcode.com/problems/strictly-palindromic-number/solutions/?orderBy=most_votes */

class Solution {
    public boolean isStrictlyPalindromic(int n) {
 
      for(int i=2;i<=n-2;i++){
          if( !checkPalindrome(Integer.toString(n,i)) )   
          return false;
      }
      return true;
    }
    
    public boolean checkPalindrome(String s){
        
        for(int i=0;i<s.length()/2;i++){
            
            if( !(s.charAt(i) == s.charAt(s.length()-i-1)) )
            return false;
        }
        return true;
    }
}
