class Solution {
    int c=0;
    private void dfs(Stack<Integer> st,List<ArrayList<Integer>> adj,boolean[]seen,int src,boolean fp){
        seen[src]=true;
        for(int i:adj.get(src)){
            if(!seen[i]){
                dfs(st,adj,seen,i,fp);
            }
        }
        if(fp)
        st.push(src);
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
         List<ArrayList<Integer>> trn=new ArrayList<>();
         for(int i=0;i<V;i++){
            trn.add(new ArrayList<>());
         }
         boolean []seen=new boolean[V];
         Stack<Integer> st=new Stack<>();
         
          for(int i=0;i<V;i++){
              if(! seen[i])
               dfs(st,adj,seen,i,true);
          }
         for(int i=0;i<V;i++){
            for(int j:adj.get(i)){
            trn.get(j).add(i);
            }
         }
        Arrays.fill(seen,false);
        c=0;
        while(!st.isEmpty()){
            int src=st.pop();
            if(!seen[src]){
            dfs(st,trn,seen,src,false);
              c++;
            }

        } 
        return c;

    
    }
}

