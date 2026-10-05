class Solution {
    public void floydWarshall(int[][] dist) {
        int inf=(int)1e8,m=dist.length;
        for(int j=0;j<m;j++){
            for(int i=0;i<m;i++){
                for(int k=0;k<m;k++){
                    if(dist[i][j]!=inf && dist[j][k]!=inf)
                    dist[i][k]=Math.min(dist[i][k],dist[i][j]+dist[j][k]);
                }
            }
        }
    }
}