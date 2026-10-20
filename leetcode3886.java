//KMP Algo 
class Solution {
    private void con(int []lps,int[]pat){
        int n=pat.length,l=0,i=1;
        while(i<n){
            if(pat[l]==pat[i]){
                l++;
                lps[i]=l;
                i++;
            }
            else{
                if(l==0) i++;
                else {
                    l=lps[l-1];
                }
            }
        }
    }
    private boolean check(int []arr1,int []pat){
        int m=arr1.length,n=pat.length;
        int []num=new int[2*m];
        for(int i=0;i<m;i++){
            num[i]=arr1[i];
        }
        int j=m;
        for(int i=0;i<m;i++){
            num[j++]=arr1[i];
        }
        int []lps=new int[n];
        con(lps,pat);
        int i=0;
        j=0;
        while(i<2*m){
           if(num[i]==pat[j]){
            i++;
            j++;
            if(j==n) return true;
           }
           else{
            if(j==0) i++;
            else{
                j=lps[j-1];
            }
           }
        }
        return false;
    }
    public int sortableIntegers(int[] nums) {
        int n=nums.length;
        int []arr=nums.clone();
        Arrays.sort(arr);
        int ans=0;
        for(int k=1;k<=n;k++){
            if((n%k)==0){
                boolean valid=true;
                for(int j=0;j<n;j+=k){
                int []arr1=Arrays.copyOfRange(nums,j,j+k);
                int []arr2=Arrays.copyOfRange(arr,j,j+k);
                    if(!check(arr1,arr2)){
                        valid=false;
                        break;
                    }

                }
                if(valid){
                    ans+=k;
                }
            }
        }

        return ans;
        
    }
}