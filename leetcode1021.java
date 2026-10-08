class Solution {
    public String removeOuterParentheses(String s) {
        //intuition :Dyck Path
        StringBuilder sb=new StringBuilder();
        int n=s.length(),bal=0;
        boolean removed=false;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
             if(ch=='('){
                 if(bal>0){
                sb.append(ch);
            }
                bal++;
            }
            else if(ch==')'){
                bal--;
                if(bal>0){
                sb.append(ch);
            }
            }
            
        }
        return sb.toString();
        
    }
}