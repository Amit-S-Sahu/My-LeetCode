class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;
        int left = 0;
        int right = arr.length - 1;

        while (left < arr.length - 2 && arr[left] < arr[left + 1]) left++;
        while (right > 0 && arr[right] < arr[right - 1]) right--;

        return left == right && left != 0 && right != arr.length - 1;
    }
}
