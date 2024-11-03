class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) return 0;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) leftMax[i] = Math.max(height[i], leftMax[i - 1]);

        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) rightMax[i] = Math.max(height[i], rightMax[i + 1]);

        int trappedWater = 0;
        for (int i = 0; i < height.length; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }
}