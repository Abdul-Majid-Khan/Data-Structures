class Solution {
    public int scoreOfParentheses(String s) {
        int n=s.length(),bal=0,ans=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                bal++;
            }
            else{
                bal--;
                if(s.charAt(i-1)=='(')
                ans+=1<<bal;
            }
        }
        return ans;
    }
}