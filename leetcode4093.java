class Solution {
    private int max(int x) {
        int[] f = new int[10];
        while (x != 0) {
            f[x % 10]++;
            x /= 10;
        }
        int ans = 0;
        for (int i = 9; i >= 0; i--) {
            while (f[i] > 0) {
                ans = ans * 10 + i;
                f[i]--;
            }
        }
        return ans;
    }
    public long maximizeSum(int[] nums, int k) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = max(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1] - a[0], b[1] - b[0]));
        long ans = 0;
        for (int i = n - 1; i >= n - k; i--) {
            if (arr[i][1] > arr[i][0])
                ans += arr[i][1];
            else
                ans += arr[i][0];
        }
        for (int i = 0; i < n - k; i++) {
            ans += arr[i][0];
        }
        return ans;
    }
}