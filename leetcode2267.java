class Solution {
    public boolean hasValidPath(char[][] grid) {

        if (grid[0][0] == ')')
            return false;

        int m = grid.length, n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        boolean[][][] seen = new boolean[m][n][m + n + 1];

        q.offer(new int[]{0, 0, 1});
        seen[0][0][1] = true;

        int[][] dir = {{0, 1}, {1, 0}};

        while (!q.isEmpty()) {

            int[] r = q.poll();

            int x = r[0];
            int y = r[1];
            int bal = r[2];

            if (x == m - 1 && y == n - 1 && bal == 0)
                return true;

            for (int[] d : dir) {

                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < m && ny < n) {

                    int c = grid[nx][ny] == '(' ? 1 : -1;
                    int nb = bal + c;

                    if (nb >= 0 && !seen[nx][ny][nb]) {

                        seen[nx][ny][nb] = true;

                        q.offer(new int[]{nx, ny, nb});
                    }
                }
            }
        }

        return false;
    }
}