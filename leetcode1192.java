// Approach: Tarjan's Algorithm

class Solution {
    int t=1;
    private void dfs(int node,boolean[]seen,int p,List<List<Integer>>adj,List<List<Integer>>ans,int []tin,int []min){
          seen[node]=true;
           tin[node] = min[node] = t++;
         for(int it :adj.get(node)){
            if(it==p) continue;
            if(!seen[it]){
                dfs(it,seen,node,adj,ans,tin,min);
                min[node]=Math.min(min[it],min[node]);
                if(tin[node]<min[it]){
                    ans.add(Arrays.asList(node,it));
                }
            }
            else{
                min[node]=Math.min(min[node],min[it]);
            }
         } 
    
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        
        boolean[] seen=new boolean[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> l:connections ){
              int i=l.get(0);
               int j=l.get(1);
                adj.get(j).add(i);
                adj.get(i).add(j);
        }
        int []tin=new int[n];
        int []min=new int[n];
        dfs(0,seen,-1,adj,ans,tin,min);
        return ans;
        
    }
}