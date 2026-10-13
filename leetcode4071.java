
class Solution {
    private int d(int a, int b) {
        int x = Math.abs(a - b);
        return Math.min(x, 10 - x);
    }
    public int minRotations(int n, String s) {
        int total = 0, p = 0;
        for (int i = 0; i < n; i++) {
            int k = s.charAt(i) - '0';
            total += d(p, k);
            p = k;
        }
        int last = s.charAt(n - 1) -'0';
        int ans = total; 
        ans = Math.min(ans,total - d(0, s.charAt(0) - '0') + d(0,last));
        for (int i = 0; i < n - 1; i++) {
            int cur = s.charAt(i) - '0';
            int next = s.charAt(i + 1) - '0';
            ans = Math.min(ans, total - d(cur, next) + d(cur, last));
        }
        return ans;
    }
}