class Solution {
    HashSet<Integer> set;
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;

        set = new HashSet<>();
        for (String num : nums) {
            set.add(Integer.parseInt(num, 2));
        }

        int total = (int)Math.pow(2, n);
        for (Integer i = 0; i < total; i++) {
            if (!set.contains(i)) return String.format("%" + n + "s", Integer.toBinaryString(i)).replace(' ', '0');
        }

        return "";
    }
}