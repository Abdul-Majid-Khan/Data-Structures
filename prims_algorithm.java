class Solution {
    public int spanningTree(int V, int[][] edges) {
        List<List<int[]>> adj =new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] ed:edges){
            int u=ed[0],v=ed[1],w=ed[2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        boolean []seen=new boolean[V];
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        pq.offer(new int[]{-1,0,0});
        seen[0]=true;
        int ans=0;
        while(!pq.isEmpty()){
            int []r=pq.poll();
            int u=r[0],v=r[1],w=r[2];
            if(!seen[v]){
                seen[v]=true;
                ans+=w;
            }
            for(int []x:adj.get(v)){
                int nv=x[0],nw=x[1];
                if(!seen[nv])
                pq.offer(new int []{v,nv,nw});
            }
        }
        
        return ans;
        
    }
}
