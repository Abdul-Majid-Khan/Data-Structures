class Solution {
    private int dSum(int n){
        int s=0;
        while(n!=0){
            s+=n%10;
            n/=10;
        }
        return s;
    }
    public int minSwaps(int[] nums) {
        int n=nums.length;
        Integer[]arr=new Integer[n];
        Map<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<n;i++){
            arr[i]=nums[i];
            mp.put(nums[i],i);
        }
        Arrays.sort(arr,(a,b)->{
            int sA=dSum(a);
            int sB=dSum(b);
            if(sA!=sB){
                return Integer.compare(sA,sB);
            }
            return Integer.compare(a,b);
        });
        int ans=0;
        for(int i=0;i<n;i++){
            int j=arr[i],k=nums[i];
            int in=mp.get(j);
            if(in !=i){
                ans++;
                mp.put(arr[i],i);
                mp.put(k,in);
                int t=nums[i];
                nums[i]=nums[in];
                nums[in]=t;
            }
        }

        return ans;


        
    }
}