class Solution {
    public ArrayList<Integer> shortestPath(int V, int[][] edges, int src, int dest) {
        ArrayList<Integer> ans = new ArrayList<>();   
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
            ans.add(Integer.MAX_VALUE);
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }


        ans.set(dest, 0);
        pq.offer(new int[]{dest, 0});

        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int node1 = arr[0], wt1 = arr[1];
            if (wt1 > ans.get(node1)) continue;

            for (int[] ng : adj.get(node1)) {
                int node2 = ng[0], wt2 = ng[1];
                if (wt1 + wt2 < ans.get(node2)) {
                    ans.set(node2, wt1 + wt2);
                    pq.offer(new int[]{node2, ans.get(node2)});
                }

            }
        }

        ArrayList<Integer> way = new ArrayList<>();

        if (ans.get(src) == Integer.MAX_VALUE) {
            way.add(-1);
            return way;
        }

        int curr = src;
        way.add(src);

        while (curr != dest) {
            int next = -1;

            for (int[] neighbor : adj.get(curr)) {
                int v = neighbor[0], w = neighbor[1];
                if (ans.get(v) == Integer.MAX_VALUE) continue;

                if (ans.get(v) + w == ans.get(curr)) {
                    if (next == -1 || v < next) next = v;
                }
            }

            if (next == -1) {          
                way.clear();
                way.add(-1);
                return way;
            }

            way.add(next);

            curr = next;
        }

        return way;
    }
}