//Step1: find the first and last index of each character in the string
//Step2: check if the substring from first to last index of each character contains any character whose first index is less than the first index of the current character, if yes then mark it as false
//Step3: iterate from the end of the string and check if the current character can be a starting character and if it is the first index of that character and if the last index of that character is less than the last index of the previous substring, if yes then add it to the answer list


class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] st = new int[26];
        int[] end = new int[26];
        boolean[] canStart = new boolean[26];
        Arrays.fill(st, -1);
        Arrays.fill(end, -1);
        Arrays.fill(canStart, true);

        //Step1

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (st[ch - 'a'] == -1) {
                st[ch - 'a'] = i;
            }
            end[ch - 'a'] = i;
        }

        //Step2

        for (int i = 0; i < 26; i++) {
            if (st[i] == -1)
                continue;
            for (int j = st[i]; j <= end[i]; j++) {
                int idx = s.charAt(j) - 'a';
                if (st[idx] < st[i]) {
                    canStart[i] = false;
                    break;
                }
                end[i] = Math.max(end[i], end[idx]);
            }
        }
         
         //Step3
        List<String> ans = new ArrayList<>();
        int last = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            int idx = s.charAt(i) - 'a';
            if (canStart[idx] && i == st[idx] && last > end[idx]) {
                ans.add(s.substring(st[idx], end[idx] + 1));
                last = st[idx];
            }
        }
        return ans;

    }
}