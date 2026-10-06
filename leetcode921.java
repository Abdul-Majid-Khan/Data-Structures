class Solution {
    public int minAddToMakeValid(String s) {
        int o=0,im=0;
        for(char ch :s.toCharArray()){
            if(ch=='(')
            o++;
            else if(o==0)
            im++;
            else
            o--;
        }
        return im+o;
        
    }
}