class Solution {
    private int check(int[] p1,int []p2,int[]p3){
        int x1=p1[0],y1=p1[1];
        int x2=p2[0],y2=p2[1];
        int x3=p3[0],y3=p3[1];
        return (y2-y1)*(x3-x2)-(x2-x1)*(y3-y2);
    }
    public int[][] outerTrees(int[][] trees) {
        List<int[]>up=new ArrayList<>();
        List<int[]>low=new ArrayList<>();
        Arrays.sort(trees,(a,b)->a[0]!=b[0]?Integer.compare(a[0],b[0]):Integer.compare(a[1],b[1]));
        for(int []p3:trees){
            int u=up.size();
            int l=low.size();
            while(u>=2 && check(up.get(u-1),up.get(u-2),p3)<0){
                up.remove(u-1);
                u--;
            }
            while(l>=2 && check(low.get(l-1),low.get(l-2),p3)>0){
                low.remove(l-1);
                l--;
            }
            up.add(p3);
            low.add(p3);
        }
        Set<int[]> hs=new HashSet<>();
        for(int []r:up){
            hs.add(r);
        }
        for(int []r:low){
            hs.add(r);
        }
        int [][]ans=new int[hs.size()][2];
        int i=0;
        for(int []r:hs){
            ans[i][0]=r[0];
            ans[i][1]=r[1];
            i++;
        }
        return ans;
        
    }
}