class Solution {
    List<String> list = new ArrayList<>();

    private void helper(String s, StringBuilder sb, boolean used[]) {
        if (sb.length() == s.length()) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (used[i]) continue;
            used[i] = true;
            sb.append(s.charAt(i));
            helper(s, sb, used);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) sb.append(String.valueOf(i));
        helper(sb.toString(), new StringBuilder(), new boolean[n]);
        return list.get(k - 1);
    }
}