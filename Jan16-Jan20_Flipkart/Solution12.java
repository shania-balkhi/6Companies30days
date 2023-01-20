/*Q12. Check If a String Contains All Binary Codes of Size K*/
/* https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/ */

class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(s.length() < k) return false;
        boolean[] strings = new boolean[1 << k];
        int bit = 0;
        for (int i = 0; i < k; i++) {
            bit <<= 1;
            bit ^= (s.charAt(i) - '0');
        }
        strings[bit] = true;
        for (int i = k; i < s.length(); i++) {
            bit = bit << 1;
            bit = bit & ~(1 << k);
            bit ^= (s.charAt(i) - '0');
            strings[bit] = true;
        }
        for (boolean correct : strings) 
            if (!correct)
                return false;
        return true;
    }
}
