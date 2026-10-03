class Solution {
    public int longestValidParentheses(String s) {
        if(s.length()==0) return 0;
        int n=s.length(),ans=0,op=0,cl=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                op++;
            }
            else if(s.charAt(i)==')'){
                cl++;
            }
           if(op==cl) ans=Math.max(ans,2*cl);
           if(op<cl){
            op=0;
            cl=0;
           } 
        }
        op=0;
        cl=0;

        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)==')'){
                cl++;
            }
            else if(s.charAt(i)=='('){
                op++;
            }
           if(op==cl) ans=Math.max(ans,2*cl);
           if(op>cl){
            op=0;
            cl=0;
           }
        }
       
        return ans;
        
    }
}