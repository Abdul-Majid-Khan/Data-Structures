class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []r:flights){
            int u=r[0],v=r[1],c=r[2];
            adj.get(u).add(new int[]{v,c});
        }
        int [][]cost=new int[n][k+2];
        for(int[]r:cost){
            Arrays.fill(r,Integer.MAX_VALUE);
        }
    PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.offer(new int[]{src,0,0});
        while(!pq.isEmpty()){
            int []r=pq.poll();
            int u=r[0],c=r[1],st=r[2];
            if(u==dst && st<=k+1) return c;
            for(int []ad:adj.get(u)){
                int v=ad[0],nc=c+ad[1],nst=st+1;
                if(nst<=k+1 && nc<cost[v][nst]){
                    pq.offer(new int[]{v,nc,nst});
                    cost[v][nst]=nc;
                }
            }
        }
        return -1;
        
    }
}