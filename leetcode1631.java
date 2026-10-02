class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length,n=heights[0].length;
        int [][]dir={{0,1},{1,0},{-1,0},{0,-1}};
        int [][]min=new int [m][n];
        PriorityQueue<int []> pq=new PriorityQueue<>(Comparator.comparingInt(a ->a[0]));
        for(int []r:min){
            Arrays.fill(r,Integer.MAX_VALUE);
        }
        min[0][0]=0;
        pq.offer(new int []{0,0,0});
        while(!pq.isEmpty()){
            int []r=pq.poll();
            int d=r[0],x=r[1],y=r[2];
            if(x==m-1 && y==n-1)
            return d;
            for(int []k:dir){
                int nx=x+k[0],ny=y+k[1];
                if(nx>=0 && nx<m && ny>=0 && ny<n){
                    int nd=Math.max(d,Math.abs(heights[x][y]-heights[nx][ny]));
                    if(nd<min[nx][ny]){
                        min[nx][ny]=nd;
                        pq.offer(new int []{nd,nx,ny});
                    }
                }
            }
        }
        return -1;
        
    }
}