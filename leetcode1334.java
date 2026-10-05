class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int [][]dist=new int[n][n];
        int inf=Integer.MAX_VALUE;
        for(int []r:dist){
            Arrays.fill(r,inf);
        }
        for(int i=0;i<n;i++){
          dist[i][i]=0;
        }
        for(int []ed:edges){
            int u=ed[0],v=ed[1],d=ed[2];
            dist[u][v]=d;
            dist[v][u]=d;
        }
        for(int j=0;j<n;j++){
            for(int i=0;i<n;i++){
                for(int k=0;k<n;k++){
                    if(dist[i][j]!=inf && dist[j][k]!=inf)
                    dist[i][k]=Math.min(dist[i][k],dist[i][j]+dist[j][k]);
                }
            }
        }
        int ans=-1,nc=inf;
        for(int i=0;i<n;i++){
            int k=0;
            for(int j=0;j<n;j++){
              if(dist[i][j]<=distanceThreshold)
              k++;
            }
            if(k<=nc){
                ans=i;
                nc=k;
            }
        }
        return ans;
        
    }
}