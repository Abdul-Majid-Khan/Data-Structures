class Solution {
    TreeMap<Integer,Integer> left=new TreeMap<>();
    TreeMap<Integer,Integer> right=new TreeMap<>();
    int lc=0,rc=0;
    long sl=0,sr=0;

    private void add(int n){
        if(rc==0 || n>right.firstKey()){
            right.put(n,right.getOrDefault(n,0)+1);
            rc++;
            sr+=n;
        }
        else{
            left.put(n,left.getOrDefault(n,0)+1);
            lc++;
            sl+=n;
        }
        balance();
    }

    private void balance(){
        if(lc > rc){
            int k=left.lastKey();
            right.put(k,right.getOrDefault(k,0)+1);
            lc--;
            sl-=k;
            sr+=k;
            rc++;
            if(left.get(k)==1){
                left.remove(k);
            }
            else{
                left.put(k,left.get(k)-1);
            }
        }
        else if(rc>lc+1){
            int k=right.firstKey();
            left.put(k,left.getOrDefault(k,0)+1);
            rc--;
            sr-=k;
            sl+=k;
            lc++;
            if(right.get(k)==1){
                right.remove(k);
            }
            else{
                right.put(k,right.get(k)-1);
            }
        }
    }

     private void del(int n){
        if(right.containsKey(n)){
            int k=right.get(n);
            rc--;
            sr-=n;
            if(k==1){
                right.remove(n);
            }
            else{
                right.put(n,right.get(n)-1);
            }
        }
        else{
            int k=left.get(n);
            lc--;
            sl-=n;
            if(k==1){
                left.remove(n);
            }
            else{
                left.put(n,left.get(n)-1);
            }
        }
        balance();
     }

     private int med(){
            int ans=0;
            if(lc==rc)
            ans=left.lastKey();
            else 
            ans=right.firstKey();
    
        return ans;
     }

     private long cost(){
        int m=med();
        long ans=m*lc-sl+sr-m*rc;
        return ans;
     }


    public long minOperations(int[] nums, int x, int k) {
        int n=nums.length;
        long []c=new long[n-x+1];
        for(int i=0;i<x;i++){
            add(nums[i]);
        }
        c[0]=cost();
        for(int i=x;i<n;i++){
            del(nums[i-x]);
            add(nums[i]);
            c[i-x+1]=cost();
        }
        long [][]dp=new long[n+1][k+1];
        long inf=Long.MAX_VALUE/2;
        for(long []i:dp){
            Arrays.fill(i,inf);
        }
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                dp[i][j]=dp[i-1][j];
                if(i>=x && dp[i-x][j-1]!=inf){
                    dp[i][j]=Math.min(dp[i][j],dp[i-x][j-1]+c[i-x]);
                }
            }
        }
          return dp[n][k];
        
    }
}