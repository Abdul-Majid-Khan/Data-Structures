// step 1: build a segment tree to store the sum of squares and sum of elements in a range
// step 2: use lazy propagation to update the range when we add 1 to a range
// step 3: for each element in the array, we find the last index of that element and update the range from last index + 1 to current index with +1
// step 4: after each update, we add the sum of squares in the range to the answer
class Solution {
    int mod=(int)1e9+7;
    int n;
    long []sqTree;
    long []sumTree;
    long []lazyTree;
    private void lazyAdd(int i,int l,int r,long val){
        int len=r-l+1;
        sqTree[i]+=2*val*sumTree[i]+len*val*val;
        sumTree[i]+=len*val;

    }
    private void updateRange(int st,int end,int i,int l,int r,int val){
        if(lazyTree[i]!=0){
            lazyAdd(i,l,r,lazyTree[i]);
            if(l!=r){
                lazyTree[2*i+1]+=lazyTree[i];
                lazyTree[2*i+2]+=lazyTree[i];
            }
            lazyTree[i]=0;
        }
        //out of range
        if(l>r || l>end || r<st){
            return;
        }

        // within range
        if(l>=st && r<=end){
             lazyAdd(i,l,r,val);
            if(l!=r){
                lazyTree[2*i+1]+=val;
                lazyTree[2*i+2]+=val;
            }
            return;
        }
        int mid =l+(r-l)/2;
        updateRange(st,end,2*i+1,l,mid,val);
        updateRange(st,end,2*i+2,mid+1,r,val);
        sqTree[i]=sqTree[2*i+1]+sqTree[2*i+2];
        sumTree[i]=sumTree[2*i+1]+sumTree[2*i+2];
    }
    public int sumCounts(int[] nums) {
        n=nums.length;
        sqTree=new long[4*n];
        sumTree=new long[4*n];
        lazyTree=new long[4*n];
        int []lIndex=new int[100001];
        Arrays.fill(lIndex,-1);
        long ans=0;
        for(int i=0;i<n;i++){
            int st=lIndex[nums[i]]+1;
            int end=i;
            updateRange(st,end,0,0,n-1,1);
            ans=(ans+sqTree[0])%mod;
            lIndex[nums[i]]=i;
        }
        ans%=mod;
        return (int)ans;
        
    }
}