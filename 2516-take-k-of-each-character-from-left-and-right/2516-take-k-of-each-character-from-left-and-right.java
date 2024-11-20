class Solution {
    public int takeCharacters(String s, int k) {
        int count[] = new int[3];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        if (Math.min(Math.min(count[0], count[1]), count[2]) < k) return -1;
        
        int ans = Integer.MAX_VALUE;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'a']--;
            
            while (Math.min(Math.min(count[0], count[1]), count[2]) < k) {
                count[s.charAt(left) - 'a']++;
                left++;
            }
            ans = Math.min(ans, s.length() - (right - left + 1));
        }
        return ans;
    }
}