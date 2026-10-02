class Solution {
    private void cmb(int n,String co,int l,int r,List<String> s){
        if(co.length()==2*n){
            s.add(co);
            return;
        }
        if(l<n){
            cmb(n,co+'(',l+1,r,s);
        }
        if(r<l){
            cmb(n,co+')',l,r+1,s);
        }
    }
    public List<String> generateParenthesis(int n) {
        String co="";
        List<String> s=new ArrayList<>();
        cmb(n,co,0,0,s);
        return s;

        
    }
}