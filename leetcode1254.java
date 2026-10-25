class Solution {
    int m,n;
    private boolean dfs(int [][]grid,int r,int c){
        if(r<0 || c<0 || r>=m ||c>=n ){
            return false;
        }
        if( grid[r][c]==1){
            return true;
        }
        grid[r][c]=1;
        boolean left=dfs(grid,r-1,c);
        boolean right=dfs(grid,r+1,c);
        boolean up=dfs(grid,r,c-1);
        boolean down=dfs(grid,r,c+1);
        return left&right&up&down;  
    }
    public int closedIsland(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int c=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0 &&  dfs(grid,i,j)){
                    c++;
                }
            }
        }
         return c;

        
    }
}