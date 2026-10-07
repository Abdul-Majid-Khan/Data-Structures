class Solution {
    Set<String> hs = new HashSet<>();
    int l = 0;

    private void cmb(int i, int n, String s, StringBuilder sb, int bal) {
        if (bal < 0) {
            return;
        }
        if (i == n) {
            if (bal == 0 && l < sb.length()) {
                l = sb.length();
                hs.clear();
                hs.add(sb.toString());
            }
            if (bal == 0 && sb.length() == l) {
                hs.add(sb.toString());
            }
            return;
        }
        if (s.charAt(i) != '(' && s.charAt(i) != ')') {
            sb.append(s.charAt(i));
            cmb(i + 1, n, s, sb, bal);
            sb.deleteCharAt(sb.length() - 1);
            return;
        } else {
            sb.append(s.charAt(i));
            //take
            cmb(i + 1, n, s, sb, bal + (s.charAt(i) == '(' ? 1 : -1));
            //skip
            sb.deleteCharAt(sb.length() - 1);
            cmb(i + 1, n, s, sb, bal);

        }

    }

    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        cmb(0, n, s, sb, 0);
        List<String> ans = new ArrayList<>(hs);
        return ans;
    }
}