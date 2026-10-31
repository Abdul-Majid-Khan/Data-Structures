class Solution {
    int [][]up;
    int m=(int)1e9+7;
    List<List<Integer>>adj;
     int []d;
    private void dfs(int c,int p){
        up[c][0]=p;
        for(int ch:adj.get(c)){
            if(ch==p) continue;
            d[ch]=d[c]+1;
            dfs(ch,c);
        }
    }
     
     private void binaryLift(int r,int c){
        for(int j=1;j<c;j++){
            for(int i=0;i<r;i++){
                if(up[i][j-1]!=-1)
                 up[i][j]=up[up[i][j-1]][j-1];
            }
        }
     }

     private int lca(int u,int v,int c){
        if(d[u]<d[v]){
            int t=u;
            u=v;
            v=t;
        }
        int k=d[u]-d[v];
        for(int j=0;j<c;j++){
            if((k &(1<<j))!=0){
                u=up[u][j];
            }
        }
        if(u==v) return u;

        for(int j=c-1;j>=0;j--){

            if(up[u][j]!=up[v][j]){
                u=up[u][j];
                v=up[v][j];
            }
        }
          return up[u][0];
     }

     private void pow(int []sq){
        for(int i=1;i<sq.length;i++){
            sq[i]=(int)((1L*sq[i-1]*2)%m);
        }
     }

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n=edges.length+1;
        adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []ed:edges){
            int u=ed[0]-1;
            int v=ed[1]-1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int c=32-Integer.numberOfLeadingZeros(n);
        up=new int[n][c];
        for(int []r:up){
            Arrays.fill(r,-1);
        }
        d=new int[n];
        int []sq=new int[n+1];
        sq[0]=1;
        pow(sq);

        dfs(0,-1);
        binaryLift(n,c);
        int []ans=new int[queries.length];
        int y=0;
        for(int []q:queries){
            int u=q[0],v=q[1];
            int lc=lca(u-1,v-1,c);
            int x=d[u-1]+d[v-1]-2*d[lc];
            ans[y++]=x==0?0:sq[x-1];
        }
        return ans;

        
    }
}