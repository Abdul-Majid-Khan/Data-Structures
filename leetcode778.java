class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->Integer.compare(a[0],b[0]));
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        boolean [][]seen = new boolean[m][n];
        
        pq.offer(new int[]{grid[0][0], 0, 0});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int max_d = curr[0], r = curr[1], c = curr[2];
            
            if (seen[r][c]) continue;
            seen[r][c]=true;
            
            if (r == m-1 && c == n-1) return max_d;
            
            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !seen[nr][nc]) {
                    int new_d = Math.max(max_d, grid[nr][nc]);
                    pq.offer(new int[]{new_d, nr, nc});
                }
            }
        }
        return -1;
    }
}