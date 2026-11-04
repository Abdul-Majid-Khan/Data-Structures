class Solution {
    TreeMap<Integer,Integer> left=new TreeMap<>();
    TreeMap<Integer,Integer> right=new TreeMap<>();
    int lc=0,rc=0;

    private void add(int n){
        if(rc==0 || n>right.firstKey()){
            right.put(n,right.getOrDefault(n,0)+1);
            rc++;
        }
        else{
            left.put(n,left.getOrDefault(n,0)+1);
            lc++;
        }
        balance();
    }

    private void balance(){
        if(lc > rc){
            int k=left.lastKey();
            right.put(k,right.getOrDefault(k,0)+1);
            lc--;
            rc++;
            if(left.get(k)==1){
                left.remove(k);
            }
            else{
                left.put(k,left.get(k)-1);
            }
        }
        else if(rc>lc+1){
            int k=right.firstKey();
            left.put(k,left.getOrDefault(k,0)+1);
            rc--;
            lc++;
            if(right.get(k)==1){
                right.remove(k);
            }
            else{
                right.put(k,right.get(k)-1);
            }
        }
    }

     private void del(int n){
        if(right.containsKey(n)){
            int k=right.get(n);
            rc--;
            if(k==1){
                right.remove(n);
            }
            else{
                right.put(n,right.get(n)-1);
            }
        }
        else{
            int k=left.get(n);
            lc--;
            if(k==1){
                left.remove(n);
            }
            else{
                left.put(n,left.get(n)-1);
            }
        }
        balance();
     }

     private double med(){
        double ans=0;
        if(lc==rc){
            ans=((double)left.lastKey()+right.firstKey())/2;
        }
        else {
            ans=right.firstKey();
        }
        return ans;
     }

    public double[] medianSlidingWindow(int[] nums, int k) {
        int s=nums.length;
        double[] ans=new double[s-k+1];
        for(int i=0;i<k;i++){
            add(nums[i]);
        }
        ans[0]=med();
        for(int i=k;i<s;i++){
             del(nums[i-k]);
             add(nums[i]);
             ans[i-k+1]=med();
        }
         return ans;
        
    }
}