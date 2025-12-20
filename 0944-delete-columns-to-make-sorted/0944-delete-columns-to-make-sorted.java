class Solution {
    private boolean isSorted(char ch[]) {
        for (int i = 1; i < ch.length; i++) {
            if (ch[i] < ch[i - 1]) return false;
        }
        return true;
    }

    public int minDeletionSize(String[] strs) {
        int n = strs[0].length();
        StringBuilder arr[] = new StringBuilder[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = new StringBuilder();
            for (String str : strs) {
                arr[i].append(str.charAt(i));
            }
            if (!isSorted(arr[i].toString().toCharArray())) ans++;
        }
        return ans;
    }
}