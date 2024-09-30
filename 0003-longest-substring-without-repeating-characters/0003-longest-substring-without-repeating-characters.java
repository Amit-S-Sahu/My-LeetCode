class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> map = new HashSet<>();
        int max_count = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            while (map.contains(s.charAt(right))) {
                map.remove(s.charAt(left));
                left++;
            }
            map.add(s.charAt(right));
            max_count = Math.max(max_count, right - left + 1);
        }
        
        return max_count;
    }
}