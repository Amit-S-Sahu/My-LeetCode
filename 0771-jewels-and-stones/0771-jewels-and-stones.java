class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> jewel = new HashSet<>();
        for (Character ch : jewels.toCharArray()) {
            jewel.add(ch);
        }

        int ans = 0;
        for (Character ch : stones.toCharArray()) {
            if (jewel.contains(ch)) ans++;
        }

        return ans;
    }
}