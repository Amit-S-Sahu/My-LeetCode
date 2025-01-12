class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) return false;
        int min = 0, max = 0;
        for (int i = 0; i < n; i++) {
            boolean open = s.charAt(i) == '(';
            boolean unlocked = locked.charAt(i) == '0';
            min += (!open || unlocked) ? -1 : 1;
            max += (open || unlocked) ? 1 : -1;
            
            if (max < 0) return false;
            min = Math.max(min, 0);
        }
        return min == 0;
    }
}