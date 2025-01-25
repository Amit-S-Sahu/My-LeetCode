class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int ans[] = new int[n];

        int sorted[][] = new int[n][];
        for(int i = 0; i < n; i++){
            sorted[i] = new int[]{nums[i], i};
        }
        
        Arrays.sort(sorted, (a,b)->a[0]-b[0]);

        Map<Integer, Deque<Integer>> map = new HashMap<>();

        int group[] = new int[n];
        int groupNum = 0;

        group[sorted[0][1]] = groupNum;
        map.put(groupNum, new ArrayDeque<>());
        map.get(groupNum).addLast(sorted[0][0]);


        for(int i = 1; i < n; i++) {
            if (sorted[i][0] - map.get(groupNum).getLast() <= limit) {
                map.get(groupNum).addLast(sorted[i][0]);
                group[sorted[i][1]] = groupNum;
            }
            else {
                groupNum++;
                map.put(groupNum, new ArrayDeque<>());
                map.get(groupNum).addLast(sorted[i][0]);
                group[sorted[i][1]] = groupNum;
            }
        }


        for(int i = 0; i < n; i++) {
            ans[i] = map.get(group[i]).pollFirst();
        }

        return ans;
    }
}