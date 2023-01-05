/*Q15. Substrings containing all three Characters*/
/* https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/submissions/872116180/ */

class Solution
{
    public static boolean ischeck(int b[])
    {
        for(int i=0;i<3;i++)
        {
            if(b[i]==0)
            {
                return false;
            }
        }
        return true;
    }
     public static boolean ischeck1(int b[])
    {
        for(int i=0;i<3;i++)
        {
            if(b[i]==0)
            {
                return true;
            }
        }
        return false;
    }
    public int numberOfSubstrings(String s)
    {
        ArrayList<Integer> back=new ArrayList<Integer>();
        ArrayList<Integer> front=new ArrayList<Integer>();
        int b[]=new int[3];
        int c=0;
        int start=0;int end=0;int n=s.length();
        char ch[]=s.toCharArray();
         for(int i=0;i<n;i++)
         {
             b[(int)(ch[i]-'a')]++;
             if(ischeck(b)==true)
             {
                   back.add(n-1-i);int count=0;
                   while(ischeck1(b)==false)
                   {
                       count++;
                       b[(int)(ch[start++]-'a')]--;
                   }
                 front.add(count);
             }
         }
        System.out.println(front+" "+back);
        
       int sum=0;
        for(int i=0;i<front.size();i++)
        {
            sum=sum+(front.get(i)*back.get(i))+front.get(i);
        }
        return sum;
    }
}
