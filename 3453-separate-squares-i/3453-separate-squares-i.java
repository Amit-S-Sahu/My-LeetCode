class Solution {
    public double separateSquares(int[][] squares) {
        int minY = squares[0][1], maxY = squares[0][1];
        for (int square[] : squares) {
            minY = Math.min(minY, square[1]);
            maxY = Math.max(maxY, square[1] + square[2]);
        }

        double left = minY, right = maxY;
        for (int i = 0; i <= 80; i++) {
            double mid = left + (right - left) / 2.0;
            double low = 0.0, high = 0.0;
            for (int square[] : squares) {
                double start = square[1];
                double side = square[2];
                double end = square[1] + square[2];
                if (start < mid) {
                    if (end <= mid) low += (side * side);
                    else {
                       low += ((mid - start) * side);
                       high += ((end - mid) * side);
                    }
                }
                else high += (side * side);
            }
            
            if (low >= high) right = mid;
            else left = mid;
        }
        return right;
    }
}