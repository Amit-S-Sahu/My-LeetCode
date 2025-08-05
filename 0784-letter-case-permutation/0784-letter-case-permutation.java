class Solution {
    List<String> list = new ArrayList<>();

    private void helper(StringBuilder sb, String s, int pos) {
        if (pos == s.length()) {
            list.add(sb.toString());
            return;
        }

        char c = s.charAt(pos);
        sb.append(c);
        helper(sb, s, pos + 1);
        sb.deleteCharAt(sb.length() - 1);

        if (Character.isLetter(c)) {
            sb.append(Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c));
            helper(sb, s, pos + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCasePermutation(String s) {
        list.clear();
        helper(new StringBuilder(), s, 0);
        return list;
    }
}
