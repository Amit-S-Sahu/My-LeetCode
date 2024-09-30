class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length -1;
        int max = Integer.MIN_VALUE;
        while (left < right) {
            int width = right - left;
            int len = Math.min(height[right], height[left]);
            max = Math.max(max, len * width);

            if (height[left] < height[right]) left++;
            else right--;
        }

        return max;
    }
}