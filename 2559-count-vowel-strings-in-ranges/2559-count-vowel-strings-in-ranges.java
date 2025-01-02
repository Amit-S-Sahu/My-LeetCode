class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int arr[] = new int[words.length];

        HashSet<Character> set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        for (int i = 0; i < words.length; i++){
            String s = words[i];
            if (set.contains(s.charAt(0)) && set.contains(s.charAt(s.length() - 1))) arr[i] = i > 0 ? arr[i - 1] + 1 : 1;
            else arr[i] = i > 0 ? arr[i - 1] : 0;
        }
        int ans[] = new int[queries.length];
        int i = 0;
        for(int q[] : queries){
            int l = q[0];
            int j = q[1];
            int k = arr[j];
            k = l == 0 ? k : k - arr[l - 1];
            ans[i++] = k;
        }
        return ans;
    }
}