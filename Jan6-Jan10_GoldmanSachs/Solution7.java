/*Q7. Count Good Triplets in Array (Profits in a Startup Question)*/
/* https://leetcode.com/problems/count-good-triplets-in-an-array/description/ */

class Solution {
Pair<Integer , Integer>[] temp;
void sort(Pair<Integer ,Integer>[] Arr , int[] arr , int[] brr , int low , int high){
if(low>=high){
return;
}
int mid = (low+high)/2;
sort(Arr , arr , brr , low , mid);
sort(Arr , arr , brr , mid+1 , high);

    int i = low;
    int j = mid+1;
    int k = low;
    while(i<=mid || j<=high){
        int left = (i==mid+1)?Integer.MAX_VALUE:Arr[i].getKey();
        int right = (j==high+1)?Integer.MAX_VALUE:Arr[j].getKey();
        if(left<right){
            temp[k++] = Arr[i];
            arr[Arr[i].getValue()] += (high-j+1);i++;
        }
        else{
            temp[k++] = Arr[j];
            brr[Arr[j].getValue()] += (i-low);j++;
        }
    }
    for(int p = low;p<=high;p++){
        Arr[p] = temp[p];
    }
}
public long goodTriplets(int[] nums1, int[] nums2) {
    HashMap<Integer , Integer> map = new HashMap<>();
    for(int i=0;i<nums1.length;i++){
        map.put(nums1[i] , i);
    }
    for(int i=0;i<nums2.length;i++){
        nums2[i] = map.get(nums2[i]);
    }
    int n = nums1.length;
    temp = new Pair[n];
    int[] arr = new int[n];
    int[] brr = new int[n];
    Pair<Integer , Integer>[] Arr = new Pair[n];
    for(int i= 0;i<n;i++){
        Arr[i] = new Pair(nums2[i] , i);
    }
    sort(Arr , arr , brr , 0 , n-1);        
    long res = 0L;
    for(int i=0;i<n;i++){
        res += (long)((long)arr[i]*(long)brr[i]);
    }
    return res;
}
}
