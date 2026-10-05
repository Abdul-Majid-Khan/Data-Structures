class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int inf = Integer.MAX_VALUE;
        int[][] tm = new int[n + 1][n + 1];
        for (int[] r : tm) {
            Arrays.fill(r, inf);
        }
        for (int i = 1; i <= n; i++) {
            tm[i][i] = 0;
        }
        for (int[] ed : times) {
            int u = ed[0], v = ed[1], t = ed[2];
            tm[u][v] = t;
        }
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n; x++) {
                for (int z = 1; z <= n; z++) {
                    if (tm[x][y] != inf && tm[y][z] != inf)
                        tm[x][z] = Math.min(tm[x][z], tm[x][y] + tm[y][z]);
                }
            }
        }
        int ans = -1;
        for (int i = 1; i <= n; i++) {
            if (tm[k][i] == inf)
                return -1;
            else {
                ans = Math.max(ans, tm[k][i]);
            }
        }

        return ans;

    }
}