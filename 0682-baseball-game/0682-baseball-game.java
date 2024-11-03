class Solution {
    public int calPoints(String[] operations) {
        int arr[] = new int[operations.length];
        int i = 0;

        for (String input : operations) {
            switch (input) {
                case "C" -> i--;
                case "D" -> {
                    arr[i] = arr[i - 1] * 2;
                    i++;
                }
                case "+" -> {
                    arr[i] = arr[i - 1] + arr[i - 2];
                    i++;
                }
                default -> {
                    arr[i] = Integer.parseInt(input);
                    i++;
                }
            }
        }
        
        int sum = 0;
        for (int j = 0; j < i; j++) sum += arr[j];

        return sum;
    }
}