class Solution {
    int m, n;

    private long dfs(int[][] grid, int r, int c, boolean[][] seen) {
        if (r < 0 || r >= m || c < 0 || c >= n
                || grid[r][c] == 0 || seen[r][c]) {
            return 0;
        }

        seen[r][c] = true;

        long sum = grid[r][c];

        sum += dfs(grid, r - 1, c, seen);
        sum += dfs(grid, r + 1, c, seen);
        sum += dfs(grid, r, c - 1, seen);
        sum += dfs(grid, r, c + 1, seen);

        return sum;
    }

    public int countIslands(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] seen = new boolean[m][n];
        int c = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0 && !seen[i][j]) {
                    long sum = dfs(grid, i, j, seen);

                    if (sum % k == 0) {
                        c++;
                    }
                }
            }
        }

        return c;
    }
}