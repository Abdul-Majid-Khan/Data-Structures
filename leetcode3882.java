class Solution {
    public int minCost(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        boolean [][][]seen=new boolean [m][n][1024];
        seen[0][0][grid[0][0]]=true;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) continue;
                for(int k=0;k<1024;k++){
                    if(i>0&&seen[i-1][j][k] || j>0 && seen[i][j-1][k]){
                        seen[i][j][k^grid[i][j]]=true;
                    }
                }
            }
        }

        for(int k=0;k<1024;k++){
            if(seen[m-1][n-1][k]){
                return k;
            }
        }
         return -1;
        
    }
}