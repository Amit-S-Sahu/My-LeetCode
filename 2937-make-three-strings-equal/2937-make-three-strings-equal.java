class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int i = 0, n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        while (i < n1 && i < n2 && i < n3 && s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)) {
            i++;
        }
        if (i == 0) return -1;
        return (n1 - i) + (n2 - i) + (n3 - i);
    }
}
