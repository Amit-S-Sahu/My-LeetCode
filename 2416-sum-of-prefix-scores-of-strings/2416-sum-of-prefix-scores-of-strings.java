class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int count = 0;
    }

    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();
        int[] ans = new int[words.length];

        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
                node.count++; 
            }
        }

        for (int i = 0; i < words.length; i++) {
            TrieNode node = root;
            int sum = 0;
            for (char c : words[i].toCharArray()) {
                int index = c - 'a';
                node = node.children[index];
                sum += node.count; 
            }
            ans[i] = sum;
        }

        return ans;
    }
}