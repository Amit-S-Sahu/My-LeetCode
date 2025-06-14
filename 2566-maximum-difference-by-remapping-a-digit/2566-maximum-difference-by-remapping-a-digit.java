class Solution {
    public int minMaxDifference(int num) {
        String temp = String.valueOf(num);
        boolean replaced = false;
        int i = 0;
        String min = temp, max = temp;
        while (!replaced && i < temp.length()) {
            if (temp.charAt(i) == '9') {
                i++;
                continue;
            }
            max = temp.replace(temp.charAt(i), '9');
            replaced = true;
            i++;
        }
        min = temp.replace(temp.charAt(0), '0');
        return Integer.valueOf(max) - Integer.valueOf(min);
    }
}