class Solution {
    public int findPermutationDifference(String s, String t) {
        Map<Character, int[]> map = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ch++) map.put(ch, new int[2]);

        for (int i = 0; i < s.length(); i++) {
            map.get(s.charAt(i))[0] = i;
            map.get(t.charAt(i))[1] = i;
        }

        int ans = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            ans += Math.abs(map.get(ch)[0] - map.get(ch)[1]);
        }
        return ans;
    }
}