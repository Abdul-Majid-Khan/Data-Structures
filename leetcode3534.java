class Solution {
    private int upBound(int [][]arr,int target){
        int n=arr.length,i=0,j=n-1,ans=0;
        while(i<=j){
            int m=i+(j-i)/2;
            if(arr[m][1]<=target){
                ans=m;
                i=m+1;
            }
            else{
                j=m-1;
            }
        }
        return ans;

    }

    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int r=n,c=32-Integer.numberOfLeadingZeros(n);
        int [][]up=new int[r][c];
        int [][]arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=i;
            arr[i][1]=nums[i];
        }
        Arrays.sort(arr,(a,b)->Integer.compare(a[1],b[1]));
        int []map=new int [n];
        for(int i=0;i<n;i++){
            int node=arr[i][0];
            map[node]=i;
        }
         for(int i=0;i<n;i++){
            int idx=map[i];
            int farthest=upBound(arr,arr[i][1]+maxDiff);
            up[i][0]=farthest;
         }
         for(int j=1;j<c;j++){
            for(int i=0;i<r;i++){
                up[i][j]=up[up[i][j-1]][j-1];
            }
         }

        int []ans=new int[queries.length];
        int k=0;
        for(int []q:queries){
            int u=map[q[0]];
            int v=map[q[1]];
            if(u==v){
                ans[k++]=0;
                continue;
            }
            if(u>v){
                int t=u;
                u=v;
                v=t;
            }
            int st=0;
            for(int j=c-1;j>=0;j--){
                if(up[u][j]<v){
                    u=up[u][j];
                    st+=(1<<j);
                }
            }
            if(up[u][0]>=v){
                ans[k++]=st+1;
            }
            else{
                ans[k++]=-1;
            }
        }

        return ans;

        
    }
}