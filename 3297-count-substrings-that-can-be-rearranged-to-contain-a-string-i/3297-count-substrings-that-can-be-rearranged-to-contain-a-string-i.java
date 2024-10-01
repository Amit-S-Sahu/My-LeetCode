class Solution {
    public long validSubstringCount(String word1, String word2) {
        ArrayList<Integer> count1 = new ArrayList<>(26);
        ArrayList<Integer> windows = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            count1.add(0);
            windows.add(0);
        }  
        for (char ch : word2.toCharArray()){
            count1.set(ch-'a',count1.get(ch-'a')+1);
        }
        int left = 0;
        int req = word2.length();
        long answr = 0;
        for (int right = 0; right < word1.length(); right++) {
            char curr = word1.charAt(right);
            if (count1.get(curr-'a') > 0) {
            if (windows.get(curr-'a') < count1.get(curr-'a')) {
                req--;
            }
            }        
            windows.set(curr-'a', windows.get(curr-'a') + 1);
            while (req == 0) {
                answr += word1.length() - right;
                char start = word1.charAt(left);
                windows.set(start-'a', windows.get(start-'a') - 1);
                if (count1.get(start-'a') > 0 && 
                    windows.get(start-'a') < count1.get(start-'a')) {
                    req++;
                }            
                left++;
            }
        }
        return answr;
    }
}