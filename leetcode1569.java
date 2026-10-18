//step1: find the number of ways to reorder the array such that the BST formed is same as the original BST
//step2: use combinatorics to find the number of ways to reorder the left and right subtrees
//step3: use recursion to find the number of ways to reorder the left and right subtrees
//step4: use memoization to store the results of the subproblems
class Solution {
    int mod=(int)1e9+7;
    long [][]c;
    private long cmb(List<Integer> list){
        int n=list.size();
        if(n<3){
            return 1;
        }
        int root=list.get(0);
        List<Integer>left=new ArrayList<>();
        List<Integer>right=new ArrayList<>();
        for(int i=1;i<n;i++){
            if(list.get(i)<root){
                left.add(list.get(i));
            }
            else{
                right.add(list.get(i));
            }
        }
        long x=cmb(left);
        long y=cmb(right);
        long z=c[n-1][left.size()];
        long ans=(x*y%mod)*z%mod;
        ans=ans%mod;
        return ans;
    }
    public int numOfWays(int[] nums) {
        List<Integer> li=new ArrayList<>();
        int n=nums.length;
        c=new long[n+1][n+1];
        for(int i=0;i<=n;i++){
            c[i][0]=1;
            for(int j=1;j<=i;j++){
                c[i][j]=(c[i-1][j]+c[i-1][j-1])%mod;
            }
        }
        for(int i:nums){
            li.add(i);
        }
        int ans=(int)cmb(li);
        return ans-1;
          
        
    }
}