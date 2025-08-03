class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int row = 0;
        while (row < n && target >= matrix[row][0]) row++;
        row--;
        if (row < 0) return false;

        int left = 0, right = m - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) return true;
            else if (matrix[row][mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}
