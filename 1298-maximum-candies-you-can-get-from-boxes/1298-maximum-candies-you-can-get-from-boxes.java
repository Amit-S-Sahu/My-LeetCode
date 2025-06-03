class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Queue<Integer> boxQueue = new LinkedList<>();
        Set<Integer> seenBoxes = new HashSet<>();
        Set<Integer> openedBoxes = new HashSet<>();
        for (int b : initialBoxes) boxQueue.add(b);

        int totalCandies = 0;

        while (!boxQueue.isEmpty()) {
            int size = boxQueue.size();
            boolean progress = false;
            for (int i = 0; i < size; i++) {
                int box = boxQueue.poll();
                if (!openedBoxes.contains(box) && status[box] == 1) {
                    progress = true;
                    totalCandies += candies[box];
                    openedBoxes.add(box);
                    for (int k : keys[box]) status[k] = 1;
                    for (int b : containedBoxes[box]) {
                        if (seenBoxes.add(b)) boxQueue.add(b);
                    }
                } 
                else boxQueue.add(box);
            }
            if (!progress) break;
        }
        return totalCandies;
    }
}
