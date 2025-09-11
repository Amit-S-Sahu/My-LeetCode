class Solution {
    public String sortVowels(String s) {
        Set<Character> set = Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
        List<Character> vowels = new ArrayList<>();

        for (char c : s.toCharArray()) if (set.contains(c)) vowels.add(c);

        Collections.sort(vowels);
        StringBuilder result = new StringBuilder();
        int i = 0;

        for (char c : s.toCharArray()) {
            if (set.contains(c)) result.append(vowels.get(i++));
            else result.append(c);
        }

        return result.toString();
    }
}