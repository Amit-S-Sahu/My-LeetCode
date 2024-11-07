class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return ans;

        HashMap<Character, ArrayList<Character>> map = new HashMap<>();
        map.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        map.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        map.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        map.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        map.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        map.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        map.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        map.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));

        backtrack(digits, 0, new StringBuilder(), map);
        return ans;
    }

    private void backtrack(String digits, int i, StringBuilder curr, HashMap<Character, ArrayList<Character>> map) {
        if (i == digits.length()) {
            ans.add(curr.toString());
            return;
        }

        char digit = digits.charAt(i);
        ArrayList<Character> letters = map.get(digit);

        for (char letter : letters) {
            curr.append(letter); 
            backtrack(digits, i + 1, curr, map);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
