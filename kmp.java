class Solution {
    private void con(int []lps,String pat){
        int n=pat.length();
        int l=0,i=1;
        while(i<n){
            if(pat.charAt(i)==pat.charAt(l)){
                l++;
                lps[i]=l;
                i++;
            }
            else {
                if(l==0){
                    i++;
                }
                else{
                    l=lps[l-1];
                }
            }
        }
    }
    public int strStr(String text, String pat) {
        int m=text.length(),n=pat.length();
        int []lps=new int [n];
        con(lps,pat);
        int i=0,j=0;
        while(i<m){
            if(text.charAt(i)==pat.charAt(j)){
                i++;
                j++;
                if(j==n){
                    return i-n;
                }
            }
            else{
                if(j==0) i++;
                else {
                    j=lps[j-1];
                }
            }
        }
        return -1;
        
    }
}