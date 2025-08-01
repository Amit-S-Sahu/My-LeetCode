class Solution {
    Map<Integer, String> map;
    List<String> list = new ArrayList<>();

    private void helper(String digits, StringBuilder sb, int index) {
        if (sb.length() == digits.length()) {
            list.add(sb.toString());
            return;
        }
        
        String letters = map.get(digits.charAt(index) - '0');
        for (int j = 0; j < letters.length(); j++) {
            sb.append(letters.charAt(j));
            helper(digits, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<String>();
        map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        helper(digits, new StringBuilder(), 0);
        return list;
    }
}