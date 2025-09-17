class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];
        leftMax[0] = 0;
        rightMax[n - 1] = 0;
        for (int i = 1; i < n; i++) leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        for (int i = n - 2; i >= 0; i--) rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            int water = min - height[i];
            if (water > 0) ans += water;
        }

        return ans;
    }
}