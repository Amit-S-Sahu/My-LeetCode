class Solution {
    public int maxUniqueSplit(String s) {
        return backtrack(s, new HashSet<>(), 0);
    }

    private int backtrack(String s, HashSet<String> set, int start) {
        if (start == s.length()) {
            return 0; 
        }

        int max = 0;
        StringBuilder sb = new StringBuilder(); 
        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            String curr = sb.toString();

            if (!set.contains(curr)) {
                set.add(curr);  
                max = Math.max(max, 1 + backtrack(s, set, i + 1));
                set.remove(curr); 
            }
        }    
        return max;
    }
}
