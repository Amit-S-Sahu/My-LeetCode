class Solution {
    private double memo[][];

    private double helper(int a, int b) {
        if (a <= 0 && b > 0) return 1;
        if (a <= 0 && b <= 0) return 0.5;
        if (b <= 0 && a >= 0) return 0;
        if (memo[a][b] != -1) return memo[a][b];

        double ch1 = helper(a - 4, b - 0);
        double ch2 = helper(a - 3, b - 1);
        double ch3 = helper(a - 2, b - 2);
        double ch4 = helper(a - 1, b - 3);

        return memo[a][b] = 0.25 * (ch1 + ch2 + ch3 + ch4);
    }

    public double soupServings(int n) {
        if (n > 4800) return 1;

        int y = (int) Math.ceil((double) n / 25.0);

        memo = new double[y + 1][y + 1];
        for (int i = 0; i <= y; i++) {
            for (int j = 0; j <= y; j++) {
                memo[i][j] = -1;
            }
        }

        return helper(y, y);
    }
}