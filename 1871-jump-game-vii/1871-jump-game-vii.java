class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) != '0') return false;

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int farthest = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            int start = Math.max(curr + minJump, farthest + 1);
            int end = Math.min(curr + maxJump, n - 1);

            for (int i = start; i <= end; i++) {
                if (s.charAt(i) == '0') {
                    if (i == n - 1) return true;
                    q.offer(i);
                }
            }
            farthest = end;
        }

        return false;
    }
}