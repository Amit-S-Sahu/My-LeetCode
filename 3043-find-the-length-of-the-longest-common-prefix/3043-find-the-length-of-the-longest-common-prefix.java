class Solution {
    class TrieNode{
        TrieNode [] child = new TrieNode[10];
        boolean isEnd;
    }
    public void insert(String key, TrieNode root){
        TrieNode curr = root;
        int n = n = key.length();
        for(int i=0;i<n;i++){
            int index = key.charAt(i)-'0';
            if(curr.child[index] == null)
                curr.child[index] = new TrieNode();
            curr = curr.child[index];
        }
        curr.isEnd = true;
    }
    public int Lcp(String key,TrieNode root){
        TrieNode curr = root;
        int i,n = key.length();
        for(i=0;i<n;i++){
            int index = key.charAt(i)-'0';
            if(curr.child[index] == null){
                return i;
            }
            curr = curr.child[index];
        }
        return i;
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode root = new TrieNode();
        for(int i=0;i<arr2.length;i++){
            insert(Integer.toString(arr2[i]),root);
        }
        int max_len = 0,len = 0;
        for(int i=0;i<arr1.length;i++){
            len = Lcp(Integer.toString(arr1[i]),root);
            if(len > max_len){
                max_len = len;
            }
        }
        return max_len;
    }
}