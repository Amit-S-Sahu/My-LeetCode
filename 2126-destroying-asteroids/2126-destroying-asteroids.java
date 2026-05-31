class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long curr = mass;
        for (int asteroid : asteroids) {
            if (curr < asteroid) return false;
            curr += asteroid;
        }
        return true;
    }
}