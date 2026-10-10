class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int s=(int)1e5;
        long []arr=new long [s+1];
        for(int i=0;i<nums1.length;i++){
            int d=Math.abs(nums1[i]-nums2[i]);
            arr[d]++;
        }
        long op=k1+k2;
        for(int i=s;i>=1;i--){
            if(arr[i]!=0){
            long k=Math.min(op,arr[i]);
            op-=k;
            arr[i]-=k;
            arr[i-1]+=k;
            }
            if(op==0)
             break;
        }
        long ans=0;
        for(int i=1;i<=s;i++){
            if(arr[i]!=0){
               ans+= 1L*i*i*arr[i];
            }
        }
        return ans;
    }
}