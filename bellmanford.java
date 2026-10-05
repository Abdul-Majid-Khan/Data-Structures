
class Solution {
    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {
        ArrayList<Integer>dist=new ArrayList<>();
        int m=(int)1e8;
        for(int i=0; i<V;i++) dist.add(m);
        dist.set(src,0);
        for(int i=0;i<V-1;i++){
            for(int []ed:edges){
                int u=ed[0],v=ed[1],wt=ed[2];
                if(dist.get(u)!=m && dist.get(u)+wt<dist.get(v)){
                    dist.set(v,dist.get(u)+wt);
                }
            }
        }
        
          for(int []ed:edges){
                int u=ed[0],v=ed[1],wt=ed[2];
                if(dist.get(u)!=m && dist.get(u)+wt<dist.get(v)){
                    return new ArrayList<>(List.of(-1));
                }
            }
            
            return dist;
    }
}
