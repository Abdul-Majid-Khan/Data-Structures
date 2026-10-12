// Approach: Greedy
//Step1: Count the number of 1s in each bit position for all numbers in the array.
//Step2: For k iterations, construct the maximum number possible by taking  the remaining set bits from the count array and calculate the square of that number and add it to the answer.

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int m = (int) 1e9 + 7;
        int[] cb = new int[32];
        int n = nums.size();
        for (int i : nums) {
            for (int j = 0; j < 32; j++) {
                if ((i & (1 << j)) != 0) {
                    cb[j]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            long t = 0;
            for (int j = 31; j >= 0; j--) {
                if (cb[j] > 0) {
                    t |= (1 << j);
                    cb[j]--;
                }

            }
            t %= m;
            long x = t * t;
            x %= m;
            ans = (ans + (int)x) % m;
        }
        return ans;

    }
}