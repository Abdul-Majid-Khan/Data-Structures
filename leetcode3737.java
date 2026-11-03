class Solution {
  public int countMajoritySubarrays(int[] nums, int target) {
    int n = nums.length, ans = 0;

    for (int i = 0; i < n; i++) {
      if (nums[i] == target)

        nums[i] = 1;

      else

        nums[i] = -1;
    }

    int[] pf = new int[n];

    pf[0] = nums[0];

    for (int i = 1; i < n; i++) {
      pf[i] = pf[i - 1] + nums[i];
    }

    for (int i = 0; i < n; i++) {
      if (pf[i] > 0)
        ans += 1;

      for (int j = 0; j < i; j++) {
        if (pf[i] > pf[j]) {
          ans += 1;
        }
      }
    }

    return ans;
  }
}