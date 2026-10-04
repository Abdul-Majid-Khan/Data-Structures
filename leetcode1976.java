class Solution {
    int mod=(int)1e9+7;
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []r:roads){
            int u=r[0],v=r[1],c=r[2];
            adj.get(u).add(new int[]{v,c});
            adj.get(v).add(new int[]{u,c});
        }
       int []ways=new int[n];
       long []time=new long[n];
       Arrays.fill(time,Long.MAX_VALUE);
    PriorityQueue<long[]>pq=new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
       pq.offer(new long[]{0,0});
       ways[0]=1;
       time[0]=0;

       while(!pq.isEmpty()){
        long []r=pq.poll();
        int u=(int)r[0];
        long tu=r[1];
        for(int []k:adj.get(u)){
            int v=k[0];
            long tv=k[1];
           long sum=tv+tu; 
           if(sum<time[v]){
            pq.offer(new long[]{v,sum});
            time[v]=sum;
            ways[v]=ways[u];
           }

           else if(sum == time[v]){
            ways[v] = (int)((ways[v] + (long)ways[u]) % mod);
           }
        }
       } 

       return ways[n-1];
        
    }
}