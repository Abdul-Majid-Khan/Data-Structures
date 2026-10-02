class Solution {
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        // code here
        List<Integer>ans=new ArrayList<>();
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            List<int[]> l=new ArrayList<>();
            ans.add(Integer.MAX_VALUE);
            adj.add(l);
        }
        
       
        for(int []e:edges){
            int u=e[0],v=e[1],w=e[2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
         ans.set(src,0);
        pq.offer(new int[]{src,0});
        while(!pq.isEmpty()){
            int []arr=pq.poll();
            int node1=arr[0],wt1=arr[1];
            for(int[] ng:adj.get(node1)){
                int node2=ng[0];
                int wt2=ng[1];
                if(wt1+wt2<ans.get(node2)){
                    ans.set(node2,wt1+wt2);
                    pq.offer(new int[]{node2,ans.get(node2)});
                }
                
            }
        }
       
        return ans;
    }
}