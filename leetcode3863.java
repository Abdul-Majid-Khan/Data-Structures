class Solution {
    private boolean isSorted(String s){
        int n=s.length();
        char ch=s.charAt(0);
        for(int i=1;i<n;i++){
            if(s.charAt(i)<ch){
                return false;
            }
            ch=s.charAt(i);
        }
        return true; 
    }
    private char minChar(String s,int l,int r){
        char ans =s.charAt(l);
        for(int i=l;i<r;i++){
            if(s.charAt(i)<ans){
                ans=s.charAt(i);
            }
        }
        return ans;
    }
    private char maxChar(String s,int l,int r){
        char ans=s.charAt(l);
        for(int i=l;i<r;i++){
            if(s.charAt(i)>ans){
                ans=s.charAt(i);
            }
        }
        return ans;
    }
    public int minOperations(String s) {
        int n=s.length();
        if(isSorted(s)){
            return 0;
        }
        if(n==2){
            return -1;
        }
        char min=minChar(s,0,n);
        char max=maxChar(s,0,n);
        char mid_min=minChar(s,1,n-1);
        char mid_max=maxChar(s,1,n-1);
        if(s.charAt(0)==min || s.charAt(n-1)==max){
            return 1;
        }
        if(min==mid_min || max==mid_max){
            return 2;
        }
        return 3;
        
    }
}