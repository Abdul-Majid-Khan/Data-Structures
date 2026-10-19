class Solution {
  public List<Integer> targetIndices(int[] nums, int target) {
    List<Integer> ans = new ArrayList<>();
    int c = 0, tc = 0, n = nums.length;
    for (int i = 0; i < n; i++) {
      if (nums[i] < target) {
        c++;
      } else if (nums[i] == target) {
        tc++;
      }
    }
    if (tc == 0)
      return ans;
    for (int i = c; i < c + tc; i++) {
      ans.add(i);
    }
    return ans;
  }
}