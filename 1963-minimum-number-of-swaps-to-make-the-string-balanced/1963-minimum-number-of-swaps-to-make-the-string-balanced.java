class Solution {
    public int minSwaps(String s) {
        int open = 0;
        int more = 0;

        for (Character c : s.toCharArray()) {
            if (c == '[') open++;
            else {
                if (open > 0) open--;
                else more++;
            }
        }  
        return (more / 2) + (more % 2);
    }
}