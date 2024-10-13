class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            minHeap.offer(new int[]{nums.get(i).get(0), i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }

        int[] small = new int[]{0, Integer.MAX_VALUE};

        while (true) {
            int[] curr = minHeap.poll();
            int curMin = curr[0], listIdx = curr[1], elemIdx = curr[2];

            if ((max - curMin < small[1] - small[0]) ||
                (max - curMin == small[1] - small[0] && curMin < small[0])) {
                small[0] = curMin;
                small[1] = max;
            }

            if (elemIdx + 1 < nums.get(listIdx).size()) {
                int nextVal = nums.get(listIdx).get(elemIdx + 1);
                minHeap.offer(new int[]{nextVal, listIdx, elemIdx + 1});
                max = Math.max(max, nextVal);
            } 
            else break;
        }
        return small;
    }
}