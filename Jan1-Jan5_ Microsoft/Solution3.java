/*Q3. Bulls and Cows*/

class Solution {
    public String getHint(String secret, String guess) {
        int bulls=0;
        int cows=0;
        int[] s = new int[10];
        int[] g = new int[10];

        for(int i = 0; i < secret.length(); ++i){
            if (secret.charAt(i) == guess.charAt(i)){
                ++bulls;
            }else{
                s[secret.charAt(i)-'0']++;
                g[guess.charAt(i)-'0']++;
            }
        }

        for(int i = 0; i < 10; ++i){
            cows+=Math.min(s[i], g[i]);
        }

        return bulls + "A" + cows + "B";
    }
}
