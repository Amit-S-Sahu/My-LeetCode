class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int arr[] = new int[n + 1];
        
        for (int shift[] : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = (shift[2] == 1) ? 1 : -1;

            arr[start] += direction;
            arr[end + 1] -= direction;
        }
        
        int curr = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            curr += arr[i];
            int ch = (s.charAt(i) - 'a' + curr % 26 + 26) % 26 + 'a';
            sb.append((char)ch);
        }
        
        return sb.toString();
    }
}
