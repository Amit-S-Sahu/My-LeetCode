import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        Integer temp[] = new Integer[score.length];
        for (int i = 0; i < score.length; i++) temp[i] = score[i];
        
        Arrays.sort(temp, Collections.reverseOrder());
        
        String ans[] = new String[score.length];
        List<Integer> list = Arrays.asList(temp);
        for (int i = 0; i < score.length; i++) {
            int currentScore = score[i];
            int rank = list.indexOf(currentScore) + 1;
            
            if (rank == 1) {
                ans[i] = "Gold Medal";
            } else if (rank == 2) {
                ans[i] = "Silver Medal";
            } else if (rank == 3) {
                ans[i] = "Bronze Medal";
            } else {
                ans[i] = String.valueOf(rank);
            }
        }
        return ans;
    }
}
