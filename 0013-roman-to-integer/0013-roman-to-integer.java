class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        int i = 0;
        int ans = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'I') {
                if ((i + 1) < s.length() && s.charAt(i + 1) == 'V') {
                    ans += 4;
                    i += 2;
                }
                else if ((i + 1) < s.length() && s.charAt(i + 1) == 'X') {
                    ans += 9;
                    i += 2;
                }
                else {
                    ans += values.get('I');
                    i++;
                }
            }
            else if (s.charAt(i) == 'X') {
                if ((i + 1) < s.length() && s.charAt(i + 1) == 'L') {
                    ans += 40;
                    i += 2;
                }
                else if ((i + 1) < s.length() && s.charAt(i + 1) == 'C') {
                    ans += 90;
                    i += 2;
                }
                else {
                    ans += values.get('X');
                    i++;
                }
            }
            else if (s.charAt(i) == 'C') {
                if ((i + 1) < s.length() && s.charAt(i + 1) == 'D') {
                    ans += 400;
                    i += 2;
                }
                else if ((i + 1) < s.length() && s.charAt(i + 1) == 'M') {
                    ans += 900;
                    i += 2;
                }
                else {
                    ans += values.get('C');
                    i++;
                }
            }
            else {
                ans += values.get(s.charAt(i));
                i++;
            }
        }        
        return ans;
    }
}