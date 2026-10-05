class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        if(grid[0][0]==1 || grid[m-1][n-1]==1) return -1;
        int[][]dir={{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
    PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        boolean[][] seen=new boolean[m][n];
        pq.offer(new int[]{0,0,1});
        while(!pq.isEmpty()){
            int []r=pq.poll();
            int x=r[0],y=r[1],c=r[2];
            seen[x][y]=true;
            if(x==m-1 && y==n-1){
                return c;
            }
            for(int []d:dir){
                int nx=x+d[0];
                int ny=y+d[1];
            if(nx>=0 && ny>=0 && nx<m && ny<n && !seen[nx][ny] && grid[nx][ny]==0){
                pq.offer(new int[]{nx,ny,c+1});
                seen[nx][ny]=true;
            }
            }

        }

        return -1;
        
    }
}