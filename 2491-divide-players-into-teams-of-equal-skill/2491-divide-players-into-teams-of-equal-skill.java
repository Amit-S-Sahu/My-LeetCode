class Solution {
    public long dividePlayers(int[] skill) {
        if ((skill.length % 2 != 0) || skill.length == 0) return -1;
        if (skill.length == 2) return (long) skill[0] * skill[1];
        long ans = 0;
        Arrays.sort(skill);
        int left = 0, right = skill.length - 1;
        int reqd = skill[left] + skill[right];

        while (left < right) {
            if (skill[left] + skill[right] != reqd) return -1;
            else ans += (skill[left] * skill[right]);
            left++;
            right--;
        }

        return ans;
    }
}