class Solution {
    public boolean checkValidString(String s) {
        int max=0,min=0,n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                max+=1;
                min+=1;
            }
             if(s.charAt(i)==')'){
                max-=1;
                min-=1;
            }
             if(s.charAt(i)=='*'){
                max+=1;
                min-=1;
            }
             if(min<0){
                min=0;
                
            }

             if(max<0){
                return false;
                
            }
        }
        return min==0;
        
    }
}