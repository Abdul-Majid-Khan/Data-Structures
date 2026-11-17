class Solution {
    int[][]cDp;
    int[][]sDp;

    private int cost(int i,int j,String s){
        int len=j-i+1;
        int ans=Integer.MAX_VALUE;
        if(cDp[i][j]!=-1) return cDp[i][j];
        for(int d=1;d<len;d++){
            if(len%d != 0) continue;
            int c=0;
            for(int g=0;g<d;g++){
                int l=i+g;
                int r=l+((len/d)-1)*d;
                while(l<r){
                    if(s.charAt(l)!=s.charAt(r)){
                        c++;
                    }
                    l+=d;
                    r-=d;
                }
            }
            ans=Math.min(ans,c);
        }
        return cDp[i][j]=ans;
    }

    private int solve(String s,int st,int k,int n){
        if(k==0){
            if(st==n){
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        if(st+2*k>n){
            return Integer.MAX_VALUE;
        }
        if(sDp[st][k]!=-1){
            return sDp[st][k];
        }
        int ans=Integer.MAX_VALUE;
        for(int end=st+1;end<n;end++){
            int rem=solve(s,end+1,k-1,n);
            if(rem==Integer.MAX_VALUE){
                continue;
            }
            ans=Math.min(ans,rem+cost(st,end,s));
        }
        return sDp[st][k]=ans;
    }

    public int minimumChanges(String s, int k) {
        int n=s.length();
        cDp=new int[n+1][n+1];
        sDp=new int[n+1][k+1];
        for(int []i:cDp){
            Arrays.fill(i,-1);
        }
        for(int []i:sDp){
            Arrays.fill(i,-1);
        }
        return solve(s,0,k,n);
    }
}