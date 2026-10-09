class Solution {
    public int minInsertions(String s) {
        int op = 0, cl = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                op++;
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    cl++;
                }

                if (op > 0) {
                    op--;
                } else {
                    cl++;
                }
            }
        }

        return cl + 2 * op;
    }
}