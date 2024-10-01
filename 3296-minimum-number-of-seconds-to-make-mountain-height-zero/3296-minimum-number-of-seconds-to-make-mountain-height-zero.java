class Solution {
    private boolean ispos(long maxTime, int mountainHeight, int[] workerTimes) {
        long s = 0;
        for (int t : workerTimes) {
            int h = 0;
            long c = 0;
            while (c + (long)(h + 1) * t <= maxTime) {
                h++;
                c += (long)h * t;
            }
            s += h;
            
            if (s >= mountainHeight) {
                return true;
            }
        }
        return s >= mountainHeight;
    }
    
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long l = 0;
        long r = 1L;
        while (!ispos(r, mountainHeight, workerTimes)) {
            r *= 2;
        }
        
        while (l < r) {
            long m = l + (r - l) / 2;
            if (ispos(m, mountainHeight, workerTimes)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}