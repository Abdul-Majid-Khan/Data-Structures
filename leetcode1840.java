class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int ans=0,m=restrictions.length,pi=1,ph=0;
        if(m==0) return n-1;
        Arrays.sort(restrictions,(a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<m;i++){
            int idx=restrictions[i][0];
            int h=restrictions[i][1];
            int nh=Math.min(h,ph+(idx-pi));
            restrictions[i][1]=nh;
            pi=idx;
            ph=nh;
        }
         pi=n;
         ph=n;
        for(int i=m-1;i>=0;i--){
            int idx=restrictions[i][0];
            int h=restrictions[i][1];
            int nh=Math.min(h,ph+(pi-idx));
            restrictions[i][1]=nh;
            pi=idx;
            ph=nh;
        }
        pi=1;
        ph=0;
        for(int i=0;i<m;i++){
            int ci=restrictions[i][0];
            int ch=restrictions[i][1];
            int max=Math.max(ch,ph);
            int min=Math.min(ch,ph);
            int d=ci-pi;
            int k=max+(d-(max-min))/2;
            ans=Math.max(ans,k);
            pi=ci;
            ph=ch;
        }
        ans=Math.max(ans,ph+n-pi);
        return ans;

        
    }
}