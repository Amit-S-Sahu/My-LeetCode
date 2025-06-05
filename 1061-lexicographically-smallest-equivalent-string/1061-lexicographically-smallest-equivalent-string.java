class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();

        HashMap<Character, Set<Character>> charMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            charMap.computeIfAbsent(s1.charAt(i), val -> new HashSet<Character>()).add(s2.charAt(i));
            charMap.computeIfAbsent(s2.charAt(i), val -> new HashSet<Character>()).add(s1.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        HashMap<Character, Character> smallestMap = new HashMap<>();
        for (char c : baseStr.toCharArray()) {
            char smallestChar = smallestMap.containsKey(c) ? smallestMap.get(c) : searchSmallest(c, charMap, new HashSet<Character>(Arrays.asList(c)));
            smallestMap.put(c, smallestChar);
            sb.append(smallestChar);
        }

        return sb.toString();
    }

    private char searchSmallest(char c, HashMap<Character, Set<Character>> charMap, Set<Character> visited) {
        if (!charMap.containsKey(c)) return c;
        
        char smallestChar = c;
        for (char charKey : charMap.get(c)) {
            if (!visited.contains(charKey)){
                visited.add(charKey);
                char charVal = searchSmallest(charKey, charMap, visited);
                smallestChar = smallestChar < charVal ? smallestChar : charVal;
            }
        }

        return smallestChar;
    }
}