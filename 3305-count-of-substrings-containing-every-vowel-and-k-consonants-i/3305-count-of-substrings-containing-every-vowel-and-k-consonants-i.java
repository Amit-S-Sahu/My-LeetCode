class Solution {
    public int countOfSubstrings(String word, int k) {
        HashSet<Character> temp = new HashSet<>();
        temp.add('a');
        temp.add('e');
        temp.add('i');
        temp.add('o');
        temp.add('u');

        int len = word.length();  
        int count = 0;      

        for (int i = 0; i < len; i++) {
            HashSet<Character> exists = new HashSet<>();  
            int cons = 0;               
            for (int j = i; j < len; j++) {
                char c = word.charAt(j);  
                if (temp.contains(c)) {
                    exists.add(c);
                } else {
                    cons++;
                }
                if (exists.size() == 5 && cons == k) {
                    count++;  
                }
                if (cons > k) {
                    break;
                }
            }
        }
        return count;
    }
}