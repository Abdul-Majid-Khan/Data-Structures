class TreeAncestor {
    int [][]up;
    int r,c;
    private int fLog(int n,int b){
        int ans=(int)(Math.log(n)/Math.log(b));
        return ans;
    }

    public TreeAncestor(int n, int[] parent) {
        r=n;
        c=fLog(n,2)+1;
        up=new int[r][c];
        for(int []i:up){
            Arrays.fill(i,-1);
        }
        for(int i=0;i<r;i++){
            up[i][0]=parent[i];
        }
        for(int j=1;j<c;j++){
            for(int i=0;i<r;i++){
                if(up[i][j-1]!=-1)
                up[i][j]=up[up[i][j-1]][j-1];
            }
        }
        
    }
    
    public int getKthAncestor(int node, int k) {
        int ans=node;
        for(int j=0;j<c;j++){
            if((k & (1<<j)) !=0){
              ans=up[ans][j];
            }
            if(ans==-1) return -1;
        }
        return ans;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */