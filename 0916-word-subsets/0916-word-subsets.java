class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int arr[] = new int[26];
        List<String> ans = new ArrayList<>();
        for (String word : words2){
            int temp[] = new int[26];
            for (int i = 0; i < word.length(); i++){
                temp[word.charAt(i) - 'a']++;
            }

            for (int i = 0; i < 26; i++){
                arr[i] = Math.max(arr[i], temp[i]);
            }
        }

        for (String word : words1){
            int temp[] = new int[26];
            for (int i = 0; i < word.length(); i++){
                temp[word.charAt(i) - 'a']++;
            }
            boolean flag = true;
            for (int i = 0; i < 26; i++){
                if (temp[i] < arr[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) ans.add(word);
        }
        return ans;
    }
}