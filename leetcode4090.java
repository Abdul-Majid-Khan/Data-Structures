class Solution {
    public int countMagicalPairs(String s) {
        int n=s.length(),ans=0;
        for(int j=0;j<n-1;j++){
            int []l=new int[27];
            int []r=new int[27];
            boolean []seen=new boolean[26];
            int d=0;
            for(int i=j;i>=0;i--){
                int c=s.charAt(i)-'a';
                if(!seen[c]){
                    seen[c]=true;
                    d++;
                }
                l[d]++;
            }
            Arrays.fill(seen,false);
            d=0;
            for(int k=j+1;k<n;k++){
                int c=s.charAt(k)-'a';
                if(!seen[c]){
                    seen[c]=true;
                    d++; 
                }
                r[d]++;
                
            }
            for(int x=1;x<27;x++){
                ans+=l[x]*r[x];
            }
        }
        return ans;
        
    }
}