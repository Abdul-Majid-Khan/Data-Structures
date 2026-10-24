class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int daA=Integer.parseInt(arriveAlice.substring(3));
        int daB=Integer.parseInt(arriveBob.substring(3));
        int maA=Integer.parseInt(arriveAlice.substring(0,2));
        int maB=Integer.parseInt(arriveBob.substring(0,2));

        int dlA=Integer.parseInt(leaveAlice.substring(3));
        int dlB=Integer.parseInt(leaveBob.substring(3));
        int mlA=Integer.parseInt(leaveAlice.substring(0,2));
        int mlB=Integer.parseInt(leaveBob.substring(0,2));
        int []day=new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
        for(int i=1;i<=12;i++){
            int k=day[i];
            day[i]=day[i-1]+k;
        }
        int []alice=new int[2];
         alice[0]=day[maA-1]+daA;
         alice[1]=day[mlA-1]+dlA;
         int[] bob=new int[2];
         bob[0]=day[maB-1]+daB;
         bob[1]=day[mlB-1]+dlB;
         int l=Math.max(alice[0],bob[0]);
         int r=Math.min(alice[1],bob[1]);
         return Math.max(0,r-l+1);

    }
}