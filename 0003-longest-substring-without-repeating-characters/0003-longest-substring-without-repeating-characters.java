class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 1) return 0;
        int left = 0, max = 1, right = 0;
        Set<Character> set = new HashSet<>();
        for (; right < s.length(); right++) {
            Character curr = s.charAt(right);
            if (!set.contains(curr)) set.add(curr);
            else {
                max = Math.max(max, right - left);
                while (set.contains(curr)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(curr);
            }
        }
        max = Math.max(max, right - left);
        return max;
    }
}