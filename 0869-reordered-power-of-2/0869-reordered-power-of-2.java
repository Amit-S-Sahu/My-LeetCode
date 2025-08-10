class Solution {
    public boolean reorderedPowerOf2(int n) {
        if ((n & (n - 1)) == 0) return true;
        String s = sortString(String.valueOf(n));
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= 1000000000; i <<= 1) {
            set.add(sortString(String.valueOf(i)));
            if (set.contains(s)) return true;
        }
        return false;
    }

    private String sortString(String str) {
        char arr[] = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}