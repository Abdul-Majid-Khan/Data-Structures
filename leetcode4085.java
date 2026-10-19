// step 1: create a directed graph based on the color rules
// step 2: check if there is a unique root node with in-degree 0 and out-degree <= 2
// step 3: if there is a unique root node, return its index, otherwise return -1
class Solution {
    public int findColoredRoot(int[][] edges, String colors) {
        int n=colors.length();
        List<List<Integer>>adj=new ArrayList<>();
        int []in=new int[n];
        int []out=new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []ed:edges){
            int u=ed[0],v=ed[1];
            char c1=colors.charAt(u);
            char c2=colors.charAt(v);
            
             if(c1=='R' && c2=='B'){
                adj.get(u).add(v);
             }
             else if(c1=='B' && c2=='R'){
                adj.get(v).add(u);
             }

              else if(c1=='B' && c2=='W'){
                adj.get(u).add(v);
             }
              else if(c1=='W' && c2=='B'){
                adj.get(v).add(u);
             }

              else if(c1=='W' && c2=='R'){
                adj.get(u).add(v);
             }
              else if(c1=='R' && c2=='W'){
                adj.get(v).add(u);
             }
        }

        int c=0,ans=-1;

        for(int i=0;i<n;i++){
            for(int j=0;j<adj.get(i).size();j++){
                out[i]++;
                in[adj.get(i).get(j)]++;
            }
        }

        for(int i=0;i<n;i++){
            if(out[i]>2){
                return -1;
            }
            if(in[i]==0){
                ans=i;
                c++;
            }
        }
        if(c!=1 ) return -1;

        return ans;
        
    }
}