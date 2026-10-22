class Solution {
  private void isRotated(int[] nums, boolean[] r) {
    int n = nums.length, c1 = 0, c2 = 0;
    for (int i = 0; i < n; i++) {
      if (nums[i] > nums[(i + 1) % n]) {
        c1++;
      }
      if (nums[i] < nums[(i + 1) % n]) {
        c2++;
      }
    }
    r[0] = c1 <= 1;
    r[1] = c2 <= 1;
  }
  public int minOperations(int[] nums) {
    int n = nums.length;
    boolean[] r = new boolean[2];
    isRotated(nums, r);

    if (!r[0] && !r[1])
      return -1;
    int c1 = (int) 1e9, c2 = c1;
    if (r[0]) {
      for (int i = 0; i < n; i++) {
        if (nums[i] == 0) {
          c1 = i;
          break;
        }
      }
    }
    int j = 0;
    if (r[1]) {
      for (int i = n - 1; i >= 0; i--) {
        if (nums[i] == 0) {
          c2 = j;
          break;
        }
        j++;
      }
    }
    c1=Math.min(c1,Math.abs(n-c1)+2);
    c2=Math.min(c2,Math.abs(n-c2));

    return Math.min(c1, c2+1);
  }
}