class Solution {
    public int minRotations(String s) {
        int n=s.length(),ans=0,p=0;
        for(int i=0;i<n;i++){
            int k=s.charAt(i)-'0';
            int x=Math.abs(k-p);
            ans+=Math.min(x,Math.abs(10-x));
            p=k;
        }
        return ans;
        
    }
}