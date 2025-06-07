class Solution {
    public String clearStars(String s) {
        StringBuilder sb = new StringBuilder(s);
        TreeMap<Character , PriorityQueue<Integer>> dict = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (sb.charAt(i) == '*') {
                if (dict.isEmpty()) continue;
                char ch = dict.firstKey();
                PriorityQueue<Integer> pq = dict.get(ch);
                int idx = pq.poll();
                if (pq.isEmpty()) dict.remove(ch);
                else dict.put(ch, pq);
                sb.replace(idx, idx + 1, "@");
            }
            else {
                if (Character.isLetter(sb.charAt(i))){
                dict.computeIfAbsent(sb.charAt(i), k -> new PriorityQueue<>(Collections.reverseOrder())).add(i);
                }
            }

        }
        
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '@' || sb.charAt(i) == '*') {
                sb.deleteCharAt(i);
                i--;
            }
        }

        return sb.toString();
    }
}