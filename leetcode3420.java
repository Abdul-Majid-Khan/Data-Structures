class Solution {
    long []pf;
    private long sum(int i,int j){
        if(j<i) return 0;
        long ans=pf[j]-(i>0?pf[i-1]:0);
        return ans;
    }
    public long countNonDecreasingSubarrays(int[] nums, int k) {
         int n=nums.length;
         pf=new long[n];
         pf[0]=nums[0];
         for(int i=1;i<n;i++){
            pf[i]=nums[i]+pf[i-1];
         }
         int []nge=new int[n];
         Arrays.fill(nge,n);
         Stack<Integer> st=new Stack<>();
         for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                int idx=st.pop();
                 nge[idx]=i;
            }
            st.push(i);
         }
       long []op =new long[n+1];
       for(int i=n-1;i>=0;i--){
        int m=nge[i];
        long opr=1L*nums[i]*(m-i)-sum(i,m-1);
        op[i]=opr+op[m];
       }
       Deque<Integer> dq=new ArrayDeque<>();
       int l=0;
       long ans=0;
       for(int r=0;r<n;r++){
          while(!dq.isEmpty() && nums[dq.peekLast()]<nums[r]){
            dq.pollLast();
          }
           dq.offerLast(r);
           while(l<=r){
            int m=dq.peekFirst();
            long opc=op[l]-op[m]+1L*nums[m]*(r-m+1)-sum(m,r);
            if(opc<=k) break;
             l++;
             if(dq.peekFirst()<l){
                dq.pollFirst();
             }
           }
           ans+=r-l+1;
       }
       return ans;
    }
}